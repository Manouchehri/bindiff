package com.google.common.collect;

import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableBiMap$1;
import com.google.common.collect.RegularImmutableBiMap$Inverse$InverseEntrySet;
import com.google.common.collect.RegularImmutableBiMap$InverseSerializedForm;
import javax.annotation.Nullable;

final class RegularImmutableBiMap$Inverse extends ImmutableBiMap {
   // $FF: synthetic field
   final RegularImmutableBiMap this$0;

   private RegularImmutableBiMap$Inverse(RegularImmutableBiMap var1) {
      this.this$0 = var1;
   }

   public int size() {
      return this.inverse().size();
   }

   public ImmutableBiMap inverse() {
      return this.this$0;
   }

   public Object get(@Nullable Object var1) {
      if(var1 != null && RegularImmutableBiMap.access$100(this.this$0) != null) {
         int var2 = Hashing.smear(var1.hashCode()) & RegularImmutableBiMap.access$200(this.this$0);

         for(ImmutableMapEntry var3 = RegularImmutableBiMap.access$100(this.this$0)[var2]; var3 != null; var3 = var3.getNextInValueBucket()) {
            if(var1.equals(var3.getValue())) {
               return var3.getKey();
            }
         }

         return null;
      } else {
         return null;
      }
   }

   ImmutableSet createEntrySet() {
      return new RegularImmutableBiMap$Inverse$InverseEntrySet(this);
   }

   boolean isPartialView() {
      return false;
   }

   Object writeReplace() {
      return new RegularImmutableBiMap$InverseSerializedForm(this.this$0);
   }

   // $FF: synthetic method
   RegularImmutableBiMap$Inverse(RegularImmutableBiMap var1, RegularImmutableBiMap$1 var2) {
      this(var1);
   }
}
