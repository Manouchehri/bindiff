package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;

class ImmutableList$SerializedForm implements Serializable {
   final Object[] elements;
   private static final long serialVersionUID = 0L;

   ImmutableList$SerializedForm(Object[] var1) {
      this.elements = var1;
   }

   Object readResolve() {
      return ImmutableList.copyOf(this.elements);
   }
}
