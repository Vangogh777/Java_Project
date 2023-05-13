public class Student  extends  People{
//    public static void say()
    private  String name = "宁远霖";
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say()
    {
        System.out.println(this.name+"学生说话");
    }

    public Student() {

    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void test_name(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.getName());

    }

}
