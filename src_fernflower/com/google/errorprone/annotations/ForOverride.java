package com.google.errorprone.annotations;

import com.google.errorprone.annotations.IncompatibleModifiers;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@IncompatibleModifiers({Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL})
public @interface ForOverride {
}
