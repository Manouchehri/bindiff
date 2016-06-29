package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Iterator;

public class ImmutableMultiset$Builder extends ImmutableCollection$Builder {
   final Multiset contents;

   public ImmutableMultiset$Builder() {
      this(LinkedHashMultiset.create());
   }

   ImmutableMultiset$Builder(Multiset var1) {
      this.contents = var1;
   }

   public ImmutableMultiset$Builder add(Object var1) {
      this.contents.add(Preconditions.checkNotNull(var1));
      return this;
   }

   public ImmutableMultiset$Builder addCopies(Object var1, int var2) {
      this.contents.add(Preconditions.checkNotNull(var1), var2);
      return this;
   }

   public ImmutableMultiset$Builder setCount(Object var1, int var2) {
      this.contents.setCount(Preconditions.checkNotNull(var1), var2);
      return this;
   }

   public ImmutableMultiset$Builder add(Object... var1) {
      super.add(var1);
      return this;
   }

   public ImmutableMultiset$Builder addAll(Iterable var1) {
      if(var1 instanceof Multiset) {
         Multiset var2 = Multisets.cast(var1);
         Iterator var3 = var2.entrySet().iterator();

         while(var3.hasNext()) {
            Multiset$Entry var4 = (Multiset$Entry)var3.next();
            this.addCopies(var4.getElement(), var4.getCount());
         }
      } else {
         super.addAll(var1);
      }

      return this;
   }

   public ImmutableMultiset$Builder addAll(Iterator var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableMultiset build() {
      return ImmutableMultiset.copyOf((Iterable)this.contents);
   }
}
