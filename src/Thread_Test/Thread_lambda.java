package Thread_Test;
//lambda 表达式
public class Thread_lambda {
//    @Override
//    public void run() {
//
//    }
    //3.静态内部类
    static  class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I Like lambda 静态内部类");
        }
    }



    public static void main(String[] args) {
//        Thread_lambda threadLambda = new Thread_lambda();
        Like like = new Like();
        like.lambda();

        Like2 like2 = new Like2();
        like2.lambda();
        //4.局部内部类

        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I Like lambda 局部内部类");
            }
        }

        Like3 like3 = new Like3();
        like3.lambda();
        //5.匿名内部类
        like = new Like() {
            @Override
            public void lambda()
            {
                System.out.println("I Like lambda 匿名内部类");
            }
        };
        like.lambda();

        //6.lambda简化
        Runnable l = ()->{
            System.out.println("I Like lambda  using lambda");

        };
        l.run();

        ILike like1 = ()->{
            System.out.println("I Like lambda  using lambda");
        };
        like1.lambda();

    }
}


//1.定义一个函数接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambda()
    {
        System.out.println("I Like lambda 实现类");
    }
}