package example;

public class Persons {
    @Range(min=1,max=20)
    public String name;
    @Range(min=1,max=99)
    public int age;
    Persons(String name, int age){
        this.name = name;
        this.age = age;
    }
}
