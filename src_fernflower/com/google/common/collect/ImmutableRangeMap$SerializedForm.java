package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map.Entry;

class ImmutableRangeMap$SerializedForm implements Serializable {
   private final ImmutableMap mapOfRanges;
   private static final long serialVersionUID = 0L;

   ImmutableRangeMap$SerializedForm(ImmutableMap var1) {
      this.mapOfRanges = var1;
   }

   Object readResolve() {
      return this.mapOfRanges.isEmpty()?ImmutableRangeMap.of():this.createRangeMap();
   }

   Object createRangeMap() {
      ImmutableRangeMap$Builder var1 = new ImmutableRangeMap$Builder();
      UnmodifiableIterator var2 = this.mapOfRanges.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put((Range)var3.getKey(), var3.getValue());
      }

      return var1.build();
   }
}
