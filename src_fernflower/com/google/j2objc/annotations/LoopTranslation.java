package com.google.j2objc.annotations;

import com.google.j2objc.annotations.LoopTranslation$LoopStyle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface LoopTranslation {
   LoopTranslation$LoopStyle value();
}
