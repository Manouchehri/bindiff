/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ComputationException;
import com.google.common.collect.ComputingConcurrentHashMap;
import com.google.common.collect.MapMaker;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

final class MapMaker$ComputingMapAdapter
extends ComputingConcurrentHashMap
implements Serializable {
    private static final long serialVersionUID = 0;

    MapMaker$ComputingMapAdapter(MapMaker mapMaker, Function function) {
        super(mapMaker, function);
    }

    @Override
    public Object get(Object object) {
        Object object2;
        try {
            object2 = this.getOrCompute(object);
        }
        catch (ExecutionException var3_3) {
            Throwable throwable = var3_3.getCause();
            Throwables.propagateIfInstanceOf(throwable, ComputationException.class);
            throw new ComputationException(throwable);
        }
        if (object2 != null) return object2;
        String string = String.valueOf(this.computingFunction);
        String string2 = String.valueOf(object);
        throw new NullPointerException(new StringBuilder(24 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" returned null for key ").append(string2).append(".").toString());
    }
}

