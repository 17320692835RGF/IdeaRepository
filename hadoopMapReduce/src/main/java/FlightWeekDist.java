import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class FlightWeekDist {

    // 分析航班的每周星期的航班次数
    public static class FlightNumMapper extends Mapper<Object, Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);
        private Text dateofWeek = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] fields = value.toString().split(",");
            try {
                int  year = Integer.parseInt(fields[0]);  //filter first raw
            } catch (NumberFormatException e) { return;}
            dateofWeek.set(fields[3]);    // date of week
            context.write(dateofWeek, one);
        }
    }
    // 分析航班中每一个航班每周的航程里数的map函数
    public static class FlightMilesMapper extends Mapper<Object, Text, Text, IntWritable>{
        private IntWritable Miles = new IntWritable();
        private Text FlightNum = new Text();

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String[] fields = value.toString().split(",");
            try {
                int  year = Integer.parseInt(fields[0]);  //filter first raw
            } catch (NumberFormatException e) { return;}
            String flight = fields[8]+fields[9];
            FlightNum.set(flight);    // class name
            int miles = 0;
            try {
                miles = Integer.parseInt(fields[18]);  //filter first raw
            } catch (NumberFormatException e) { }
            Miles.set(miles);
            context.write(FlightNum, Miles);
        }
    }
    //Reduce函数 两个map公用
    public static class FlightSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    //如果文件夹存在，则删除文件夹
    private static void removeOutputPath(Configuration conf,
                                         String output1, String output2) throws IOException {
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path(output1);
        hdfs.delete(path, true);

        path = new Path(output2);
        hdfs.delete(path, true);
    }
    //创建航班数目的工作
    private static Job createFlightNumJob(Configuration conf,
                                          String input, String output) throws IOException {
        Job job = new Job(conf, "Flight Numbers");
        job.setJarByClass(FlightWeekDist.class);

        job.setMapperClass(FlightNumMapper.class);
        job.setCombinerClass(FlightSumReducer.class);
        job.setReducerClass(FlightSumReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));

        return job;
    }

    private static Job createFlightMilesJob(Configuration conf,
                                            String input, String output) throws IOException {
        Job job = new Job(conf, "Flight Milse");
        job.setJarByClass(FlightWeekDist.class);

        job.setMapperClass(FlightMilesMapper.class);
        job.setCombinerClass(FlightSumReducer.class);
        job.setReducerClass(FlightSumReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(input));
        FileOutputFormat.setOutputPath(job, new Path(output));

        return job;
    }
    //主函数
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://192.168.130.100:9000");//这里填写你的hdfs端口
        FileSystem fs = FileSystem.get(conf);
        String[] otherArgs = new GenericOptionsParser(conf, args)
                .getRemainingArgs();
        if (otherArgs.length != 3) {
            System.err.println(otherArgs.length);
            for(String str:otherArgs) {
                System.err.println(str);
            }
            System.err.println("Usage: ScoreAnalysis <in> <out1> <out2>");
            System.exit(2);
        }
        //1987_600.csv 1.txt 2.txt

        removeOutputPath(conf, otherArgs[1], otherArgs[2]);
        Job job = createFlightNumJob(conf, otherArgs[0], otherArgs[1]);
        job.waitForCompletion(true);

        job = createFlightMilesJob(conf, otherArgs[0], otherArgs[2]);
        job.waitForCompletion(true);

        FSDataInputStream fis = fs.open(new Path("/user/output2/part-r-00000"));
        IOUtils.copyBytes(fis,System.out,4096*10,true);


    }

}
