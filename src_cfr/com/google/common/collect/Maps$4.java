/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

final class Maps$4
extends ForwardingNavigableSet {
    final /* synthetic */ NavigableSet val$set;

    Maps$4(NavigableSet navigableSet) {
        this.val$set = navigableSet;
    }

    @Override
    protected NavigableSet delegate() {
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

    @Override
    public NavigableSet headSet(Object object, boolean bl2) {
        return Maps.access$400(super.headSet(object, bl2));
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl2) {
        return Maps.access$400(super.tailSet(object, bl2));
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.access$400(super.subSet(object, bl2, object2, bl3));
    }

    @Override
    public NavigableSet descendingSet() {
        return Maps.access$400(super.descendingSet());
    }
}

