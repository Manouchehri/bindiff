package com.google.common.collect;

import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$2$1;
import java.util.Collection;
import java.util.Map.Entry;

final class MapConstraints$2 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final MapConstraint val$constraint;

   MapConstraints$2(Entry var1, MapConstraint var2) {
      this.val$entry = var1;
      this.val$constraint = var2;
   }

   protected Entry delegate() {
      return this.val$entry;
   }

   public Collection getValue() {
      return Constraints.constrainedTypePreservingCollection((Collection)this.val$entry.getValue(), new MapConstraints$2$1(this));
   }
}
