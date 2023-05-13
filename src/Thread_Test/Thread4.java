package Thread_Test;

//并发问题 实现买火车票
public class Thread4 implements Runnable{
    private int tickets =20;
    @Override
    public void run() {
        while(true)
        {
            if(tickets<=0)
            {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+ "拿到了第"+ tickets+"张票");
            tickets = tickets - 1;
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
