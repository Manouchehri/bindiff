package com.google.common.annotations;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting$Visibility;

@GwtCompatible
public @interface VisibleForTesting {
   @GoogleInternal
   VisibleForTesting$Visibility productionVisibility() default VisibleForTesting$Visibility.PRIVATE;
}
