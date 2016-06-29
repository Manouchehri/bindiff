package com.google.errorprone.annotations;

import java.lang.annotation.*;
import javax.lang.model.element.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.ANNOTATION_TYPE })
public @interface RequiredModifiers {
    Modifier[] value();
}
