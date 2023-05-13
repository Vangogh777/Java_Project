package Thread_Test;

//join : 想像成插队
public class ThreadJoin implements Runnable{
    @Override
    public void run(){
        for(int i = 0;i<100;i++)
        {
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
//        new Thread(threadJoin).start();
        Thread thread = new Thread(threadJoin);
        thread.start();

        for(int i = 0;i<500;i++)
        {
            if(i==200)
            {
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}
