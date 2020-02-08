package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz=Class.forName("Annotation.table");
        Annotation[] annotations =clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
//        sexTable table=(sexTable)clazz.getAnnotations(sexTable.class);
//        Field f = clazz.getDeclaredField("index");
//        sxtField field=f.getAnnotation(sxtField.class);
//        System.out.println(field.sname() + " " + field.type() + "--" + field.length());
    }
}
