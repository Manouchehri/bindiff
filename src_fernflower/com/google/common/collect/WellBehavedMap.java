package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.WellBehavedMap$1;
import com.google.common.collect.WellBehavedMap$EntrySet;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap extends ForwardingMap {
   private final Map delegate;
   private Set entrySet;

   private WellBehavedMap(Map var1) {
      this.delegate = var1;
   }

   static WellBehavedMap wrap(Map var0) {
      return new WellBehavedMap(var0);
   }

   protected Map delegate() {
      return this.delegate;
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 != null?var1:(this.entrySet = new WellBehavedMap$EntrySet(this, (WellBehavedMap$1)null));
   }
}
