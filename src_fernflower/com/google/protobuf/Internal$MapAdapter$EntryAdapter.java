package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import java.util.Map.Entry;

class Internal$MapAdapter$EntryAdapter implements Entry {
   private final Entry realEntry;
   // $FF: synthetic field
   final Internal$MapAdapter this$0;

   public Internal$MapAdapter$EntryAdapter(Internal$MapAdapter var1, Entry var2) {
      this.this$0 = var1;
      this.realEntry = var2;
   }

   public Object getKey() {
      return this.realEntry.getKey();
   }

   public Object getValue() {
      return Internal$MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
   }

   public Object setValue(Object var1) {
      Object var2 = this.realEntry.setValue(Internal$MapAdapter.access$000(this.this$0).doBackward(var1));
      return var2 == null?null:Internal$MapAdapter.access$000(this.this$0).doForward(var2);
   }
}
