package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMapValues;
import java.util.Map.Entry;

class ImmutableMapValues$2 extends ImmutableAsList {
   // $FF: synthetic field
   final ImmutableList val$entryList;
   // $FF: synthetic field
   final ImmutableMapValues this$0;

   ImmutableMapValues$2(ImmutableMapValues var1, ImmutableList var2) {
      this.this$0 = var1;
      this.val$entryList = var2;
   }

   public Object get(int var1) {
      return ((Entry)this.val$entryList.get(var1)).getValue();
   }

   ImmutableCollection delegateCollection() {
      return this.this$0;
   }
}
