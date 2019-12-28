package File;
import java.io.File;
//需求：列出指定目录中的所有的文件，包括文件夹中的所有文件（使用递归算法）
public class FileDemo2 {
    //使用非递归方法
    private static void listAllFile(File f){
        //第一级
        File[] fs=f.listFiles();
        for(File file:fs){
            System.out.println(file);
            //第二级
            if(file.isDirectory()){
                File[] fs2=file.listFiles();
                for(File file2:fs2){
                    System.out.println(file2);
                    //第三级
                    if(file2.isDirectory()){
                        File[] fs3=file2.listFiles();
                        for(File file3:fs3){
                            System.out.println(file3);
                        }
                    }
                }
            }
        }
    }
    //使用递归的方法
    private static void listAllFiles(File f){
        System.out.println(f);
        //第一级子文件
        File[] fs=f.listFiles();
        for(File file:fs){
            //如果子文件是文件，则打印
            System.out.println(file);
            //日过子文件是目录，则继续递归
            if(file.isDirectory()){
                listAllFiles(file);
            }

        }
    }
    public static void main(String[] args) {
        File dir=new File("D:/比特学习必备");
       //listAllFile(dir);
        listAllFiles(dir);
    }
}
