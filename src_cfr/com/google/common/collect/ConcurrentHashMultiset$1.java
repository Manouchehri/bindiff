/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class ConcurrentHashMultiset$1
extends ForwardingSet {
    final /* synthetic */ Set val$delegate;
    final /* synthetic */ ConcurrentHashMultiset this$0;

    ConcurrentHashMultiset$1(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
        this.this$0 = concurrentHashMultiset;
        this.val$delegate = set;
    }

    @Override
    protected Set delegate() {
        return this.val$delegate;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (object == null) return false;
        if (!Collections2.safeContains(this.val$delegate, object)) return false;
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) return false;
        if (!Collections2.safeRemove(this.val$delegate, object)) return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }
}

