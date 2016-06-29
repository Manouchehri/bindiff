package com.google.errorprone.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.PARAMETER })
public @interface CompileTimeConstant {
}
