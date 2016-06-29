/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.CartesianList;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$CartesianSet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$CartesianSet
extends ForwardingCollection
implements Set {
    private final transient ImmutableList axes;
    private final transient CartesianList delegate;

    static Set create(List list) {
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(list.size());
        Object object = list.iterator();
        do {
            if (!object.hasNext()) {
                object = immutableList$Builder.build();
                Sets$CartesianSet$1 sets$CartesianSet$1 = new Sets$CartesianSet$1((ImmutableList)object);
                return new Sets$CartesianSet((ImmutableList)object, new CartesianList(sets$CartesianSet$1));
            }
            Set set = (Set)object.next();
            ImmutableSet immutableSet = ImmutableSet.copyOf(set);
            if (immutableSet.isEmpty()) {
                return ImmutableSet.of();
            }
            immutableList$Builder.add((Object)immutableSet);
        } while (true);
    }

    private Sets$CartesianSet(ImmutableList immutableList, CartesianList cartesianList) {
        this.axes = immutableList;
        this.delegate = cartesianList;
    }

    @Override
    protected Collection delegate() {
        return this.delegate;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Sets$CartesianSet)) return super.equals(object);
        Sets$CartesianSet sets$CartesianSet = (Sets$CartesianSet)object;
        return this.axes.equals(sets$CartesianSet.axes);
    }

    @Override
    public int hashCode() {
        int n2;
        int n3 = this.size() - 1;
        for (n2 = 0; n2 < this.axes.size(); n3 *= 31, ++n2) {
            n3 = ~ (~ n3);
        }
        n2 = 1;
        UnmodifiableIterator unmodifiableIterator = this.axes.iterator();
        while (unmodifiableIterator.hasNext()) {
            Set set = (Set)unmodifiableIterator.next();
            n2 = 31 * n2 + this.size() / set.size() * set.hashCode();
            n2 = ~ (~ n2);
        }
        return ~ (~ (n2 += n3));
    }
}

