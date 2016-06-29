package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$Inverse;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet$1;
import com.google.common.collect.UnmodifiableIterator;

final class RegularImmutableBiMap$Inverse$InverseEntrySet extends ImmutableMapEntrySet {
   // $FF: synthetic field
   final RegularImmutableBiMap$Inverse this$1;

   RegularImmutableBiMap$Inverse$InverseEntrySet(RegularImmutableBiMap$Inverse var1) {
      this.this$1 = var1;
   }

   ImmutableMap map() {
      return this.this$1;
   }

   boolean isHashCodeFast() {
      return true;
   }

   public int hashCode() {
      return RegularImmutableBiMap.access$300(this.this$1.this$0);
   }

   public UnmodifiableIterator iterator() {
      return this.asList().iterator();
   }

   ImmutableList createAsList() {
      return new RegularImmutableBiMap$Inverse$InverseEntrySet$1(this);
   }
}
