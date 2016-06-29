/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap
extends ForwardingMap
implements ConcurrentMap {
    protected ForwardingConcurrentMap() {
    }

    @Override
    protected abstract ConcurrentMap delegate();

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        return this.delegate().putIfAbsent(object, object2);
    }

    @Override
    public boolean remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    @Override
    public Object replace(Object object, Object object2) {
        return this.delegate().replace(object, object2);
    }

    @Override
    public boolean replace(Object object, Object object2, Object object3) {
        return this.delegate().replace(object, object2, object3);
    }
}

