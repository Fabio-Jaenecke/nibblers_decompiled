package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface MapKey
{
  boolean unwrapValue() default true;
}


/* Location:              C:\dex2jar-2.0\com.rovio.Nibblers_12230-dex2jar.jar!\dagger\MapKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */