package Com.Project;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsDemo {

    @Override
    @MethodInfo(author = "AKSHAY" , comment = "Main Method" , date = "27th March 2020" ,revision = 1)
    public String toString()
    {
        return "Overridden toString Method";
    }

    @Deprecated
    @MethodInfo(comment = "Deprecated method" , date = "27th March 2020")
    public static void oldMethod()
    {
        System.out.println("This Is Old Method Don't Use It");
    }

    public static void main(String[] args) {
        try{
            for(Method method : AnnotationsDemo.class.getMethods())
            {
                // Check Annotation present for method or not
                if (method.isAnnotationPresent(MethodInfo.class))
                {
                    try{
                        // iterates all available annotations
                        for (Annotation annoObj: method.getDeclaredAnnotations())
                        {
                            System.out.println("Annotaions in Method "+ method + " : " +annoObj);
                        }
                        MethodInfo methodAnno=method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision()==1)
                            System.out.println("Method With Revision No 1 = "+method);
                    }
                    catch(Throwable e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
