package com.google.common.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
@GoogleInternal
@GwtCompatible
public @interface ReadOnly {
}
