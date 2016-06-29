package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map.Entry;

class ImmutableMap$SerializedForm implements Serializable {
   private final Object[] keys;
   private final Object[] values;
   private static final long serialVersionUID = 0L;

   ImmutableMap$SerializedForm(ImmutableMap var1) {
      this.keys = new Object[var1.size()];
      this.values = new Object[var1.size()];
      int var2 = 0;

      for(UnmodifiableIterator var3 = var1.entrySet().iterator(); var3.hasNext(); ++var2) {
         Entry var4 = (Entry)var3.next();
         this.keys[var2] = var4.getKey();
         this.values[var2] = var4.getValue();
      }

   }

   Object readResolve() {
      ImmutableMap$Builder var1 = new ImmutableMap$Builder(this.keys.length);
      return this.createMap(var1);
   }

   Object createMap(ImmutableMap$Builder var1) {
      for(int var2 = 0; var2 < this.keys.length; ++var2) {
         var1.put(this.keys[var2], this.values[var2]);
      }

      return var1.build();
   }
}
