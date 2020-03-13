package Collection;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author:wangrui
 * @Date:2020/3/10 13:27
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set=new TreeSet();
        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",23));
        //方式1：打印结果：-34  8  11   34  43，即按照对象的属性进行排序
       /* set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);*/
        //方式2
        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",32));
        set.add(new Person("Jim",2));
        set.add(new Person("Mike",65));
        set.add(new Person("Jack",35));
        set.add(new Person("Jack",56));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person&&o2 instanceof Person){
                    Person p1=(Person)o1;
                    Person p2=(Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };
        TreeSet set=new TreeSet(com);
        set.add(new Person("Tom",12));
        set.add(new Person("Jerry",32));
        set.add(new Person("Jim",2));
        set.add(new Person("Mike",65));
        set.add(new Person("Mary",65));
        set.add(new Person("Jack",35));
        set.add(new Person("Jack",56));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
