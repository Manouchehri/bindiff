/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets$PowerSet$1;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$PowerSet
extends AbstractSet {
    final ImmutableMap inputSet;

    Sets$PowerSet(Set set) {
        this.inputSet = Maps.indexMap(set);
        Preconditions.checkArgument(this.inputSet.size() <= 30, "Too many elements to create power set: %s > 30", this.inputSet.size());
    }

    @Override
    public int size() {
        return 1 << this.inputSet.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Sets$PowerSet$1(this, this.size());
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Set)) return false;
        Set set = (Set)object;
        return this.inputSet.keySet().containsAll(set);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Sets$PowerSet)) return super.equals(object);
        Sets$PowerSet sets$PowerSet = (Sets$PowerSet)object;
        return this.inputSet.equals(sets$PowerSet.inputSet);
    }

    @Override
    public int hashCode() {
        return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.inputSet);
        return new StringBuilder(10 + String.valueOf(string).length()).append("powerSet(").append(string).append(")").toString();
    }
}

