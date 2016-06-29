/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import javax.annotation.Nullable;

abstract class Multisets$EntrySet
extends Sets$ImprovedAbstractSet {
    Multisets$EntrySet() {
    }

    abstract Multiset multiset();

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        if (multiset$Entry.getCount() <= 0) {
            return false;
        }
        int n2 = this.multiset().count(multiset$Entry.getElement());
        if (n2 != multiset$Entry.getCount()) return false;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        Object object2 = multiset$Entry.getElement();
        int n2 = multiset$Entry.getCount();
        if (n2 == 0) return false;
        Multiset multiset = this.multiset();
        return multiset.setCount(object2, n2, 0);
    }

    @Override
    public void clear() {
        this.multiset().clear();
    }
}

