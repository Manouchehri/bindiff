/*
 * Decompiled with CFR 0_115.
 */
package com.google.j2objc.annotations;

import com.google.j2objc.annotations.LoopTranslation$LoopStyle;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.LOCAL_VARIABLE})
@Retention(value=RetentionPolicy.SOURCE)
public @interface LoopTranslation {
    public LoopTranslation$LoopStyle value();
}

