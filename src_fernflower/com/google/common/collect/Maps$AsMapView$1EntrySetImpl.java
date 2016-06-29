package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

class Maps$AsMapView$1EntrySetImpl extends Maps$EntrySet {
   // $FF: synthetic field
   final Maps$AsMapView this$0;

   Maps$AsMapView$1EntrySetImpl(Maps$AsMapView var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return Maps.asMapEntryIterator(this.this$0.backingSet(), this.this$0.function);
   }
}
