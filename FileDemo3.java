package File;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//列出文件的分层结构
public class FileDemo3 {
    //期望效果：比特科技>java>课件>网络
    public static void main(String[] args) {
        String file = "D:\\课件\\测试课件\\abc\\123";
        File f = new File(file);
        List<String> parentNames = new ArrayList<String>();
        listAllParent(parentNames,f);
        System.out.println(parentNames);
        Collections.reverse(parentNames);//颠倒list元素顺序
        StringBuilder sb=new StringBuilder(40);
        for(String name:parentNames){
            sb.append(name).append(">");
        }
       sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    private static void listAllParent(List<String>parentNames,File f){
        if(!"".equals(f.getParentFile().getName())) {
           parentNames.add( f.getParentFile().getName());
        }
        if(f.getParentFile().getParentFile()!=null){
            listAllParent(parentNames,f.getParentFile());
        }
    }
}
