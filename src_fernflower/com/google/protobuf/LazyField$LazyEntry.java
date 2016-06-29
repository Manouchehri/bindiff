package com.google.protobuf;

import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$1;
import com.google.protobuf.MessageLite;
import java.util.Map.Entry;

class LazyField$LazyEntry implements Entry {
   private Entry entry;

   private LazyField$LazyEntry(Entry var1) {
      this.entry = var1;
   }

   public Object getKey() {
      return this.entry.getKey();
   }

   public Object getValue() {
      LazyField var1 = (LazyField)this.entry.getValue();
      return var1 == null?null:var1.getValue();
   }

   public LazyField getField() {
      return (LazyField)this.entry.getValue();
   }

   public Object setValue(Object var1) {
      if(!(var1 instanceof MessageLite)) {
         throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      } else {
         return ((LazyField)this.entry.getValue()).setValue((MessageLite)var1);
      }
   }

   // $FF: synthetic method
   LazyField$LazyEntry(Entry var1, LazyField$1 var2) {
      this(var1);
   }
}
