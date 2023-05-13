package Thread_Test;

public class unsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"乙").start();
        new Thread(buyTicket,"甲").start();
        new Thread(buyTicket,"丙").start();
    }
}

class BuyTicket implements Runnable{
    //票
    private static int ticketNums = 20;
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while(flag)
        {
            try {
                buy();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    public  void buy() throws InterruptedException {
    public synchronized void buy() throws InterruptedException {
        //判断是否有票

        if(ticketNums <=0)
        {
            flag = false;
            return ;
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"拿到票"+ticketNums--);
    }
}