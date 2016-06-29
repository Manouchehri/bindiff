/*
 * Decompiled with CFR 0_115.
 */
package com.google.j2objc.annotations;

import com.google.j2objc.annotations.ReflectionSupport$Level;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE, ElementType.PACKAGE})
@Retention(value=RetentionPolicy.SOURCE)
public @interface ReflectionSupport {
    public ReflectionSupport$Level value();
}

