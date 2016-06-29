package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.Interners$WeakInterner$Dummy;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class Interners$WeakInterner implements Interner {
   private final MapMakerInternalMap map;

   private Interners$WeakInterner() {
      this.map = (new MapMaker()).weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
   }

   public Object intern(Object var1) {
      Interners$WeakInterner$Dummy var4;
      do {
         MapMakerInternalMap$ReferenceEntry var2 = this.map.getEntry(var1);
         if(var2 != null) {
            Object var3 = var2.getKey();
            if(var3 != null) {
               return var3;
            }
         }

         var4 = (Interners$WeakInterner$Dummy)this.map.putIfAbsent(var1, Interners$WeakInterner$Dummy.VALUE);
      } while(var4 != null);

      return var1;
   }

   // $FF: synthetic method
   Interners$WeakInterner(Interners$1 var1) {
      this();
   }
}
