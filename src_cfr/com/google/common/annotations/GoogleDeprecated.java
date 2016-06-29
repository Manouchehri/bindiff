/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value={ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@GwtCompatible
@GoogleInternal
public @interface GoogleDeprecated {
    public String deletionDate();

    public String contact();

    public String url() default "";
}

