package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$KeySet;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class HashBiMap extends Maps$IteratorBasedAbstractMap implements BiMap, Serializable {
   private static final double LOAD_FACTOR = 1.0D;
   private transient HashBiMap$BiEntry[] hashTableKToV;
   private transient HashBiMap$BiEntry[] hashTableVToK;
   private transient HashBiMap$BiEntry firstInKeyInsertionOrder;
   private transient HashBiMap$BiEntry lastInKeyInsertionOrder;
   private transient int size;
   private transient int mask;
   private transient int modCount;
   private transient BiMap inverse;
   @GwtIncompatible("Not needed in emulated source")
   private static final long serialVersionUID = 0L;

   public static HashBiMap create() {
      return create(16);
   }

   public static HashBiMap create(int var0) {
      return new HashBiMap(var0);
   }

   public static HashBiMap create(Map var0) {
      HashBiMap var1 = create(var0.size());
      var1.putAll(var0);
      return var1;
   }

   private HashBiMap(int var1) {
      this.init(var1);
   }

   private void init(int var1) {
      CollectPreconditions.checkNonnegative(var1, "expectedSize");
      int var2 = Hashing.closedTableSize(var1, 1.0D);
      this.hashTableKToV = this.createTable(var2);
      this.hashTableVToK = this.createTable(var2);
      this.firstInKeyInsertionOrder = null;
      this.lastInKeyInsertionOrder = null;
      this.size = 0;
      this.mask = var2 - 1;
      this.modCount = 0;
   }

   private void delete(HashBiMap$BiEntry var1) {
      int var2 = var1.keyHash & this.mask;
      HashBiMap$BiEntry var3 = null;

      for(HashBiMap$BiEntry var4 = this.hashTableKToV[var2]; var4 != var1; var4 = var4.nextInKToVBucket) {
         var3 = var4;
      }

      if(var3 == null) {
         this.hashTableKToV[var2] = var1.nextInKToVBucket;
      } else {
         var3.nextInKToVBucket = var1.nextInKToVBucket;
      }

      int var6 = var1.valueHash & this.mask;
      var3 = null;

      for(HashBiMap$BiEntry var5 = this.hashTableVToK[var6]; var5 != var1; var5 = var5.nextInVToKBucket) {
         var3 = var5;
      }

      if(var3 == null) {
         this.hashTableVToK[var6] = var1.nextInVToKBucket;
      } else {
         var3.nextInVToKBucket = var1.nextInVToKBucket;
      }

      if(var1.prevInKeyInsertionOrder == null) {
         this.firstInKeyInsertionOrder = var1.nextInKeyInsertionOrder;
      } else {
         var1.prevInKeyInsertionOrder.nextInKeyInsertionOrder = var1.nextInKeyInsertionOrder;
      }

      if(var1.nextInKeyInsertionOrder == null) {
         this.lastInKeyInsertionOrder = var1.prevInKeyInsertionOrder;
      } else {
         var1.nextInKeyInsertionOrder.prevInKeyInsertionOrder = var1.prevInKeyInsertionOrder;
      }

      --this.size;
      ++this.modCount;
   }

   private void insert(HashBiMap$BiEntry var1, @Nullable HashBiMap$BiEntry var2) {
      int var3 = var1.keyHash & this.mask;
      var1.nextInKToVBucket = this.hashTableKToV[var3];
      this.hashTableKToV[var3] = var1;
      int var4 = var1.valueHash & this.mask;
      var1.nextInVToKBucket = this.hashTableVToK[var4];
      this.hashTableVToK[var4] = var1;
      if(var2 == null) {
         var1.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
         var1.nextInKeyInsertionOrder = null;
         if(this.lastInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = var1;
         } else {
            this.lastInKeyInsertionOrder.nextInKeyInsertionOrder = var1;
         }

         this.lastInKeyInsertionOrder = var1;
      } else {
         var1.prevInKeyInsertionOrder = var2.prevInKeyInsertionOrder;
         if(var1.prevInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = var1;
         } else {
            var1.prevInKeyInsertionOrder.nextInKeyInsertionOrder = var1;
         }

         var1.nextInKeyInsertionOrder = var2.nextInKeyInsertionOrder;
         if(var1.nextInKeyInsertionOrder == null) {
            this.lastInKeyInsertionOrder = var1;
         } else {
            var1.nextInKeyInsertionOrder.prevInKeyInsertionOrder = var1;
         }
      }

      ++this.size;
      ++this.modCount;
   }

   private HashBiMap$BiEntry seekByKey(@Nullable Object var1, int var2) {
      for(HashBiMap$BiEntry var3 = this.hashTableKToV[var2 & this.mask]; var3 != null; var3 = var3.nextInKToVBucket) {
         if(var2 == var3.keyHash && Objects.equal(var1, var3.key)) {
            return var3;
         }
      }

      return null;
   }

   private HashBiMap$BiEntry seekByValue(@Nullable Object var1, int var2) {
      for(HashBiMap$BiEntry var3 = this.hashTableVToK[var2 & this.mask]; var3 != null; var3 = var3.nextInVToKBucket) {
         if(var2 == var3.valueHash && Objects.equal(var1, var3.value)) {
            return var3;
         }
      }

      return null;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.seekByKey(var1, Hashing.smearedHash(var1)) != null;
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.seekByValue(var1, Hashing.smearedHash(var1)) != null;
   }

   @Nullable
   public Object get(@Nullable Object var1) {
      return Maps.valueOrNull(this.seekByKey(var1, Hashing.smearedHash(var1)));
   }

   public Object put(@Nullable Object var1, @Nullable Object var2) {
      return this.put(var1, var2, false);
   }

   public Object forcePut(@Nullable Object var1, @Nullable Object var2) {
      return this.put(var1, var2, true);
   }

   private Object put(@Nullable Object var1, @Nullable Object var2, boolean var3) {
      int var4 = Hashing.smearedHash(var1);
      int var5 = Hashing.smearedHash(var2);
      HashBiMap$BiEntry var6 = this.seekByKey(var1, var4);
      if(var6 != null && var5 == var6.valueHash && Objects.equal(var2, var6.value)) {
         return var2;
      } else {
         HashBiMap$BiEntry var7 = this.seekByValue(var2, var5);
         if(var7 != null) {
            if(!var3) {
               String var9 = String.valueOf(var2);
               throw new IllegalArgumentException((new StringBuilder(23 + String.valueOf(var9).length())).append("value already present: ").append(var9).toString());
            }

            this.delete(var7);
         }

         HashBiMap$BiEntry var8 = new HashBiMap$BiEntry(var1, var4, var2, var5);
         if(var6 != null) {
            this.delete(var6);
            this.insert(var8, var6);
            var6.prevInKeyInsertionOrder = null;
            var6.nextInKeyInsertionOrder = null;
            this.rehashIfNecessary();
            return var6.value;
         } else {
            this.insert(var8, (HashBiMap$BiEntry)null);
            this.rehashIfNecessary();
            return null;
         }
      }
   }

   @Nullable
   private Object putInverse(@Nullable Object var1, @Nullable Object var2, boolean var3) {
      int var4 = Hashing.smearedHash(var1);
      int var5 = Hashing.smearedHash(var2);
      HashBiMap$BiEntry var6 = this.seekByValue(var1, var4);
      if(var6 != null && var5 == var6.keyHash && Objects.equal(var2, var6.key)) {
         return var2;
      } else {
         HashBiMap$BiEntry var7 = this.seekByKey(var2, var5);
         if(var7 != null) {
            if(!var3) {
               String var9 = String.valueOf(var2);
               throw new IllegalArgumentException((new StringBuilder(23 + String.valueOf(var9).length())).append("value already present: ").append(var9).toString());
            }

            this.delete(var7);
         }

         if(var6 != null) {
            this.delete(var6);
         }

         HashBiMap$BiEntry var8 = new HashBiMap$BiEntry(var2, var5, var1, var4);
         this.insert(var8, var7);
         if(var7 != null) {
            var7.prevInKeyInsertionOrder = null;
            var7.nextInKeyInsertionOrder = null;
         }

         this.rehashIfNecessary();
         return Maps.keyOrNull(var6);
      }
   }

   private void rehashIfNecessary() {
      HashBiMap$BiEntry[] var1 = this.hashTableKToV;
      if(Hashing.needsResizing(this.size, var1.length, 1.0D)) {
         int var2 = var1.length * 2;
         this.hashTableKToV = this.createTable(var2);
         this.hashTableVToK = this.createTable(var2);
         this.mask = var2 - 1;
         this.size = 0;

         for(HashBiMap$BiEntry var3 = this.firstInKeyInsertionOrder; var3 != null; var3 = var3.nextInKeyInsertionOrder) {
            this.insert(var3, var3);
         }

         ++this.modCount;
      }

   }

   private HashBiMap$BiEntry[] createTable(int var1) {
      return new HashBiMap$BiEntry[var1];
   }

   public Object remove(@Nullable Object var1) {
      HashBiMap$BiEntry var2 = this.seekByKey(var1, Hashing.smearedHash(var1));
      if(var2 == null) {
         return null;
      } else {
         this.delete(var2);
         var2.prevInKeyInsertionOrder = null;
         var2.nextInKeyInsertionOrder = null;
         return var2.value;
      }
   }

   public void clear() {
      this.size = 0;
      Arrays.fill(this.hashTableKToV, (Object)null);
      Arrays.fill(this.hashTableVToK, (Object)null);
      this.firstInKeyInsertionOrder = null;
      this.lastInKeyInsertionOrder = null;
      ++this.modCount;
   }

   public int size() {
      return this.size;
   }

   public Set keySet() {
      return new HashBiMap$KeySet(this);
   }

   public Set values() {
      return this.inverse().keySet();
   }

   Iterator entryIterator() {
      return new HashBiMap$1(this);
   }

   public BiMap inverse() {
      return this.inverse == null?(this.inverse = new HashBiMap$Inverse(this, (HashBiMap$1)null)):this.inverse;
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      Serialization.writeMap(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.init(16);
      int var2 = Serialization.readCount(var1);
      Serialization.populateMap(this, var1, var2);
   }

   // $FF: synthetic method
   static HashBiMap$BiEntry access$000(HashBiMap var0) {
      return var0.firstInKeyInsertionOrder;
   }

   // $FF: synthetic method
   static int access$100(HashBiMap var0) {
      return var0.modCount;
   }

   // $FF: synthetic method
   static void access$200(HashBiMap var0, HashBiMap$BiEntry var1) {
      var0.delete(var1);
   }

   // $FF: synthetic method
   static HashBiMap$BiEntry access$300(HashBiMap var0, Object var1, int var2) {
      return var0.seekByKey(var1, var2);
   }

   // $FF: synthetic method
   static HashBiMap$BiEntry access$400(HashBiMap var0, Object var1, int var2) {
      return var0.seekByValue(var1, var2);
   }

   // $FF: synthetic method
   static void access$500(HashBiMap var0, HashBiMap$BiEntry var1, HashBiMap$BiEntry var2) {
      var0.insert(var1, var2);
   }

   // $FF: synthetic method
   static int access$700(HashBiMap var0) {
      return var0.size;
   }

   // $FF: synthetic method
   static Object access$800(HashBiMap var0, Object var1, Object var2, boolean var3) {
      return var0.putInverse(var1, var2, var3);
   }
}
