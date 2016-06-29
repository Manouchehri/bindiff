package com.google.common.collect;

import com.google.common.base.*;
import java.util.concurrent.*;

class ComputingConcurrentHashMap extends MapMakerInternalMap
{
    final Function computingFunction;
    private static final long serialVersionUID = 4L;
    
    ComputingConcurrentHashMap(final MapMaker mapMaker, final Function function) {
        super(mapMaker);
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    MapMakerInternalMap$Segment createSegment(final int n, final int n2) {
        return new ComputingConcurrentHashMap$ComputingSegment(this, n, n2);
    }
    
    @Override
    ComputingConcurrentHashMap$ComputingSegment segmentFor(final int n) {
        return (ComputingConcurrentHashMap$ComputingSegment)super.segmentFor(n);
    }
    
    Object getOrCompute(final Object o) {
        final int hash = this.hash(Preconditions.checkNotNull(o));
        return this.segmentFor(hash).getOrCompute(o, hash, this.computingFunction);
    }
    
    @Override
    Object writeReplace() {
        return new ComputingConcurrentHashMap$ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }
}
