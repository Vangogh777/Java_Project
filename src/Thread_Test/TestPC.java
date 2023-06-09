package Thread_Test;

//管程法：利用缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
        

    }
}
//生产者
class Productor extends  Thread{
    SynContainer container;



    public Productor(SynContainer container){
        this.container = container;
    }
    @Override
    public  void run()
    {
        for(int i = 0;i<100;i++)
        {
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }

}
//消费者
class Consumer extends  Thread{
    SynContainer container;



    public  Consumer (SynContainer container){
        this.container = container;
    }

    @Override
    public  void run()
    {
        for(int i = 0;i<100;i++)
        {
            System.out.println("消费了"+container.pop().id+"只鸡");

        }
    }
}
//产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{

    // 需要一个容器大小
    Chicken [] chickens = new Chicken[10];
    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //容器满了就需要等待消费者消费
        if(count == chickens.length)
        {
//            wait();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        chickens[count] = chicken;
        count++;
        //唤醒进程
        this.notifyAll();
    }

    //消费者消费
    public synchronized Chicken pop(){
        if(count==0)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}