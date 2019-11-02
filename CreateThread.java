public class CreateThread{
    private static class p1 extends Thread{
        private int count=100_0000;
        @Override
        public void run() {
            long sum=0;
            for(int i=0;i<count;i++){
                sum+=i;
            }
            System.out.println(sum);
        }
    }
    private static class p2 extends Thread{
        private int count=100_0000;
        @Override
        public void run() {
            long sum=0;
            for(int i=0;i<=count;i+=2){
                sum+=i;
            }
            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        long begin=System.currentTimeMillis();
        Thread t1=new p1();
        Thread t2=new p2();
        t1.start();
        t2.start();
        long end=System.currentTimeMillis();
        System.out.println((end-begin)*1.0/1000);
    }
}
