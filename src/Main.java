//import java.awt.desktop.SystemEventListener;
import java.util.*;

import static java.util.Collections.sort;

// 按两次 ⇧ 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static int add(int a ,int b)
    {
        return a+b;
    }
    public static   double add(double a,double b)
    {
        return a + b;
    }
    public static double add(double a,double b,double c)
    {
        return a + b +c ;
    }

    public static void main(String[] args) {
        // 当文本光标位于高亮显示的文本处时按 ⌥⏎，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        System.out.printf("Hello and welcome!\n");

        // 按 ⌃R 或点击间距中的绿色箭头按钮以运行脚本。
//        for (int i = 1; i <= 5; i++) {
//
//            // 按 ⌃D 开始调试代码。我们已为您设置了一个断点，
//            // 但您始终可以通过按 ⌘F8 添加更多断点。
//            System.out.println("i = " + i);
//        }
        Scanner scanner = new Scanner(System.in);
        //use the next and next Line to get data
        //and use the hasNext() and hasNextLine() to judge is still data to need get

        //重载方法
        int a = 1,b =2;
        System.out.println(add(a,b));

        double a1 = 1.0,b1= 1.0;
        double  c= 3.0;
        System.out.println(add(a1,b1));
        System.out.println(add(a1,b1,c));

        //arraylist
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(22);
        arr1.add(3);
        System.out.println(arr1);
        //迭代器访问
        Iterator<Integer> iter = arr1.iterator();
//        arr1.sort(arr1);
//        Arrays.sort(arr1);

        sort(arr1);
        System.out.println("排序(从小到大)"+arr1);
        sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2<o1? -1:((o2==o1)? 0:1);
            }
        });
        System.out.println("sort 排序(从大到小)"+arr1);
        sort(arr1);
        System.out.println("sort 排序(从小到大)"+arr1);

        arr1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("list 排序(从大到小)"+arr1);
//        arr1.forEach(System.out::print);

        //五子棋编程
        int [][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        //输出棋盘
        for (int [] ints :array1) {
            for(int nums : ints)
            {
                System.out.print(nums+" ");
            }
            System.out.println();
        }

        //获取非零值的个数
        int sum = 0;
        for(int i = 0 ;i<array1.length;i++)
        {
            for(int j = 0;j<array1[i].length;j++)
            {
                if(array1[i][j]!=0)
                {
                    sum++;
                }
            }
        }
        //利用稀疏数组保存
        int [][] array2 = new int[sum+1][3];  // 行 列 值
        int count = 0;
        array2[0][0] = 11;
        array2[0][1] = 11;
        array2[0][2] = sum;
        for(int i = 0;i<array1.length;i++)
        {
            for(int j = 0;j<array1[i].length;j++){
                if(array1[i][j]!=0)
                {
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }
        System.out.println("============稀疏数组===========");
        for (int [] ints :array2) {
            for(int nums : ints)
            {
                System.out.print(nums+" ");
            }
            System.out.println();
        }
//        array2.forEach(System.out::println);
    }
}