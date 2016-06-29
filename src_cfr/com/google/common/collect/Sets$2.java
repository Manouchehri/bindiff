/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$SetView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class Sets$2
extends Sets$SetView {
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Predicate val$inSet2;
    final /* synthetic */ Set val$set2;

    Sets$2(Set set, Predicate predicate, Set set2) {
        this.val$set1 = set;
        this.val$inSet2 = predicate;
        this.val$set2 = set2;
        super(null);
    }

    @Override
    public Iterator iterator() {
        return Iterators.filter(this.val$set1.iterator(), this.val$inSet2);
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }

    @Override
    public boolean isEmpty() {
        if (this.iterator().hasNext()) return false;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        if (!this.val$set1.contains(object)) return false;
        if (!this.val$set2.contains(object)) return false;
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (!this.val$set1.containsAll(collection)) return false;
        if (!this.val$set2.containsAll(collection)) return false;
        return true;
    }
}

