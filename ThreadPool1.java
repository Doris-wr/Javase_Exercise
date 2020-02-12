package 多线程.新增创建线程方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:wangrui
 * @Date:2020/2/9 20:31
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
             //设置线程池的属性
       //service1.setCorePoolSize(15);
       //service1.setKeepAliveTime();//设置活跃时间
        //2 提供指定的线程的操作，需要提供实现Runnable接口或者Callable接口实现类
        service.execute(new NumberThread());//适合用于Runnable
        service.execute(new NumberThread1());//适合用于Runnable
        //3 关闭连接池
        service.shutdown();
    }
}
