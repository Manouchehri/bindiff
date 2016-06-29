package com.google.common.collect;

import javax.annotation.Nullable;

public interface MapDifference$ValueDifference {
   Object leftValue();

   Object rightValue();

   boolean equals(@Nullable Object var1);

   int hashCode();
}
