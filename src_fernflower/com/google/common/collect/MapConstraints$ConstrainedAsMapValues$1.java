package com.google.common.collect;

import com.google.common.collect.MapConstraints$ConstrainedAsMapValues;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapValues$1 implements Iterator {
   // $FF: synthetic field
   final Iterator val$iterator;
   // $FF: synthetic field
   final MapConstraints$ConstrainedAsMapValues this$0;

   MapConstraints$ConstrainedAsMapValues$1(MapConstraints$ConstrainedAsMapValues var1, Iterator var2) {
      this.this$0 = var1;
      this.val$iterator = var2;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Collection next() {
      return (Collection)((Entry)this.val$iterator.next()).getValue();
   }

   public void remove() {
      this.val$iterator.remove();
   }
}
