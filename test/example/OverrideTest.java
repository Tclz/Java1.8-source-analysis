package example;

import sun.awt.geom.AreaOp;

class Animal{
    Animal(){

    }
}
class Cat extends Animal{
    Cat(){

    }
}
class Father{
    protected Animal hello(){
        System.out.println("father's hello method invoked!");
        return null;
    }
    private void haha(){

    }

}
class Son extends Father{
    public Cat hello() {
        System.out.println("son's hello method invoked!");
        return null;
    }
    public void h(){
        //super.haha();
    }
}
public class OverrideTest {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hello();
        son.hello();
    }

}
