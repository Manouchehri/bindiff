/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting$Visibility;
import java.lang.annotation.Annotation;

@GwtCompatible
public @interface VisibleForTesting {
    @GoogleInternal
    public VisibleForTesting$Visibility productionVisibility() default VisibleForTesting$Visibility.PRIVATE;
}

