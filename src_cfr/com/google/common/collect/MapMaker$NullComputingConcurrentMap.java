/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputationException;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$NullConcurrentMap;

final class MapMaker$NullComputingConcurrentMap
extends MapMaker$NullConcurrentMap {
    private static final long serialVersionUID = 0;
    final Function computingFunction;

    MapMaker$NullComputingConcurrentMap(MapMaker mapMaker, Function function) {
        super(mapMaker);
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public Object get(Object object) {
        Object object2 = object;
        Object object3 = this.compute(object2);
        Preconditions.checkNotNull(object3, "%s returned null for key %s.", this.computingFunction, object2);
        this.notifyRemoval(object2, object3);
        return object3;
    }

    private Object compute(Object object) {
        Preconditions.checkNotNull(object);
        try {
            return this.computingFunction.apply(object);
        }
        catch (ComputationException var2_2) {
            throw var2_2;
        }
        catch (Throwable var2_3) {
            throw new ComputationException(var2_3);
        }
    }
}

