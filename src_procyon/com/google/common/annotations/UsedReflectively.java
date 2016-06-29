package com.google.common.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD })
@GoogleInternal
@GwtCompatible
public @interface UsedReflectively {
}
