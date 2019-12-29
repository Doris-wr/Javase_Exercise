package File;
import java.io.File;
import java.util.Comparator;

 class TreeNode {
    File file;
    long totalLength;//汇总了该文件夹下所有的的大小
    List<TreeNode>children=new ArrayList<>();
}

public class ScannerFile {
    public static void scannerDirectory(TreeNode node){
        File[] files= node.file.listFiles();
        if(files==null){
            return;
        }
        for(File file:files){
            TreeNode child=new TreeNode();
            child.file=file;
            if(file.isDirectory()){
                scannerDirectory(child);
            }else{
                child.totalLength=file.length();
            }
            node.children.add(child);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        root.file=new File("D:/课件");
        scannerDirectory(root);
        report(root,0);
    }

    private static void report(TreeNode root, int level) {
        for(int i=0;i<level*4;i++){
            System.out.println(" ");
        }
        if(level==0){
            System.out.println(root.file.getAbsolutePath());
        }else{
            System.out.println(root.file.getName());
        }
        if(root.file.isDirectory()){
            System.out.print("\\");
        }
        String unit="字节";
        double length=root.totalLength;
        if(length>1024*1024*1024){
            unit="G字节";
            length=length/1024/1024/1024;
        }else if(length>1024*1024){
            unit="M字节";
            length=level/1024/1024;
        }else if(length>1024){
            unit="字节";
            length=length/1024;
        }
        System.out.println("    "+root.totalLength);
        for(TreeNode node:root.children){
            report(node,level+1);
        }
    }
}
