package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class LocalCache$WriteThroughEntry implements Entry {
   final Object key;
   Object value;
   // $FF: synthetic field
   final LocalCache this$0;

   LocalCache$WriteThroughEntry(LocalCache var1, Object var2, Object var3) {
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
      throw new UnsupportedOperationException();
   }

   public String toString() {
      String var1 = String.valueOf(this.getKey());
      String var2 = String.valueOf(this.getValue());
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append("=").append(var2).toString();
   }
}
