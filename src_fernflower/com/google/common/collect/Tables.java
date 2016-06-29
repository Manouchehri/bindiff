package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables$1;
import com.google.common.collect.Tables$ImmutableCell;
import com.google.common.collect.Tables$TransformedTable;
import com.google.common.collect.Tables$TransposeTable;
import com.google.common.collect.Tables$UnmodifiableRowSortedMap;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public final class Tables {
   private static final Function UNMODIFIABLE_WRAPPER = new Tables$1();

   public static Table$Cell immutableCell(@Nullable Object var0, @Nullable Object var1, @Nullable Object var2) {
      return new Tables$ImmutableCell(var0, var1, var2);
   }

   public static Table transpose(Table var0) {
      return (Table)(var0 instanceof Tables$TransposeTable?((Tables$TransposeTable)var0).original:new Tables$TransposeTable(var0));
   }

   @Beta
   public static Table newCustomTable(Map var0, Supplier var1) {
      Preconditions.checkArgument(var0.isEmpty());
      Preconditions.checkNotNull(var1);
      return new StandardTable(var0, var1);
   }

   @Beta
   public static Table transformValues(Table var0, Function var1) {
      return new Tables$TransformedTable(var0, var1);
   }

   public static Table unmodifiableTable(Table var0) {
      return new Tables$UnmodifiableTable(var0);
   }

   @Beta
   public static RowSortedTable unmodifiableRowSortedTable(RowSortedTable var0) {
      return new Tables$UnmodifiableRowSortedMap(var0);
   }

   private static Function unmodifiableWrapper() {
      return UNMODIFIABLE_WRAPPER;
   }

   static boolean equalsImpl(Table var0, @Nullable Object var1) {
      if(var1 == var0) {
         return true;
      } else if(var1 instanceof Table) {
         Table var2 = (Table)var1;
         return var0.cellSet().equals(var2.cellSet());
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static Function access$000() {
      return unmodifiableWrapper();
   }
}
