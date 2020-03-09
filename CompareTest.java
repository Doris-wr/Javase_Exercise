package 排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:wangrui
 * @Date:2020/3/8 20:19
 */
public class CompareTest {
    //像String，包装类等实现了Comparable接口，重写了comparaTo(obj)方法，给出了比较两个对象的方法
    @Test
    public void test(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("dellMouse",43);
        arr[2]=new Goods("xiaomiMouse",12);
        arr[3]=new Goods("huawei",65);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test3(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr,new Comparator(){
            //按照字符串从大到小的顺序牌排
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String &&o2 instanceof String){
                    String s1=(String)o1;
                    String s2=(String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("lenovoMouse",34);
        arr[1]=new Goods("dellMouse",43);
        arr[2]=new Goods("xiaomiMouse",12);
        arr[3]=new Goods("huawei",65);
        Arrays.sort(arr, new Comparator<Goods>() {
            //指明商品比较大小的方式：先按照产品名称从低到高排序，再按照价格从高到底排序
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1 instanceof Goods&&o2 instanceof Goods){
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
    }
}
