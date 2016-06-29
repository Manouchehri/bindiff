package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MapConstraints$InverseConstraint;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedBiMap extends MapConstraints$ConstrainedMap implements BiMap {
   volatile BiMap inverse;

   MapConstraints$ConstrainedBiMap(BiMap var1, @Nullable BiMap var2, MapConstraint var3) {
      super(var1, var3);
      this.inverse = var2;
   }

   protected BiMap delegate() {
      return (BiMap)super.delegate();
   }

   public Object forcePut(Object var1, Object var2) {
      this.constraint.checkKeyValue(var1, var2);
      return this.delegate().forcePut(var1, var2);
   }

   public BiMap inverse() {
      if(this.inverse == null) {
         this.inverse = new MapConstraints$ConstrainedBiMap(this.delegate().inverse(), this, new MapConstraints$InverseConstraint(this.constraint));
      }

      return this.inverse;
   }

   public Set values() {
      return this.delegate().values();
   }
}
