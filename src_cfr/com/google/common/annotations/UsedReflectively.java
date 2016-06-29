/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.SOURCE)
@Target(value={ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@GoogleInternal
@GwtCompatible
public @interface UsedReflectively {
}

