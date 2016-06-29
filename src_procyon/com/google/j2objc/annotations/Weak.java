package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
@Retention(RetentionPolicy.CLASS)
public @interface Weak {
}
