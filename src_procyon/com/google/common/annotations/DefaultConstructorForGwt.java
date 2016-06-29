package com.google.common.annotations;

import java.lang.annotation.*;
import com.google.errorprone.annotations.*;
import javax.lang.model.element.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.CONSTRUCTOR })
@GoogleInternal
@GwtCompatible
@IncompatibleModifiers({ Modifier.PUBLIC })
public @interface DefaultConstructorForGwt {
}
