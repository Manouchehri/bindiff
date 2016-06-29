package com.google.common.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD })
@GoogleInternal
@GwtCompatible
public @interface NonFinalForGwt {
}
