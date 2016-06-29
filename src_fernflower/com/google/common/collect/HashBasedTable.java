package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBasedTable$Factory;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
public class HashBasedTable extends StandardTable {
   private static final long serialVersionUID = 0L;

   public static HashBasedTable create() {
      return new HashBasedTable(new HashMap(), new HashBasedTable$Factory(0));
   }

   public static HashBasedTable create(int var0, int var1) {
      CollectPreconditions.checkNonnegative(var1, "expectedCellsPerRow");
      HashMap var2 = Maps.newHashMapWithExpectedSize(var0);
      return new HashBasedTable(var2, new HashBasedTable$Factory(var1));
   }

   public static HashBasedTable create(Table var0) {
      HashBasedTable var1 = create();
      var1.putAll(var0);
      return var1;
   }

   HashBasedTable(Map var1, HashBasedTable$Factory var2) {
      super(var1, var2);
   }

   public boolean contains(@Nullable Object var1, @Nullable Object var2) {
      return super.contains(var1, var2);
   }

   public boolean containsColumn(@Nullable Object var1) {
      return super.containsColumn(var1);
   }

   public boolean containsRow(@Nullable Object var1) {
      return super.containsRow(var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      return super.containsValue(var1);
   }

   public Object get(@Nullable Object var1, @Nullable Object var2) {
      return super.get(var1, var2);
   }

   public boolean equals(@Nullable Object var1) {
      return super.equals(var1);
   }

   public Object remove(@Nullable Object var1, @Nullable Object var2) {
      return super.remove(var1, var2);
   }
}
