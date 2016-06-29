/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingSegment;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingSerializationProxy;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import java.util.concurrent.ConcurrentMap;

class ComputingConcurrentHashMap
extends MapMakerInternalMap {
    final Function computingFunction;
    private static final long serialVersionUID = 4;

    ComputingConcurrentHashMap(MapMaker mapMaker, Function function) {
        super(mapMaker);
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    MapMakerInternalMap$Segment createSegment(int n2, int n3) {
        return new ComputingConcurrentHashMap$ComputingSegment(this, n2, n3);
    }

    @Override
    ComputingConcurrentHashMap$ComputingSegment segmentFor(int n2) {
        return (ComputingConcurrentHashMap$ComputingSegment)super.segmentFor(n2);
    }

    Object getOrCompute(Object object) {
        int n2 = this.hash(Preconditions.checkNotNull(object));
        return this.segmentFor(n2).getOrCompute(object, n2, this.computingFunction);
    }

    @Override
    Object writeReplace() {
        return new ComputingConcurrentHashMap$ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }
}

