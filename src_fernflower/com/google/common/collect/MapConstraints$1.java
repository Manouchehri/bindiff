package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MapConstraint;
import java.util.Map.Entry;

final class MapConstraints$1 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final MapConstraint val$constraint;

   MapConstraints$1(Entry var1, MapConstraint var2) {
      this.val$entry = var1;
      this.val$constraint = var2;
   }

   protected Entry delegate() {
      return this.val$entry;
   }

   public Object setValue(Object var1) {
      this.val$constraint.checkKeyValue(this.getKey(), var1);
      return this.val$entry.setValue(var1);
   }
}
