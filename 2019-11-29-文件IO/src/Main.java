import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       /* String path = "E:\\比特科技\\课程\\JavaWeb\\Java11班\\2019-11-29-文件IO\\测试目录\\隐藏文件.txt";
        File file = new File(path);
        System.out.println(file.isHidden());*/
        /*
        String path = "E:\\比特科技\\课程\\JavaWeb\\Java11班\\2019-11-29-文件IO";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
        */
        /*
        String parent = "/Users/yanyan/Desktop/insist/2019-11-29-文件IO/测试目录";
        File file = new File(parent, "1\\2\\3\\test.txt");
        file.mkdirs();
        */
        /*
        file.createNewFile();
        file.delete();
        file.deleteOnExit();
        */
        File file = new File("/Users/yanyan/Desktop/insist/2019-11-29-文件IO/测试目录");
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否是文件夹:" + file.isDirectory());
        System.out.println("该盘符的空闲空间: " + file.getFreeSpace());
        System.out.println("该盘符的可用空间: " + file.getUsableSpace());
        System.out.println("该盘符的总空间: " + file.getTotalSpace());
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("上一级路径:" + file.getParent());
        System.out.println("可读: " + file.canRead());
        System.out.println("可写: " + file.canWrite());
        System.out.println("可执行: " + file.canExecute());
    }
}
