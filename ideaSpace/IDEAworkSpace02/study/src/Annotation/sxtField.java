package Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(value= ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface sxtField {
    String sname();
    String type();
    int length();
}
