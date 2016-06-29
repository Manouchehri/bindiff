package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multisets$AbstractEntry;
import java.io.Serializable;
import javax.annotation.Nullable;

class Multisets$ImmutableEntry extends Multisets$AbstractEntry implements Serializable {
   @Nullable
   private final Object element;
   private final int count;
   private static final long serialVersionUID = 0L;

   Multisets$ImmutableEntry(@Nullable Object var1, int var2) {
      this.element = var1;
      this.count = var2;
      CollectPreconditions.checkNonnegative(var2, "count");
   }

   @Nullable
   public final Object getElement() {
      return this.element;
   }

   public final int getCount() {
      return this.count;
   }

   public Multisets$ImmutableEntry nextInBucket() {
      return null;
   }
}
