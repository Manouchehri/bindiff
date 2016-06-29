package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import java.util.Map;
import java.util.Set;

class MapConstraints$ConstrainedMap extends ForwardingMap {
   private final Map delegate;
   final MapConstraint constraint;
   private transient Set entrySet;

   MapConstraints$ConstrainedMap(Map var1, MapConstraint var2) {
      this.delegate = (Map)Preconditions.checkNotNull(var1);
      this.constraint = (MapConstraint)Preconditions.checkNotNull(var2);
   }

   protected Map delegate() {
      return this.delegate;
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      if(var1 == null) {
         this.entrySet = var1 = MapConstraints.access$000(this.delegate.entrySet(), this.constraint);
      }

      return var1;
   }

   public Object put(Object var1, Object var2) {
      this.constraint.checkKeyValue(var1, var2);
      return this.delegate.put(var1, var2);
   }

   public void putAll(Map var1) {
      this.delegate.putAll(MapConstraints.access$100(var1, this.constraint));
   }
}
