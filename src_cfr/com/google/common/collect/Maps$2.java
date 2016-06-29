/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;

final class Maps$2
extends ForwardingSet {
    final /* synthetic */ Set val$set;

    Maps$2(Set set) {
        this.val$set = set;
    }

    @Override
    protected Set delegate() {
        return this.val$set;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }
}

