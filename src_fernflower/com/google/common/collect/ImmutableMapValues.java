package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapValues$1;
import com.google.common.collect.ImmutableMapValues$2;
import com.google.common.collect.ImmutableMapValues$SerializedForm;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class ImmutableMapValues extends ImmutableCollection {
   @Weak
   private final ImmutableMap map;

   ImmutableMapValues(ImmutableMap var1) {
      this.map = var1;
   }

   public int size() {
      return this.map.size();
   }

   public UnmodifiableIterator iterator() {
      return new ImmutableMapValues$1(this);
   }

   public boolean contains(@Nullable Object var1) {
      return var1 != null && Iterators.contains(this.iterator(), var1);
   }

   boolean isPartialView() {
      return true;
   }

   ImmutableList createAsList() {
      ImmutableList var1 = this.map.entrySet().asList();
      return new ImmutableMapValues$2(this, var1);
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new ImmutableMapValues$SerializedForm(this.map);
   }

   // $FF: synthetic method
   static ImmutableMap access$000(ImmutableMapValues var0) {
      return var0.map;
   }
}
