package 多线程.练习.生产者消费者问题;

/**
 * 线程通信的应用：经典例题——生产者/消费者问题
 *
 *
 * 生产者将产品交给店员，而消费者从店员处取走产品
 * 店员一次只能持有固定数量的产品（比如20），如果生产者试图生产更多的产品，店员会叫生产者停一下
 * 如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员告诉消费者等一下
 * 如果店中有产品了在通知消费者来取走产品。
 * @Author:wangrui
 * @Date:2020/2/9 18:19
 */
class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"开始生产第"+productCount+"个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//生产者
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始生产产品……");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
//消费者
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费产品……");
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("生产者");
        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2=new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
