package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedAsMapValues;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class MapConstraints$ConstrainedMultimap$1AsMap extends ForwardingMap {
   Set entrySet;
   Collection values;
   // $FF: synthetic field
   final Map val$asMapDelegate;
   // $FF: synthetic field
   final MapConstraints$ConstrainedMultimap this$0;

   MapConstraints$ConstrainedMultimap$1AsMap(MapConstraints$ConstrainedMultimap var1, Map var2) {
      this.this$0 = var1;
      this.val$asMapDelegate = var2;
   }

   protected Map delegate() {
      return this.val$asMapDelegate;
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      if(var1 == null) {
         this.entrySet = var1 = MapConstraints.access$200(this.val$asMapDelegate.entrySet(), this.this$0.constraint);
      }

      return var1;
   }

   public Collection get(Object var1) {
      try {
         Collection var2 = this.this$0.get(var1);
         return var2.isEmpty()?null:var2;
      } catch (ClassCastException var3) {
         return null;
      }
   }

   public Collection values() {
      Object var1 = this.values;
      if(var1 == null) {
         this.values = (Collection)(var1 = new MapConstraints$ConstrainedAsMapValues(this.delegate().values(), this.entrySet()));
      }

      return (Collection)var1;
   }

   public boolean containsValue(Object var1) {
      return this.values().contains(var1);
   }
}
