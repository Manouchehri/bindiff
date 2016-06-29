package com.google.common.collect;

import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.WellBehavedMap;
import com.google.common.collect.WellBehavedMap$1;
import com.google.common.collect.WellBehavedMap$EntrySet$1;
import java.util.Iterator;
import java.util.Map;

final class WellBehavedMap$EntrySet extends Maps$EntrySet {
   // $FF: synthetic field
   final WellBehavedMap this$0;

   private WellBehavedMap$EntrySet(WellBehavedMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return new WellBehavedMap$EntrySet$1(this, this.this$0.keySet().iterator());
   }

   // $FF: synthetic method
   WellBehavedMap$EntrySet(WellBehavedMap var1, WellBehavedMap$1 var2) {
      this(var1);
   }
}
