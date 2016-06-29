/*
 * Decompiled with CFR 0_115.
 */
package com.google.errorprone.annotations.concurrent;

import com.google.errorprone.annotations.GoogleInternal;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
@GoogleInternal
public @interface WriteOnly {
}

