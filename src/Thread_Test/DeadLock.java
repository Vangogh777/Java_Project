package Thread_Test;

import java.nio.channels.MembershipKey;
import java.util.MissingResourceException;

//死锁
public class DeadLock {
    public static void main(String[] args) {
        Make make = new Make(0,"白雪公主");
        Make make2 = new Make(1,"witch");
        make2.start();
        make.start();
    }
}

//口红
class Liplist
{

}

//镜子
class Mirror{

}

class Make extends Thread{
    static Liplist liplist = new Liplist();
    static Mirror mirror = new Mirror();
    public int choice;
    public String girlname;

    public Make(int choice,String girlname){
        this.choice = choice;
        this.girlname = girlname;
    }

//    @Override
//    public void run()
//    {
//        if(choice==0)
//        {
//            synchronized (liplist){
//                System.out.println(this.girlname+"获得了口红的锁");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                synchronized (mirror)
//                {
//                    System.out.println(this.girlname+"获得了镜子的锁");
//
//                }
//            }
//        }
//        else {
//            synchronized (mirror){
//                System.out.println(this.girlname+"获得了镜子的锁");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                synchronized (liplist)
//                {
//                    System.out.println(this.girlname+"获得了口红的锁");
//
//                }
//            }
//        }
//    }

    @Override
    //解决方法
    public void run()
    {
        if(choice==0)
        {
            synchronized (liplist){
                System.out.println(this.girlname+"获得了口红的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (mirror)
            {
                System.out.println(this.girlname+"获得了镜子的锁");
            }
        }
        else {
            synchronized (mirror){
                System.out.println(this.girlname+"获得了镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            synchronized (liplist)
            {
                System.out.println(this.girlname+"获得了口红的锁");

            }
        }
    }
}
