//面试题：按序打印——>多线程
public class OneTwoThree {
    private static class Foo {
        private int n=0;
        //虽然n不为0，但不让出CPU，导致n无法及时变化
        public void oneVersion1() {
            synchronized(this) {
                if (n != 0) {
                    return;
                }
                System.out.println("one");
                n = 1;
            }
        }
        //减少了锁的开销
        public void oneVersion2(){
            if(n!=0){
                return;
            }
            System.out.println("one");
            n=1;
        }
        //条件不满足时及时释放CPU，但是还参与CPU的争夺
        public void oneVersion3(){
            if(n!=0){
                Thread.yield();
                return;
            }
            System.out.println("one");
            n=1;
        }
        //条件不满足，让出CPU，不再参与CPU的争夺
        public void oneVersion4() throws InterruptedException {
            if(n!=0){
                synchronized(this){
                    wait();
                }
                return;
            }
        }
        public void two() {
            if(n!=1){
                return;
            }
            System.out.println("two");
            n=2;
        }

        public void three() {
            if(n!=2){
                return;
            }
            System.out.println("three");
            n=0;
        }
    }

    private static Foo foo = new Foo();

    private static class OneThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.oneVersion1();
            }
        }
    }

    private static class TwoThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.two();
            }
        }
    }

    private static class ThreeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                foo.three();
            }
        }
    }
    public static void main(String[] args) {
        Thread one = new OneThread();
        Thread two = new TwoThread();
        Thread three = new ThreeThread();
        one.start();
        two.start();
        three.start();
    }
}
