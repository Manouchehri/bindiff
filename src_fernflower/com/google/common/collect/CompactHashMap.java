package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactHashMap$KeySetView;
import com.google.common.collect.CompactHashMap$ValuesView;
import com.google.common.collect.Hashing;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactHashMap extends AbstractMap implements Serializable {
   private static final int MAXIMUM_CAPACITY = 1073741824;
   static final float DEFAULT_LOAD_FACTOR = 1.0F;
   private static final long NEXT_MASK = 4294967295L;
   private static final long HASH_MASK = -4294967296L;
   static final int DEFAULT_SIZE = 3;
   static final int UNSET = -1;
   private transient int[] table;
   @VisibleForTesting
   transient long[] entries;
   @VisibleForTesting
   transient Object[] keys;
   @VisibleForTesting
   transient Object[] values;
   transient float loadFactor;
   transient int modCount;
   private transient int threshold;
   private transient int size;
   private transient Set keySetView;
   private transient Set entrySetView;
   private transient Collection valuesView;

   public static CompactHashMap create() {
      return new CompactHashMap();
   }

   public static CompactHashMap createWithExpectedSize(int var0) {
      return new CompactHashMap(var0);
   }

   CompactHashMap() {
      this.init(3, 1.0F);
   }

   CompactHashMap(int var1) {
      this(var1, 1.0F);
   }

   CompactHashMap(int var1, float var2) {
      this.init(var1, var2);
   }

   void init(int var1, float var2) {
      Preconditions.checkArgument(var1 >= 0, "Initial capacity must be non-negative");
      Preconditions.checkArgument(var2 > 0.0F, "Illegal load factor");
      int var3 = Hashing.closedTableSize(var1, (double)var2);
      this.table = newTable(var3);
      this.loadFactor = var2;
      this.keys = new Object[var1];
      this.values = new Object[var1];
      this.entries = newEntries(var1);
      this.threshold = Math.max(1, (int)((float)var3 * var2));
   }

   private static int[] newTable(int var0) {
      int[] var1 = new int[var0];
      Arrays.fill(var1, -1);
      return var1;
   }

   private static long[] newEntries(int var0) {
      long[] var1 = new long[var0];
      Arrays.fill(var1, -1L);
      return var1;
   }

   private int hashTableMask() {
      return this.table.length - 1;
   }

   private static int getHash(long var0) {
      return (int)(var0 >>> 32);
   }

   private static int getNext(long var0) {
      return (int)var0;
   }

   private static long swapNext(long var0, int var2) {
      return -4294967296L & var0 | 4294967295L & (long)var2;
   }

   void accessEntry(int var1) {
   }

   @Nullable
   public Object put(@Nullable Object var1, @Nullable Object var2) {
      long[] var3 = this.entries;
      Object[] var4 = this.keys;
      Object[] var5 = this.values;
      int var6 = Hashing.smearedHash(var1);
      int var7 = var6 & this.hashTableMask();
      int var8 = this.size;
      int var9 = this.table[var7];
      int var10;
      if(var9 == -1) {
         this.table[var7] = var8;
      } else {
         long var11;
         do {
            var10 = var9;
            var11 = var3[var9];
            if(getHash(var11) == var6 && Objects.equal(var1, var4[var9])) {
               Object var13 = var5[var9];
               var5[var9] = var2;
               this.accessEntry(var9);
               return var13;
            }

            var9 = getNext(var11);
         } while(var9 != -1);

         var3[var10] = swapNext(var11, var8);
      }

      if(var8 == Integer.MAX_VALUE) {
         throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
      } else {
         var10 = var8 + 1;
         this.resizeMeMaybe(var10);
         this.insertEntry(var8, var1, var2, var6);
         this.size = var10;
         if(var8 >= this.threshold) {
            this.resizeTable(2 * this.table.length);
         }

         ++this.modCount;
         return null;
      }
   }

   void insertEntry(int var1, @Nullable Object var2, @Nullable Object var3, int var4) {
      this.entries[var1] = (long)var4 << 32 | 4294967295L;
      this.keys[var1] = var2;
      this.values[var1] = var3;
   }

   private void resizeMeMaybe(int var1) {
      int var2 = this.entries.length;
      if(var1 > var2) {
         int var3 = var2 + Math.max(1, var2 >>> 1);
         if(var3 < 0) {
            var3 = Integer.MAX_VALUE;
         }

         if(var3 != var2) {
            this.resizeEntries(var3);
         }
      }

   }

   void resizeEntries(int var1) {
      this.keys = Arrays.copyOf(this.keys, var1);
      this.values = Arrays.copyOf(this.values, var1);
      long[] var2 = this.entries;
      int var3 = var2.length;
      var2 = Arrays.copyOf(var2, var1);
      if(var1 > var3) {
         Arrays.fill(var2, var3, var1, -1L);
      }

      this.entries = var2;
   }

   private void resizeTable(int var1) {
      int[] var2 = this.table;
      int var3 = var2.length;
      if(var3 >= 1073741824) {
         this.threshold = Integer.MAX_VALUE;
      } else {
         int var4 = 1 + (int)((float)var1 * this.loadFactor);
         int[] var5 = newTable(var1);
         long[] var6 = this.entries;
         int var7 = var5.length - 1;

         for(int var8 = 0; var8 < this.size; ++var8) {
            long var9 = var6[var8];
            int var11 = getHash(var9);
            int var12 = var11 & var7;
            int var13 = var5[var12];
            var5[var12] = var8;
            var6[var8] = (long)var11 << 32 | 4294967295L & (long)var13;
         }

         this.threshold = var4;
         this.table = var5;
      }
   }

   private int indexOf(@Nullable Object var1) {
      int var2 = Hashing.smearedHash(var1);

      long var4;
      for(int var3 = this.table[var2 & this.hashTableMask()]; var3 != -1; var3 = getNext(var4)) {
         var4 = this.entries[var3];
         if(getHash(var4) == var2 && Objects.equal(var1, this.keys[var3])) {
            return var3;
         }
      }

      return -1;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.indexOf(var1) != -1;
   }

   public Object get(@Nullable Object var1) {
      int var2 = this.indexOf(var1);
      this.accessEntry(var2);
      return var2 == -1?null:this.values[var2];
   }

   @Nullable
   public Object remove(@Nullable Object var1) {
      return this.remove(var1, Hashing.smearedHash(var1));
   }

   private Object removeEntry(int var1) {
      return this.remove(this.keys[var1], getHash(this.entries[var1]));
   }

   @Nullable
   private Object remove(@Nullable Object var1, int var2) {
      int var3 = var2 & this.hashTableMask();
      int var4 = this.table[var3];
      if(var4 == -1) {
         return null;
      } else {
         int var5 = -1;

         do {
            if(getHash(this.entries[var4]) == var2 && Objects.equal(var1, this.keys[var4])) {
               Object var6 = this.values[var4];
               if(var5 == -1) {
                  this.table[var3] = getNext(this.entries[var4]);
               } else {
                  this.entries[var5] = swapNext(this.entries[var5], getNext(this.entries[var4]));
               }

               this.moveLastEntry(var4);
               --this.size;
               ++this.modCount;
               return var6;
            }

            var5 = var4;
            var4 = getNext(this.entries[var4]);
         } while(var4 != -1);

         return null;
      }
   }

   void moveLastEntry(int var1) {
      int var2 = this.size() - 1;
      if(var1 < var2) {
         this.keys[var1] = this.keys[var2];
         this.values[var1] = this.values[var2];
         this.keys[var2] = null;
         this.values[var2] = null;
         long var3 = this.entries[var2];
         this.entries[var1] = var3;
         this.entries[var2] = -1L;
         int var5 = getHash(var3) & this.hashTableMask();
         int var6 = this.table[var5];
         if(var6 == var2) {
            this.table[var5] = var1;
         } else {
            int var7;
            long var8;
            do {
               var7 = var6;
               var6 = getNext(var8 = this.entries[var6]);
            } while(var6 != var2);

            this.entries[var7] = swapNext(var8, var1);
         }
      } else {
         this.keys[var1] = null;
         this.values[var1] = null;
         this.entries[var1] = -1L;
      }

   }

   public Set keySet() {
      return this.keySetView == null?(this.keySetView = this.createKeySet()):this.keySetView;
   }

   Set createKeySet() {
      return new CompactHashMap$KeySetView(this);
   }

   public Set entrySet() {
      return this.entrySetView == null?(this.entrySetView = this.createEntrySet()):this.entrySetView;
   }

   Set createEntrySet() {
      return new CompactHashMap$EntrySetView(this);
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public boolean containsValue(@Nullable Object var1) {
      for(int var2 = 0; var2 < this.size; ++var2) {
         if(Objects.equal(var1, this.values[var2])) {
            return true;
         }
      }

      return false;
   }

   public Collection values() {
      return this.valuesView == null?(this.valuesView = this.createValues()):this.valuesView;
   }

   Collection createValues() {
      return new CompactHashMap$ValuesView(this);
   }

   public void trimToSize() {
      int var1 = this.size;
      if(var1 < this.entries.length) {
         this.resizeEntries(var1);
      }

      int var2 = Math.max(1, Integer.highestOneBit((int)((float)var1 / this.loadFactor)));
      if(var2 < 1073741824) {
         double var3 = (double)var1 / (double)var2;
         if(var3 > (double)this.loadFactor) {
            var2 <<= 1;
         }
      }

      if(var2 < this.table.length) {
         this.resizeTable(var2);
      }

   }

   public void clear() {
      ++this.modCount;
      Arrays.fill(this.keys, 0, this.size, (Object)null);
      Arrays.fill(this.values, 0, this.size, (Object)null);
      Arrays.fill(this.table, -1);
      Arrays.fill(this.entries, -1L);
      this.size = 0;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size);

      for(int var2 = 0; var2 < this.size; ++var2) {
         var1.writeObject(this.keys[var2]);
         var1.writeObject(this.values[var2]);
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.init(3, 1.0F);
      int var2 = var1.readInt();
      int var3 = var2;

      while(true) {
         --var3;
         if(var3 < 0) {
            return;
         }

         Object var4 = var1.readObject();
         Object var5 = var1.readObject();
         this.put(var4, var5);
      }
   }

   // $FF: synthetic method
   static int access$000(CompactHashMap var0) {
      return var0.size;
   }

   // $FF: synthetic method
   static Object access$100(CompactHashMap var0, int var1) {
      return var0.removeEntry(var1);
   }

   // $FF: synthetic method
   static int access$200(CompactHashMap var0, Object var1) {
      return var0.indexOf(var1);
   }
}
