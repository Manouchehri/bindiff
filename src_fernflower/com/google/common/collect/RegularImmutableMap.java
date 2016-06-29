package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet$RegularEntrySet;
import com.google.common.collect.ImmutableSet;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class RegularImmutableMap extends ImmutableMap {
   private final transient Entry[] entries;
   private final transient ImmutableMapEntry[] table;
   private final transient int mask;
   private static final double MAX_LOAD_FACTOR = 1.2D;
   private static final long serialVersionUID = 0L;

   static RegularImmutableMap fromEntries(Entry... var0) {
      return fromEntryArray(var0.length, var0);
   }

   static RegularImmutableMap fromEntryArray(int var0, Entry[] var1) {
      Preconditions.checkPositionIndex(var0, var1.length);
      Object var2;
      if(var0 == var1.length) {
         var2 = var1;
      } else {
         var2 = ImmutableMapEntry.createEntryArray(var0);
      }

      int var3 = Hashing.closedTableSize(var0, 1.2D);
      ImmutableMapEntry[] var4 = ImmutableMapEntry.createEntryArray(var3);
      int var5 = var3 - 1;

      for(int var6 = 0; var6 < var0; ++var6) {
         Entry var7 = var1[var6];
         Object var8 = var7.getKey();
         Object var9 = var7.getValue();
         CollectPreconditions.checkEntryNotNull(var8, var9);
         int var10 = Hashing.smear(var8.hashCode()) & var5;
         ImmutableMapEntry var11 = var4[var10];
         Object var12;
         if(var11 != null) {
            var12 = new ImmutableMapEntry$NonTerminalImmutableMapEntry(var8, var9, var11);
         } else {
            boolean var13 = var7 instanceof ImmutableMapEntry && ((ImmutableMapEntry)var7).isReusable();
            var12 = var13?(ImmutableMapEntry)var7:new ImmutableMapEntry(var8, var9);
         }

         var4[var10] = (ImmutableMapEntry)var12;
         ((Object[])var2)[var6] = var12;
         checkNoConflictInKeyBucket(var8, (Entry)var12, var11);
      }

      return new RegularImmutableMap((Entry[])var2, var4, var5);
   }

   private RegularImmutableMap(Entry[] var1, ImmutableMapEntry[] var2, int var3) {
      this.entries = var1;
      this.table = var2;
      this.mask = var3;
   }

   static void checkNoConflictInKeyBucket(Object var0, Entry var1, @Nullable ImmutableMapEntry var2) {
      while(var2 != null) {
         checkNoConflict(!var0.equals(var2.getKey()), "key", var1, var2);
         var2 = var2.getNextInKeyBucket();
      }

   }

   public Object get(@Nullable Object var1) {
      return get(var1, this.table, this.mask);
   }

   @Nullable
   static Object get(@Nullable Object var0, ImmutableMapEntry[] var1, int var2) {
      if(var0 == null) {
         return null;
      } else {
         int var3 = Hashing.smear(var0.hashCode()) & var2;

         for(ImmutableMapEntry var4 = var1[var3]; var4 != null; var4 = var4.getNextInKeyBucket()) {
            Object var5 = var4.getKey();
            if(var0.equals(var5)) {
               return var4.getValue();
            }
         }

         return null;
      }
   }

   public int size() {
      return this.entries.length;
   }

   boolean isPartialView() {
      return false;
   }

   ImmutableSet createEntrySet() {
      return new ImmutableMapEntrySet$RegularEntrySet(this, this.entries);
   }
}
