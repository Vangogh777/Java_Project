public class People {
    private int age;
    private char sex;
    private String name = "沙雕";

    public People(int age, char sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }
    public People(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
