/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSetMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSetMultimap
extends Synchronized$SynchronizedSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedSortedSetMultimap(SortedSetMultimap sortedSetMultimap, @Nullable Object object) {
        super(sortedSetMultimap, object);
    }

    @Override
    SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$100(this.delegate().get(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeAll(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SortedSet replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().replaceValues(object, iterable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Comparator valueComparator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().valueComparator();
        }
    }
}

