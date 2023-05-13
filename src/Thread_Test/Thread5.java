package Thread_Test;

import java.util.Objects;

//模拟龟兔赛跑
public class Thread5 implements  Runnable{
    private static int length = 100;
    private static  String winner;
    @Override
    public void run() {


        for(int i = 1 ;i <= length;i++)
        {
            // 模拟兔子休息
            if(Objects.equals(Thread.currentThread().getName(), "兔子") && i%10==0)
            {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(race(i))
            {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"走到了第"+i+"步");
        }

    }

    private boolean race(int steps)
    {
        if(winner != null)
        {
            //有胜利者了

            return true;
        }
        else{
            if(steps==100)
            {
                winner = Thread.currentThread().getName();
                System.out.println("winner is :"+winner);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Thread5  thread5 = new Thread5();
        new Thread(thread5,"兔子").start();
        new Thread(thread5,"王八").start();

    }
}
