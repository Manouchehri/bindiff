package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedMultiset;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

final class ImmutableSortedMultiset$SerializedForm implements Serializable {
   Comparator comparator;
   Object[] elements;
   int[] counts;

   ImmutableSortedMultiset$SerializedForm(SortedMultiset var1) {
      this.comparator = var1.comparator();
      int var2 = var1.entrySet().size();
      this.elements = (Object[])(new Object[var2]);
      this.counts = new int[var2];
      int var3 = 0;

      for(Iterator var4 = var1.entrySet().iterator(); var4.hasNext(); ++var3) {
         Multiset$Entry var5 = (Multiset$Entry)var4.next();
         this.elements[var3] = var5.getElement();
         this.counts[var3] = var5.getCount();
      }

   }

   Object readResolve() {
      int var1 = this.elements.length;
      ImmutableSortedMultiset$Builder var2 = new ImmutableSortedMultiset$Builder(this.comparator);

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.addCopies(this.elements[var3], this.counts[var3]);
      }

      return var2.build();
   }
}
