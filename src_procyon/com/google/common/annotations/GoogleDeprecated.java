package com.google.common.annotations;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@GwtCompatible
@GoogleInternal
public @interface GoogleDeprecated {
    String deletionDate();
    
    String contact();
    
    String url() default "";
}
