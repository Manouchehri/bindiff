package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap$AbstractSerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

final class MapMakerInternalMap$SerializationProxy extends MapMakerInternalMap$AbstractSerializationProxy {
   private static final long serialVersionUID = 3L;

   MapMakerInternalMap$SerializationProxy(MapMakerInternalMap$Strength var1, MapMakerInternalMap$Strength var2, Equivalence var3, Equivalence var4, long var5, long var7, int var9, int var10, MapMaker$RemovalListener var11, ConcurrentMap var12) {
      super(var1, var2, var3, var4, var5, var7, var9, var10, var11, var12);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.writeMapTo(var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      MapMaker var2 = this.readMapMaker(var1);
      this.delegate = var2.makeMap();
      this.readEntries(var1);
   }

   private Object readResolve() {
      return this.delegate;
   }
}
