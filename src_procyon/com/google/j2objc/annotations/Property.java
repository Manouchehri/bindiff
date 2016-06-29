package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.FIELD })
public @interface Property {
    String value() default "";
}
