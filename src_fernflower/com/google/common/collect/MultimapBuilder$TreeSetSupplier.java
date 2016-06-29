package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

final class MultimapBuilder$TreeSetSupplier implements Supplier, Serializable {
   private final Comparator comparator;

   MultimapBuilder$TreeSetSupplier(Comparator var1) {
      this.comparator = (Comparator)Preconditions.checkNotNull(var1);
   }

   public SortedSet get() {
      return new TreeSet(this.comparator);
   }
}
