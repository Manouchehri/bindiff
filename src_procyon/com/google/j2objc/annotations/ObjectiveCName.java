package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjectiveCName {
    String value();
}
