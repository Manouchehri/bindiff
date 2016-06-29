package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet;
import java.util.Map.Entry;

class RegularImmutableBiMap$Inverse$InverseEntrySet$1 extends ImmutableAsList {
   // $FF: synthetic field
   final RegularImmutableBiMap$Inverse$InverseEntrySet this$2;

   RegularImmutableBiMap$Inverse$InverseEntrySet$1(RegularImmutableBiMap$Inverse$InverseEntrySet var1) {
      this.this$2 = var1;
   }

   public Entry get(int var1) {
      Entry var2 = RegularImmutableBiMap.access$400(this.this$2.this$1.this$0)[var1];
      return Maps.immutableEntry(var2.getValue(), var2.getKey());
   }

   ImmutableCollection delegateCollection() {
      return this.this$2;
   }
}
