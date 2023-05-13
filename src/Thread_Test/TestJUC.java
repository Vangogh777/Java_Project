package Thread_Test;

import java.sql.SQLOutput;
import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList <String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        for(int i =0; i< 10000;i++)
        {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }

        try{
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(copyOnWriteArrayList.size());

    }
}
