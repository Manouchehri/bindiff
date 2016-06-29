package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableBiMap extends ForwardingMap implements BiMap, Serializable {
   final Map unmodifiableMap;
   final BiMap delegate;
   BiMap inverse;
   transient Set values;
   private static final long serialVersionUID = 0L;

   Maps$UnmodifiableBiMap(BiMap var1, @Nullable BiMap var2) {
      this.unmodifiableMap = Collections.unmodifiableMap(var1);
      this.delegate = var1;
      this.inverse = var2;
   }

   protected Map delegate() {
      return this.unmodifiableMap;
   }

   public Object forcePut(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public BiMap inverse() {
      BiMap var1 = this.inverse;
      return var1 == null?(this.inverse = new Maps$UnmodifiableBiMap(this.delegate.inverse(), this)):var1;
   }

   public Set values() {
      Set var1 = this.values;
      return var1 == null?(this.values = Collections.unmodifiableSet(this.delegate.values())):var1;
   }
}
