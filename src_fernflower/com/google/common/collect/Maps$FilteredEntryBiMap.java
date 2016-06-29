package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BiMap;
import com.google.common.collect.Maps$FilteredEntryBiMap$1;
import com.google.common.collect.Maps$FilteredEntryMap;
import java.util.Set;
import javax.annotation.Nullable;

final class Maps$FilteredEntryBiMap extends Maps$FilteredEntryMap implements BiMap {
   private final BiMap inverse;

   private static Predicate inversePredicate(Predicate var0) {
      return new Maps$FilteredEntryBiMap$1(var0);
   }

   Maps$FilteredEntryBiMap(BiMap var1, Predicate var2) {
      super(var1, var2);
      this.inverse = new Maps$FilteredEntryBiMap(var1.inverse(), inversePredicate(var2), this);
   }

   private Maps$FilteredEntryBiMap(BiMap var1, Predicate var2, BiMap var3) {
      super(var1, var2);
      this.inverse = var3;
   }

   BiMap unfiltered() {
      return (BiMap)this.unfiltered;
   }

   public Object forcePut(@Nullable Object var1, @Nullable Object var2) {
      Preconditions.checkArgument(this.apply(var1, var2));
      return this.unfiltered().forcePut(var1, var2);
   }

   public BiMap inverse() {
      return this.inverse;
   }

   public Set values() {
      return this.inverse.keySet();
   }
}
