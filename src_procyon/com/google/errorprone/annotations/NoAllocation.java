package com.google.errorprone.annotations;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.METHOD })
public @interface NoAllocation {
}
