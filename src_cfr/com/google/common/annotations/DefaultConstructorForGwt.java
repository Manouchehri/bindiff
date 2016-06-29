/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.IncompatibleModifiers;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Documented
@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.CONSTRUCTOR})
@GoogleInternal
@GwtCompatible
@IncompatibleModifiers(value={Modifier.PUBLIC})
public @interface DefaultConstructorForGwt {
}

