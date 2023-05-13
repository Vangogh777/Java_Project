package Thread_Test;

public class Thread_test implements Runnable {
    @Override
    //实现runnable接口，重写run方法
    public void run() {
        for(int i = 0;i<200;i++)
        {
            System.out.println("我在看代码"+i);
        }
    }

    public static void main(String[] args) {
        Thread_test thread = new Thread_test();
//        Thread thread1 = new Thread(thread);
//        thread1.start();
        new Thread(thread).start();
        for(int i = 0;i<200;i++)
        {
            System.out.println("我在学习多线程"+i);
        }

    }

}
