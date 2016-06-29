package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapBuilder$ImmutableHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GoogleInternal
@GwtCompatible
public class ImmutableMapBuilder {
   private ImmutableMapBuilder$ImmutableHashMap map;

   @Deprecated
   public static ImmutableMapBuilder fromMap(Map var0) {
      ImmutableMapBuilder var1 = new ImmutableMapBuilder(var0.size());
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getKey(), var3.getValue());
      }

      return var1;
   }

   @Deprecated
   public ImmutableMapBuilder() {
      this(8);
   }

   @Deprecated
   public ImmutableMapBuilder(int var1) {
      this.map = new ImmutableMapBuilder$ImmutableHashMap(var1);
   }

   @Deprecated
   public ImmutableMapBuilder put(@Nullable Object var1, @Nullable Object var2) {
      Preconditions.checkState(this.map != null, "map has already been created");
      ImmutableMapBuilder$ImmutableHashMap.access$000(this.map, var1, var2);
      return this;
   }

   @Deprecated
   public Map getMap() {
      Preconditions.checkState(this.map != null, "map has already been created");

      ImmutableMapBuilder$ImmutableHashMap var1;
      try {
         var1 = this.map;
      } finally {
         this.map = null;
      }

      return var1;
   }
}
