package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$EntrySet$1;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1$1 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$finalEntry;
   // $FF: synthetic field
   final AbstractBiMap$EntrySet$1 this$2;

   AbstractBiMap$EntrySet$1$1(AbstractBiMap$EntrySet$1 var1, Entry var2) {
      this.this$2 = var1;
      this.val$finalEntry = var2;
   }

   protected Entry delegate() {
      return this.val$finalEntry;
   }

   public Object setValue(Object var1) {
      Preconditions.checkState(this.this$2.this$1.contains(this), "entry no longer in map");
      if(Objects.equal(var1, this.getValue())) {
         return var1;
      } else {
         Preconditions.checkArgument(!this.this$2.this$1.this$0.containsValue(var1), "value already present: %s", new Object[]{var1});
         Object var2 = this.val$finalEntry.setValue(var1);
         Preconditions.checkState(Objects.equal(var1, this.this$2.this$1.this$0.get(this.getKey())), "entry no longer in map");
         AbstractBiMap.access$600(this.this$2.this$1.this$0, this.getKey(), true, var2, var1);
         return var2;
      }
   }
}
