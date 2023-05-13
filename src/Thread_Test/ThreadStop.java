package Thread_Test;

//测试stop
//1.使用次数
//2.使用标志位
//3.不要使用stop
public class ThreadStop implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag)
        {
            System.out.println("run Thread"+i++);
        }
    }
    public void stop()
    {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        new Thread(threadStop).start();

        for(int i= 0;i<10000;i++)
        {
            System.out.println("main:"+i);
            if(i==9999)
            {
                threadStop.stop();
                System.out.println("线程停止了！");
            }


        }

    }
}
