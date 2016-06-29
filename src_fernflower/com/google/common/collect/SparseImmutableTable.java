package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class SparseImmutableTable extends RegularImmutableTable {
   private final ImmutableMap rowMap;
   private final ImmutableMap columnMap;
   private final int[] iterationOrderRow;
   private final int[] iterationOrderColumn;

   SparseImmutableTable(ImmutableList var1, ImmutableSet var2, ImmutableSet var3) {
      ImmutableMap var4 = Maps.indexMap(var2);
      LinkedHashMap var5 = Maps.newLinkedHashMap();
      UnmodifiableIterator var6 = var2.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         var5.put(var7, new LinkedHashMap());
      }

      LinkedHashMap var20 = Maps.newLinkedHashMap();
      UnmodifiableIterator var21 = var3.iterator();

      while(var21.hasNext()) {
         Object var8 = var21.next();
         var20.put(var8, new LinkedHashMap());
      }

      int[] var22 = new int[var1.size()];
      int[] var23 = new int[var1.size()];

      for(int var9 = 0; var9 < var1.size(); ++var9) {
         Table$Cell var10 = (Table$Cell)var1.get(var9);
         Object var11 = var10.getRowKey();
         Object var12 = var10.getColumnKey();
         Object var13 = var10.getValue();
         var22[var9] = ((Integer)var4.get(var11)).intValue();
         Map var14 = (Map)var5.get(var11);
         var23[var9] = var14.size();
         Object var15 = var14.put(var12, var13);
         if(var15 != null) {
            String var16 = String.valueOf(var11);
            String var17 = String.valueOf(var12);
            String var18 = String.valueOf(var13);
            String var19 = String.valueOf(var15);
            throw new IllegalArgumentException((new StringBuilder(37 + String.valueOf(var16).length() + String.valueOf(var17).length() + String.valueOf(var18).length() + String.valueOf(var19).length())).append("Duplicate value for row=").append(var16).append(", column=").append(var17).append(": ").append(var18).append(", ").append(var19).toString());
         }

         ((Map)var20.get(var12)).put(var11, var13);
      }

      this.iterationOrderRow = var22;
      this.iterationOrderColumn = var23;
      ImmutableMap$Builder var24 = new ImmutableMap$Builder(var5.size());
      Iterator var25 = var5.entrySet().iterator();

      while(var25.hasNext()) {
         Entry var27 = (Entry)var25.next();
         var24.put(var27.getKey(), ImmutableMap.copyOf((Map)var27.getValue()));
      }

      this.rowMap = var24.build();
      ImmutableMap$Builder var26 = new ImmutableMap$Builder(var20.size());
      Iterator var28 = var20.entrySet().iterator();

      while(var28.hasNext()) {
         Entry var29 = (Entry)var28.next();
         var26.put(var29.getKey(), ImmutableMap.copyOf((Map)var29.getValue()));
      }

      this.columnMap = var26.build();
   }

   public ImmutableMap columnMap() {
      return this.columnMap;
   }

   public ImmutableMap rowMap() {
      return this.rowMap;
   }

   public int size() {
      return this.iterationOrderRow.length;
   }

   Table$Cell getCell(int var1) {
      int var2 = this.iterationOrderRow[var1];
      Entry var3 = (Entry)this.rowMap.entrySet().asList().get(var2);
      ImmutableMap var4 = (ImmutableMap)var3.getValue();
      int var5 = this.iterationOrderColumn[var1];
      Entry var6 = (Entry)var4.entrySet().asList().get(var5);
      return cellOf(var3.getKey(), var6.getKey(), var6.getValue());
   }

   Object getValue(int var1) {
      int var2 = this.iterationOrderRow[var1];
      ImmutableMap var3 = (ImmutableMap)this.rowMap.values().asList().get(var2);
      int var4 = this.iterationOrderColumn[var1];
      return var3.values().asList().get(var4);
   }
}
