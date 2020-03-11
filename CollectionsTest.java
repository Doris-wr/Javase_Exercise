package Collections工具类;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author:wangrui
 * @Date:2020/3/11 0:06
 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);
//        Collections.reverse(list);//反转list元素的顺序
//        Collections.shuffle(list);//对list进行随机排序
//        Collections.swap(list,1,2);//交换其中的两个元素
        //下面写法报异常
        /* List dest=new ArrayList();
         Collections.copy(dest,list);*/
        List dest= Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

        //返回的list1即为线程安全的list
        List list1= Collections.synchronizedList(list);
    }
}
