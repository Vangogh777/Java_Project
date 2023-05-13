package Thread_Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

//模拟倒计时
public class ThreadSleep2 {
    //模拟倒计时
    public  static  void tenDown() throws InterruptedException {
        int num = 10;
        while(true)
        {
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0)
                break;
        }
    }

    //打印当前系统时间


    public static void main(String[] args) {
        Date startTime = new Date(System.currentTimeMillis());
        while(true)
        {
            try{
//                tenDown();
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
