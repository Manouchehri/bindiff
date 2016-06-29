package com.google.errorprone.annotations.concurrent;

import com.google.errorprone.annotations.GoogleInternal;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@GoogleInternal
public @interface LazyInit {
}
