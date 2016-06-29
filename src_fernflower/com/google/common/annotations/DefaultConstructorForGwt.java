package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.IncompatibleModifiers;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR})
@GoogleInternal
@GwtCompatible
@IncompatibleModifiers({Modifier.PUBLIC})
public @interface DefaultConstructorForGwt {
}
