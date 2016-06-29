package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.ForwardingConcurrentMap;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class MapMakerInternalMap$AbstractSerializationProxy extends ForwardingConcurrentMap implements Serializable {
   private static final long serialVersionUID = 3L;
   final MapMakerInternalMap$Strength keyStrength;
   final MapMakerInternalMap$Strength valueStrength;
   final Equivalence keyEquivalence;
   final Equivalence valueEquivalence;
   final long expireAfterWriteNanos;
   final long expireAfterAccessNanos;
   final int maximumSize;
   final int concurrencyLevel;
   final MapMaker$RemovalListener removalListener;
   transient ConcurrentMap delegate;

   MapMakerInternalMap$AbstractSerializationProxy(MapMakerInternalMap$Strength var1, MapMakerInternalMap$Strength var2, Equivalence var3, Equivalence var4, long var5, long var7, int var9, int var10, MapMaker$RemovalListener var11, ConcurrentMap var12) {
      this.keyStrength = var1;
      this.valueStrength = var2;
      this.keyEquivalence = var3;
      this.valueEquivalence = var4;
      this.expireAfterWriteNanos = var5;
      this.expireAfterAccessNanos = var7;
      this.maximumSize = var9;
      this.concurrencyLevel = var10;
      this.removalListener = var11;
      this.delegate = var12;
   }

   protected ConcurrentMap delegate() {
      return this.delegate;
   }

   void writeMapTo(ObjectOutputStream var1) {
      var1.writeInt(this.delegate.size());
      Iterator var2 = this.delegate.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
      }

      var1.writeObject((Object)null);
   }

   MapMaker readMapMaker(ObjectInputStream var1) {
      int var2 = var1.readInt();
      MapMaker var3 = (new MapMaker()).initialCapacity(var2).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).concurrencyLevel(this.concurrencyLevel);
      var3.removalListener(this.removalListener);
      if(this.expireAfterWriteNanos > 0L) {
         var3.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
      }

      if(this.expireAfterAccessNanos > 0L) {
         var3.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
      }

      if(this.maximumSize != -1) {
         var3.maximumSize(this.maximumSize);
      }

      return var3;
   }

   void readEntries(ObjectInputStream var1) {
      while(true) {
         Object var2 = var1.readObject();
         if(var2 == null) {
            return;
         }

         Object var3 = var1.readObject();
         this.delegate.put(var2, var3);
      }
   }
}
