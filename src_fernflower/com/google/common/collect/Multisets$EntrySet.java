package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import javax.annotation.Nullable;

abstract class Multisets$EntrySet extends Sets$ImprovedAbstractSet {
   abstract Multiset multiset();

   public boolean contains(@Nullable Object var1) {
      if(var1 instanceof Multiset$Entry) {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         if(var2.getCount() <= 0) {
            return false;
         } else {
            int var3 = this.multiset().count(var2.getElement());
            return var3 == var2.getCount();
         }
      } else {
         return false;
      }
   }

   public boolean remove(Object var1) {
      if(var1 instanceof Multiset$Entry) {
         Multiset$Entry var2 = (Multiset$Entry)var1;
         Object var3 = var2.getElement();
         int var4 = var2.getCount();
         if(var4 != 0) {
            Multiset var5 = this.multiset();
            return var5.setCount(var3, var4, 0);
         }
      }

      return false;
   }

   public void clear() {
      this.multiset().clear();
   }
}
