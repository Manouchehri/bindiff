package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashSet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.ObjectArrays;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactHashSet extends AbstractSet implements Serializable {
   private static final int MAXIMUM_CAPACITY = 1073741824;
   private static final float DEFAULT_LOAD_FACTOR = 1.0F;
   private static final long NEXT_MASK = 4294967295L;
   private static final long HASH_MASK = -4294967296L;
   private static final int DEFAULT_SIZE = 3;
   static final int UNSET = -1;
   private transient int[] table;
   private transient long[] entries;
   transient Object[] elements;
   transient float loadFactor;
   transient int modCount;
   private transient int threshold;
   private transient int size;

   public static CompactHashSet create() {
      return new CompactHashSet();
   }

   public static CompactHashSet create(Collection var0) {
      CompactHashSet var1 = createWithExpectedSize(var0.size());
      var1.addAll(var0);
      return var1;
   }

   public static CompactHashSet create(Object... var0) {
      CompactHashSet var1 = createWithExpectedSize(var0.length);
      Collections.addAll(var1, var0);
      return var1;
   }

   public static CompactHashSet createWithExpectedSize(int var0) {
      return new CompactHashSet(var0);
   }

   CompactHashSet() {
      this.init(3, 1.0F);
   }

   CompactHashSet(int var1) {
      this.init(var1, 1.0F);
   }

   void init(int var1, float var2) {
      Preconditions.checkArgument(var1 >= 0, "Initial capacity must be non-negative");
      Preconditions.checkArgument(var2 > 0.0F, "Illegal load factor");
      int var3 = Hashing.closedTableSize(var1, (double)var2);
      this.table = newTable(var3);
      this.loadFactor = var2;
      this.elements = new Object[var1];
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

   private static int getHash(long var0) {
      return (int)(var0 >>> 32);
   }

   private static int getNext(long var0) {
      return (int)var0;
   }

   private static long swapNext(long var0, int var2) {
      return -4294967296L & var0 | 4294967295L & (long)var2;
   }

   private int hashTableMask() {
      return this.table.length - 1;
   }

   public boolean add(@Nullable Object var1) {
      long[] var2 = this.entries;
      Object[] var3 = this.elements;
      int var4 = Hashing.smearedHash(var1);
      int var5 = var4 & this.hashTableMask();
      int var6 = this.size;
      int var7 = this.table[var5];
      int var8;
      if(var7 == -1) {
         this.table[var5] = var6;
      } else {
         long var9;
         do {
            var8 = var7;
            var9 = var2[var7];
            if(getHash(var9) == var4 && Objects.equal(var1, var3[var7])) {
               return false;
            }

            var7 = getNext(var9);
         } while(var7 != -1);

         var2[var8] = swapNext(var9, var6);
      }

      if(var6 == Integer.MAX_VALUE) {
         throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
      } else {
         var8 = var6 + 1;
         this.resizeMeMaybe(var8);
         this.insertEntry(var6, var1, var4);
         this.size = var8;
         if(var6 >= this.threshold) {
            this.resizeTable(2 * this.table.length);
         }

         ++this.modCount;
         return true;
      }
   }

   void insertEntry(int var1, Object var2, int var3) {
      this.entries[var1] = (long)var3 << 32 | 4294967295L;
      this.elements[var1] = var2;
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
      this.elements = Arrays.copyOf(this.elements, var1);
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

   public boolean contains(@Nullable Object var1) {
      int var2 = Hashing.smearedHash(var1);

      long var4;
      for(int var3 = this.table[var2 & this.hashTableMask()]; var3 != -1; var3 = getNext(var4)) {
         var4 = this.entries[var3];
         if(getHash(var4) == var2 && Objects.equal(var1, this.elements[var3])) {
            return true;
         }
      }

      return false;
   }

   public boolean remove(@Nullable Object var1) {
      return this.remove(var1, Hashing.smearedHash(var1));
   }

   private boolean remove(Object var1, int var2) {
      int var3 = var2 & this.hashTableMask();
      int var4 = this.table[var3];
      if(var4 == -1) {
         return false;
      } else {
         int var5 = -1;

         do {
            if(getHash(this.entries[var4]) == var2 && Objects.equal(var1, this.elements[var4])) {
               if(var5 == -1) {
                  this.table[var3] = getNext(this.entries[var4]);
               } else {
                  this.entries[var5] = swapNext(this.entries[var5], getNext(this.entries[var4]));
               }

               this.moveEntry(var4);
               --this.size;
               ++this.modCount;
               return true;
            }

            var5 = var4;
            var4 = getNext(this.entries[var4]);
         } while(var4 != -1);

         return false;
      }
   }

   void moveEntry(int var1) {
      int var2 = this.size() - 1;
      if(var1 < var2) {
         this.elements[var1] = this.elements[var2];
         this.elements[var2] = null;
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
         this.elements[var1] = null;
         this.entries[var1] = -1L;
      }

   }

   public Iterator iterator() {
      return new CompactHashSet$1(this);
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public Object[] toArray() {
      return Arrays.copyOf(this.elements, this.size);
   }

   public Object[] toArray(Object[] var1) {
      return ObjectArrays.toArrayImpl(this.elements, 0, this.size, var1);
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
      Arrays.fill(this.elements, 0, this.size, (Object)null);
      Arrays.fill(this.table, -1);
      Arrays.fill(this.entries, -1L);
      this.size = 0;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size);
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.writeObject(var3);
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
         this.add(var4);
      }
   }

   // $FF: synthetic method
   static int access$000(CompactHashSet var0) {
      return var0.size;
   }

   // $FF: synthetic method
   static long[] access$100(CompactHashSet var0) {
      return var0.entries;
   }

   // $FF: synthetic method
   static int access$200(long var0) {
      return getHash(var0);
   }

   // $FF: synthetic method
   static boolean access$300(CompactHashSet var0, Object var1, int var2) {
      return var0.remove(var1, var2);
   }
}
