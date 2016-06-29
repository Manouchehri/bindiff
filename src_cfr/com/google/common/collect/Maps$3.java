/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

final class Maps$3
extends ForwardingSortedSet {
    final /* synthetic */ SortedSet val$set;

    Maps$3(SortedSet sortedSet) {
        this.val$set = sortedSet;
    }

    @Override
    protected SortedSet delegate() {
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

    @Override
    public SortedSet headSet(Object object) {
        return Maps.access$300(super.headSet(object));
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return Maps.access$300(super.subSet(object, object2));
    }

    @Override
    public SortedSet tailSet(Object object) {
        return Maps.access$300(super.tailSet(object));
    }
}

