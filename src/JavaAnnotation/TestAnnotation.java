package JavaAnnotation;

import java.util.ArrayList;
import java.util.List;

public class TestAnnotation  {

    //@Override重写的注解
    @Override
    public String toString()
    {
        return super.toString();
    }
    @Deprecated
    public void test(){
        //不推荐程序员去使用，但是可以使用
        System.out.println("use Deprecated");
    }

    @SuppressWarnings("all")
    public void test01(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        TestAnnotation  testAnnotation = new TestAnnotation();
        testAnnotation.test();
        testAnnotation.test01();
    }

}
