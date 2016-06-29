package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import javax.annotation.Nullable;

final class ImmutableMultimap$Values extends ImmutableCollection {
   @Weak
   private final transient ImmutableMultimap multimap;
   private static final long serialVersionUID = 0L;

   ImmutableMultimap$Values(ImmutableMultimap var1) {
      this.multimap = var1;
   }

   public boolean contains(@Nullable Object var1) {
      return this.multimap.containsValue(var1);
   }

   public UnmodifiableIterator iterator() {
      return this.multimap.valueIterator();
   }

   @GwtIncompatible("not present in emulated superclass")
   int copyIntoArray(Object[] var1, int var2) {
      ImmutableCollection var4;
      for(UnmodifiableIterator var3 = this.multimap.map.values().iterator(); var3.hasNext(); var2 = var4.copyIntoArray(var1, var2)) {
         var4 = (ImmutableCollection)var3.next();
      }

      return var2;
   }

   public int size() {
      return this.multimap.size();
   }

   boolean isPartialView() {
      return true;
   }
}
