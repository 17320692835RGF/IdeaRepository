
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

public class RecommendFriend {
    public static class FriendMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] names = value.toString().split(",");
            String name = names[0];
            for (int i = 1; i < names.length; i++) {
                String fkey = getKey(name, names[i]);
                context.write(new Text(fkey), new Text("0"));
            }
            for (int i = 1; i < names.length; i++) {
                for (int j = i + 1; j < names.length; j++) {
                    String fkey = getKey(names[i], names[j]);
                    context.write(new Text(fkey), new Text(name));
                }
            }
        }

        public static String getKey(String name1, String name2) {
            if (name1.compareTo(name2) < 0) {
                return name1 + ":" + name2;
            } else {
                return name2 + ":" + name1;
            }
        }
    }

    public static class FriendReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            boolean flag = true;
            String firends = "";
            for (Text value : values) {
                if (value.toString().equals("0")) {
                    flag = false;
                }
                firends = firends + " " + value;
            }
            if (flag) {
                context.write(key, new Text(firends));
            }
        }
    }

    private static void removeOutputPath(Configuration conf, String output) throws IOException {
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path(output);
        hdfs.delete(path, true);
    }

    private static Job createFriendRecomJob(Configuration conf, String input, String output) throws IOException {
        Job job = new Job(conf, "FriendRecommend");
        job.setJarByClass(RecommendFriend.class);
        job.setMapperClass(FriendMapper.class);
        job.setReducerClass(FriendReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));
        return job;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.130.100:9000");//这里填写你的hdfs端口
        FileSystem fs = FileSystem.get(conf);
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length != 2) {
            System.err.println("Usage: FriendRecommend <in> <out>");
            System.exit(2);
        }
        removeOutputPath(conf, otherArgs[1]);
        Job job = createFriendRecomJob(conf, otherArgs[0], otherArgs[1]);
        job.waitForCompletion(true);

        FSDataInputStream fis = fs.open(new Path("/output/part-r-00000"));
        IOUtils.copyBytes(fis,System.out,4096*10,true);

        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }
}
