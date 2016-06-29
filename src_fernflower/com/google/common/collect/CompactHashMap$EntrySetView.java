package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$EntrySetView$1;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class CompactHashMap$EntrySetView extends Maps$EntrySet {
   // $FF: synthetic field
   final CompactHashMap this$0;

   CompactHashMap$EntrySetView(CompactHashMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return new CompactHashMap$EntrySetView$1(this);
   }

   public boolean contains(@Nullable Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         int var3 = CompactHashMap.access$200(this.this$0, var2.getKey());
         return var3 != -1 && Objects.equal(this.this$0.values[var3], var2.getValue());
      }
   }

   public boolean remove(@Nullable Object var1) {
      if(var1 instanceof Entry) {
         Entry var2 = (Entry)var1;
         int var3 = CompactHashMap.access$200(this.this$0, var2.getKey());
         if(var3 != -1 && Objects.equal(this.this$0.values[var3], var2.getValue())) {
            CompactHashMap.access$100(this.this$0, var3);
            return true;
         }
      }

      return false;
   }
}
