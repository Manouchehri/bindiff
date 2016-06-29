package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.SOURCE)
public @interface ReflectionSupport {
    ReflectionSupport$Level value();
}
