package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingSegment;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingSerializationProxy;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Segment;

class ComputingConcurrentHashMap extends MapMakerInternalMap {
   final Function computingFunction;
   private static final long serialVersionUID = 4L;

   ComputingConcurrentHashMap(MapMaker var1, Function var2) {
      super(var1);
      this.computingFunction = (Function)Preconditions.checkNotNull(var2);
   }

   MapMakerInternalMap$Segment createSegment(int var1, int var2) {
      return new ComputingConcurrentHashMap$ComputingSegment(this, var1, var2);
   }

   ComputingConcurrentHashMap$ComputingSegment segmentFor(int var1) {
      return (ComputingConcurrentHashMap$ComputingSegment)super.segmentFor(var1);
   }

   Object getOrCompute(Object var1) {
      int var2 = this.hash(Preconditions.checkNotNull(var1));
      return this.segmentFor(var2).getOrCompute(var1, var2, this.computingFunction);
   }

   Object writeReplace() {
      return new ComputingConcurrentHashMap$ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
   }
}
