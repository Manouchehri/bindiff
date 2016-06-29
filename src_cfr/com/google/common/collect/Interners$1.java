/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import java.util.concurrent.ConcurrentMap;

final class Interners$1
implements Interner {
    final /* synthetic */ ConcurrentMap val$map;

    Interners$1(ConcurrentMap concurrentMap) {
        this.val$map = concurrentMap;
    }

    @Override
    public Object intern(Object object) {
        Object object2;
        Object object3 = this.val$map.putIfAbsent(Preconditions.checkNotNull(object), object);
        if (object3 == null) {
            object2 = object;
            return object2;
        }
        object2 = object3;
        return object2;
    }
}

