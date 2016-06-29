package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.MapMakerInternalMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$WriteThroughEntry extends AbstractMapEntry {
   final Object key;
   Object value;
   // $FF: synthetic field
   final MapMakerInternalMap this$0;

   MapMakerInternalMap$WriteThroughEntry(MapMakerInternalMap var1, Object var2, Object var3) {
      this.this$0 = var1;
      this.key = var2;
      this.value = var3;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return this.key.equals(var2.getKey()) && this.value.equals(var2.getValue());
      }
   }

   public int hashCode() {
      return this.key.hashCode() ^ this.value.hashCode();
   }

   public Object setValue(Object var1) {
      Object var2 = this.this$0.put(this.key, var1);
      this.value = var1;
      return var2;
   }
}
