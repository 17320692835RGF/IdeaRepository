import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import java.io.IOException;

public class hadoop {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.130.100:9000");//这里填写你的hdfs端口
        FileSystem fs = FileSystem.get(conf);
        System.out.println(fs);
        FSDataInputStream fis = fs.open(new Path("/user/output1/part-r-00000"));
        IOUtils.copyBytes(fis,System.out,4096*10,true);
//        copyFile(fs);
//        listFile(fs);
//        renameFile(fs);
//        existsFile(fs);
//        deleteFile(fs);
//        existsFile(fs);
//        FSDataInputStream fis = fs.open(new Path("/bb"));
//        IOUtils.copyBytes(fis, System.out, 4096, true);
    }
    public static void copyFile(FileSystem hdfs) throws IOException {
        System.out.println(" -----copy file-----");
        Path src = new Path("1987_600.csv");
        Path dest = new Path("/user/input");
        hdfs.mkdirs(dest);
        hdfs.copyFromLocalFile(src, dest);
    }
    public static void listFile(FileSystem hdfs) throws IOException {
        System.out.println(" -----list file-----");
        Path path = new Path("/");
        FileStatus files[] = hdfs.listStatus(path);
        for (FileStatus file : files) {
            System.out.println(file.getPath());
        }
    }
    public static void renameFile(FileSystem hdfs) throws IOException {
        System.out.println(" -----rename file-----");
        Path path = new Path("/user/root/install.log");
        Path toPath = new Path("/user/root/install.log.bak");
        boolean result = hdfs.rename(path, toPath);
        System.out.println("Rename file success? " + result);
    }
    public static void deleteFile(FileSystem hdfs) throws IOException {
        System.out.println(" -----delete file-----");
        Path path = new Path("/user/root/install.log.bak");
        boolean result = hdfs.delete(path, false);
        System.out.println("Delete file success?" + result);
    }
    public static void existsFile(FileSystem hdfs) throws IOException {
        System.out.println("-----exists file-----");
        Path path = new Path("/user/root/install.log.bak");
        boolean result = hdfs.exists(path);
        System.out.println("File exist?" + result);
    }
}

