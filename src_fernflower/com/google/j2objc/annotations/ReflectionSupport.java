package com.google.j2objc.annotations;

import com.google.j2objc.annotations.ReflectionSupport$Level;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
public @interface ReflectionSupport {
   ReflectionSupport$Level value();
}
