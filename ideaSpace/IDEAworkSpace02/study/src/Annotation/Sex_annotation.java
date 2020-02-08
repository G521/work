package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface Sex_annotation {
    String studentName() default "";// 默认值
    int age() default 0;
    int id() default -1;

    String[] school() default {"清华大学","北京大学"};
}
