package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableAsList$SerializedForm implements Serializable {
   final ImmutableCollection collection;
   private static final long serialVersionUID = 0L;

   ImmutableAsList$SerializedForm(ImmutableCollection var1) {
      this.collection = var1;
   }

   Object readResolve() {
      return this.collection.asList();
   }
}
