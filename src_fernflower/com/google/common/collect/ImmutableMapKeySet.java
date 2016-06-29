package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapKeySet$KeySetSerializedForm;
import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.UnmodifiableIterator;
import com.google.j2objc.annotations.Weak;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class ImmutableMapKeySet extends ImmutableSet$Indexed {
   @Weak
   private final ImmutableMap map;

   ImmutableMapKeySet(ImmutableMap var1) {
      this.map = var1;
   }

   public int size() {
      return this.map.size();
   }

   public UnmodifiableIterator iterator() {
      return this.map.keyIterator();
   }

   public boolean contains(@Nullable Object var1) {
      return this.map.containsKey(var1);
   }

   Object get(int var1) {
      return ((Entry)this.map.entrySet().asList().get(var1)).getKey();
   }

   boolean isPartialView() {
      return true;
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new ImmutableMapKeySet$KeySetSerializedForm(this.map);
   }
}
