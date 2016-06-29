package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet$Builder;
import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm implements Serializable {
   final Comparator comparator;
   final Object[] elements;
   private static final long serialVersionUID = 0L;

   public ImmutableSortedSet$SerializedForm(Comparator var1, Object[] var2) {
      this.comparator = var1;
      this.elements = var2;
   }

   Object readResolve() {
      return (new ImmutableSortedSet$Builder(this.comparator)).add((Object[])this.elements).build();
   }
}
