package Thread_Test;

//模拟网络延时  放大问题的发生性
public class ThreadSleep implements Runnable{
    private int tickets = 10;

    @Override
    public void run() {
        while(tickets > 0 )
        {
            if(tickets<0)
            {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+ "拿到了第"+tickets+"张票");
            tickets--;
        }
    }
    public static void main(String[] args) {
        //会有冲突
        Thread4 thread4 = new Thread4();
        new Thread(thread4,"小明").start();
        new Thread(thread4,"小李").start();
        new Thread(thread4,"小刘").start();
    }
}
