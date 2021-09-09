package example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Student implements Cloneable{
    private String name;
    private int age;
    Student(){}
    Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int a){
        this.age = a;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TCLZ {
    public static void main(String [] args) throws IllegalAccessException, InstantiationException, CloneNotSupportedException {
//        ArrayList<Student1> list = new ArrayList<>();
//        //添加两个元素
//        Student1 stJack = new Student1("Jack", 13);
//        Student1 stTom = new Student1("Tom", 15);
//        list.add(stJack);
//        list.add(stTom);
//        //浅拷贝
//        ArrayList<Student1> listCopy = (ArrayList<Student1>) list.clone();
//        //深拷贝
////        ArrayList<Student1> listCopy =new ArrayList<>();
////        for (Student1 student : list) {
////            listCopy.add(student.clone());
////        }
//


        Student s1 = new Student();
        //引用拷贝
        Student s2 = s1;
        //浅拷贝
        Student s3 = (Student) s1.clone();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
