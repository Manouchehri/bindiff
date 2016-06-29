package com.google.common.collect;

import com.google.common.collect.ImmutableClassToInstanceMap;
import com.google.common.collect.ImmutableClassToInstanceMap$1;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.primitives.Primitives;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableClassToInstanceMap$Builder {
   private final ImmutableMap$Builder mapBuilder = ImmutableMap.builder();

   public ImmutableClassToInstanceMap$Builder put(Class var1, Object var2) {
      this.mapBuilder.put(var1, var2);
      return this;
   }

   public ImmutableClassToInstanceMap$Builder putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         Class var4 = (Class)var3.getKey();
         Object var5 = var3.getValue();
         this.mapBuilder.put(var4, cast(var4, var5));
      }

      return this;
   }

   private static Object cast(Class var0, Object var1) {
      return Primitives.wrap(var0).cast(var1);
   }

   public ImmutableClassToInstanceMap build() {
      ImmutableMap var1 = this.mapBuilder.build();
      return var1.isEmpty()?ImmutableClassToInstanceMap.of():new ImmutableClassToInstanceMap(var1, (ImmutableClassToInstanceMap$1)null);
   }
}
