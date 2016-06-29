package com.google.j2objc.annotations;

import java.lang.annotation.*;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface J2ObjCIncompatible {
}
