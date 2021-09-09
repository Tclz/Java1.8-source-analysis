package example;

import java.lang.reflect.Field;

public class AnnotationTest {
    public static void main(String[] args)  {
        Persons p1 = new Persons("Alice", 20);
        Persons p2 = new Persons("Bob", 200);
        Persons p3 = new Persons("",10);
        for (Persons p : new Persons[] { p1, p2, p3 }) {
            try {
                check(p);
                System.out.println("Person " + p + " checked ok.");
            } catch (IllegalArgumentException | ReflectiveOperationException e) {
                System.out.println("Person " + p + " checked failed: " + e);
            }
        }

    }
    static void check(Persons person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);

                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
                //如果值是int
                else if(value instanceof Integer){
                    Integer n = (Integer)value;
                    if(n<range.min() || n>range.max()){
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

            }
        }
    }
}
