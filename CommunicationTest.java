package 多线程.练习.线程通信;

/**
 * @Author:wangrui
 * @Date:2020/2/9 17:36
 */

class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ";" + number);
                    number++;
                    try {
                        //使得调用wait（）方法的线程进入阻塞状态
                        wait();//执行wait（）的线程会阻塞并且释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
