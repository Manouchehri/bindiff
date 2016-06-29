package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.SOURCE)
public @interface AutoreleasePool {
}
