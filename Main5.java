package File;
 import java.io.File;
public class Main {
    public static void main(String[] args) {
        String path="D:\\MyJava\\JavaWeb\\src\\File";
        File file=new File(path);
        System.out.println(file.isHidden());
        System.out.println(file.length());
        String destpath="D:\\MyJava\\JavaWeb\\src\\File";
        File dest=new File(destpath);
        file.renameTo(dest);


       /* //两种创建方式
        File file=new File("D:\\MyJava\\JavaWeb\\src\\File","测试目录");
        File file2=new File("D:\\MyJava\\JavaWeb\\src\\File\\测试目录");
        System.out.println("是否存在:"+file.exists());
        System.out.println("是否是文件夹:"+file.isDirectory());
        System.out.println("该盘符的空闲空间："+file.getFreeSpace());
        System.out.println();*/
    }
}
