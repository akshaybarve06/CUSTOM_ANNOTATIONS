package Com.Project;

import  java.lang.annotation.*;

/*
@Documented - Whether to put annotations in java docs
@Retention - When annotation is needed
@Target Places the annotation can go
@Inherited Whether subclass get the annottion
*/

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface MethodInfo {
    String author() default "AKSHAY";
    String date();
    int revision() default 1;
    String comment();
}
