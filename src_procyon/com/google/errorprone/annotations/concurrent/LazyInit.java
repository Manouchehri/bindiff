package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.*;
import com.google.errorprone.annotations.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@GoogleInternal
public @interface LazyInit {
}
