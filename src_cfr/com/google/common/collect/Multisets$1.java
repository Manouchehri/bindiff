/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$1$1;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$1
extends AbstractMultiset {
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;

    Multisets$1(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (this.val$multiset1.contains(object)) return true;
        if (this.val$multiset2.contains(object)) return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (!this.val$multiset1.isEmpty()) return false;
        if (!this.val$multiset2.isEmpty()) return false;
        return true;
    }

    @Override
    public int count(Object object) {
        return Math.max(this.val$multiset1.count(object), this.val$multiset2.count(object));
    }

    @Override
    Set createElementSet() {
        return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
    }

    @Override
    Iterator entryIterator() {
        Iterator iterator = this.val$multiset1.entrySet().iterator();
        Iterator iterator2 = this.val$multiset2.entrySet().iterator();
        return new Multisets$1$1(this, iterator, iterator2);
    }

    @Override
    int distinctElements() {
        return this.elementSet().size();
    }
}

