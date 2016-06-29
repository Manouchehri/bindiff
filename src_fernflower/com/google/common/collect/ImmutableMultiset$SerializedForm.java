package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.io.Serializable;
import java.util.Iterator;

class ImmutableMultiset$SerializedForm implements Serializable {
   final Object[] elements;
   final int[] counts;
   private static final long serialVersionUID = 0L;

   ImmutableMultiset$SerializedForm(Multiset var1) {
      int var2 = var1.entrySet().size();
      this.elements = new Object[var2];
      this.counts = new int[var2];
      int var3 = 0;

      for(Iterator var4 = var1.entrySet().iterator(); var4.hasNext(); ++var3) {
         Multiset$Entry var5 = (Multiset$Entry)var4.next();
         this.elements[var3] = var5.getElement();
         this.counts[var3] = var5.getCount();
      }

   }

   Object readResolve() {
      LinkedHashMultiset var1 = LinkedHashMultiset.create(this.elements.length);

      for(int var2 = 0; var2 < this.elements.length; ++var2) {
         var1.add(this.elements[var2], this.counts[var2]);
      }

      return ImmutableMultiset.copyOf((Iterable)var1);
   }
}
