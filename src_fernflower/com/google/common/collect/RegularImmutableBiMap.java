package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableBiMapEntry;
import com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap$1;
import com.google.common.collect.RegularImmutableBiMap$Inverse;
import com.google.common.collect.RegularImmutableMap;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
class RegularImmutableBiMap extends ImmutableBiMap {
   static final RegularImmutableBiMap EMPTY;
   static final double MAX_LOAD_FACTOR = 1.2D;
   private final transient ImmutableMapEntry[] keyTable;
   private final transient ImmutableMapEntry[] valueTable;
   private final transient Entry[] entries;
   private final transient int mask;
   private final transient int hashCode;
   @LazyInit
   private transient ImmutableBiMap inverse;

   static RegularImmutableBiMap fromEntries(Entry... var0) {
      return fromEntryArray(var0.length, var0);
   }

   static RegularImmutableBiMap fromEntryArray(int var0, Entry[] var1) {
      Preconditions.checkPositionIndex(var0, var1.length);
      int var2 = Hashing.closedTableSize(var0, 1.2D);
      int var3 = var2 - 1;
      ImmutableMapEntry[] var4 = ImmutableMapEntry.createEntryArray(var2);
      ImmutableMapEntry[] var5 = ImmutableMapEntry.createEntryArray(var2);
      Object var6;
      if(var0 == var1.length) {
         var6 = var1;
      } else {
         var6 = ImmutableMapEntry.createEntryArray(var0);
      }

      int var7 = 0;

      for(int var8 = 0; var8 < var0; ++var8) {
         Entry var9 = var1[var8];
         Object var10 = var9.getKey();
         Object var11 = var9.getValue();
         CollectPreconditions.checkEntryNotNull(var10, var11);
         int var12 = var10.hashCode();
         int var13 = var11.hashCode();
         int var14 = Hashing.smear(var12) & var3;
         int var15 = Hashing.smear(var13) & var3;
         ImmutableMapEntry var16 = var4[var14];
         RegularImmutableMap.checkNoConflictInKeyBucket(var10, var9, var16);
         ImmutableMapEntry var17 = var5[var15];
         checkNoConflictInValueBucket(var11, var9, var17);
         Object var18;
         if(var17 == null && var16 == null) {
            boolean var19 = var9 instanceof ImmutableMapEntry && ((ImmutableMapEntry)var9).isReusable();
            var18 = var19?(ImmutableMapEntry)var9:new ImmutableMapEntry(var10, var11);
         } else {
            var18 = new ImmutableMapEntry$NonTerminalImmutableBiMapEntry(var10, var11, var16, var17);
         }

         var4[var14] = (ImmutableMapEntry)var18;
         var5[var15] = (ImmutableMapEntry)var18;
         ((Object[])var6)[var8] = var18;
         var7 += var12 ^ var13;
      }

      return new RegularImmutableBiMap(var4, var5, (Entry[])var6, var3, var7);
   }

   private RegularImmutableBiMap(ImmutableMapEntry[] var1, ImmutableMapEntry[] var2, Entry[] var3, int var4, int var5) {
      this.keyTable = var1;
      this.valueTable = var2;
      this.entries = var3;
      this.mask = var4;
      this.hashCode = var5;
   }

   private static void checkNoConflictInValueBucket(Object var0, Entry var1, @Nullable ImmutableMapEntry var2) {
      while(var2 != null) {
         checkNoConflict(!var0.equals(var2.getValue()), "value", var1, var2);
         var2 = var2.getNextInValueBucket();
      }

   }

   @Nullable
   public Object get(@Nullable Object var1) {
      return this.keyTable == null?null:RegularImmutableMap.get(var1, this.keyTable, this.mask);
   }

   ImmutableSet createEntrySet() {
      return (ImmutableSet)(this.isEmpty()?ImmutableSet.of():new ImmutableMapEntrySet$RegularEntrySet(this, this.entries));
   }

   boolean isHashCodeFast() {
      return true;
   }

   public int hashCode() {
      return this.hashCode;
   }

   boolean isPartialView() {
      return false;
   }

   public int size() {
      return this.entries.length;
   }

   public ImmutableBiMap inverse() {
      if(this.isEmpty()) {
         return ImmutableBiMap.of();
      } else {
         ImmutableBiMap var1 = this.inverse;
         return var1 == null?(this.inverse = new RegularImmutableBiMap$Inverse(this, (RegularImmutableBiMap$1)null)):var1;
      }
   }

   // $FF: synthetic method
   static ImmutableMapEntry[] access$100(RegularImmutableBiMap var0) {
      return var0.valueTable;
   }

   // $FF: synthetic method
   static int access$200(RegularImmutableBiMap var0) {
      return var0.mask;
   }

   // $FF: synthetic method
   static int access$300(RegularImmutableBiMap var0) {
      return var0.hashCode;
   }

   // $FF: synthetic method
   static Entry[] access$400(RegularImmutableBiMap var0) {
      return var0.entries;
   }

   static {
      EMPTY = new RegularImmutableBiMap((ImmutableMapEntry[])null, (ImmutableMapEntry[])null, (Entry[])ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
   }
}
