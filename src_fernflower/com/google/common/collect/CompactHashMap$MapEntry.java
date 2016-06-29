package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.CompactHashMap;
import javax.annotation.Nullable;

final class CompactHashMap$MapEntry extends AbstractMapEntry {
   @Nullable
   private final Object key;
   private int lastKnownIndex;
   // $FF: synthetic field
   final CompactHashMap this$0;

   CompactHashMap$MapEntry(CompactHashMap var1, int var2) {
      this.this$0 = var1;
      this.key = var1.keys[var2];
      this.lastKnownIndex = var2;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      if(this.lastKnownIndex == -1 || this.lastKnownIndex >= this.this$0.size() || !Objects.equal(this.key, this.this$0.keys[this.lastKnownIndex])) {
         this.lastKnownIndex = CompactHashMap.access$200(this.this$0, this.key);
      }

      return this.lastKnownIndex == -1?null:this.this$0.values[this.lastKnownIndex];
   }
}
