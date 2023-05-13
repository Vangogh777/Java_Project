package Thread_Test;

//信号灯法： 利用flag
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}


//生产者-》演员
class Player extends Thread{
    TV tv;
    public  Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run()
    {
        for(int i = 0;i<20 ;i++)
        {
            if(i%2==0)
            {
                try {
                    this.tv.play("快乐大本营");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{

                try {
                    this.tv.play("抖音：记录美好生活");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


}
//消费者-》观众
class Watcher extends Thread{
    TV tv;
    public  Watcher(TV tv){
        this.tv = tv;
    }
    @Override
    public void run()
    {
        for(int i = 0;i<20;i++){
            this.tv.watch();
        }

    }
}

//产品-》节目
class TV{
    String voice;
    boolean flag = true;

    //表演  演员表演 观众等待
    public synchronized void play(String voice) throws InterruptedException {
        if(!flag)
        {
            wait();

        }

        System.out.println("演员表演了："+voice);
        //唤醒
        this.notify();
        this.voice  = voice;
        this.flag = !flag;


    }
    //观众观看，演员等待
    public synchronized void watch(){
        if(flag)
        {
            try{
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
        System.out.println("观众观看了："+this.voice);

        this.notify();
        this.flag = !this.flag;
    }
}