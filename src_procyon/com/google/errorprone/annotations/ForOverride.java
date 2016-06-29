package com.google.errorprone.annotations;

import java.lang.annotation.*;
import javax.lang.model.element.*;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD })
@IncompatibleModifiers({ Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL })
public @interface ForOverride {
}
