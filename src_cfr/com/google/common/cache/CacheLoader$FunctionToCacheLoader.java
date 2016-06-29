/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

final class CacheLoader$FunctionToCacheLoader
extends CacheLoader
implements Serializable {
    private final Function computingFunction;
    private static final long serialVersionUID = 0;

    public CacheLoader$FunctionToCacheLoader(Function function) {
        this.computingFunction = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public Object load(Object object) {
        return this.computingFunction.apply(Preconditions.checkNotNull(object));
    }
}

