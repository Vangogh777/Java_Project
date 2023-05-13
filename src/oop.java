import java.net.SocketTimeoutException;

public class oop {
    public static void main(String[] args) {
//        System.out.println("hello,world");
//        Student student = new Student("小明",12);
//        student.say();
//        System.out.println(student.getAge());
//        student.setAge(13);
//        student.setSex('男');
//        System.out.println(student.getAge());
//        System.out.println("sex:"+student.getSex());
//
//        student.test_name("测试名字1");
//        student.setName("瑞驰");
//        student.test_name("测试名字2");

//        A a = new A();
//        a.test();
//        B b = new A();
//        b.test();
        int a = 10,b = 0;

//        System.out.println(a/b);
        try{ //try 监控区域
            if(b==0)
            {
                //主动抛出异常
                throw new ArithmeticException();
            }
            System.out.println(a/b);
        }
        catch (Error e)
        {
            System.out.println("ERROR");
        }
        catch (Exception e)
        {   //catch（想要捕捉的异常类型） 捕获异常
//            e.printStackTrace();
            System.out.println("Exception");
        }
        catch (Throwable e)
        {
            System.out.println("Throwable");
        }
        finally { //finally 善后工作
            System.out.println("执行finally");
        }


        try{
            new oop().test(1,0);
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }
    }

    public void test (int a,int b) throws  ArithmeticException
    {
        if(b==0)
        {
            throw new ArithmeticException(); //处理不了我就抛出去
        }
    }
}
