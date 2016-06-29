package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

class ImmutableSet$SerializedForm implements Serializable {
   final Object[] elements;
   private static final long serialVersionUID = 0L;

   ImmutableSet$SerializedForm(Object[] var1) {
      this.elements = var1;
   }

   Object readResolve() {
      return ImmutableSet.copyOf(this.elements);
   }
}
