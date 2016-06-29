package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.*;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
public @interface LockMethod {
    String[] value();
}
