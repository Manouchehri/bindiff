/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Keys$1;
import com.google.common.collect.Multimaps$Keys$KeysEntrySet;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Multimaps$Keys
extends AbstractMultiset {
    @Weak
    final Multimap multimap;

    Multimaps$Keys(Multimap multimap) {
        this.multimap = multimap;
    }

    @Override
    Iterator entryIterator() {
        return new Multimaps$Keys$1(this, this.multimap.asMap().entrySet().iterator());
    }

    @Override
    int distinctElements() {
        return this.multimap.asMap().size();
    }

    @Override
    Set createEntrySet() {
        return new Multimaps$Keys$KeysEntrySet(this);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.multimap.containsKey(object);
    }

    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.multimap.entries().iterator());
    }

    @Override
    public int count(@Nullable Object object) {
        Collection collection = (Collection)Maps.safeGet(this.multimap.asMap(), object);
        if (collection == null) {
            return 0;
        }
        int n2 = collection.size();
        return n2;
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        CollectPreconditions.checkNonnegative(n2, "occurrences");
        if (n2 == 0) {
            return this.count(object);
        }
        Collection collection = (Collection)Maps.safeGet(this.multimap.asMap(), object);
        if (collection == null) {
            return 0;
        }
        int n3 = collection.size();
        if (n2 >= n3) {
            collection.clear();
            return n3;
        }
        Iterator iterator = collection.iterator();
        int n4 = 0;
        while (n4 < n2) {
            iterator.next();
            iterator.remove();
            ++n4;
        }
        return n3;
    }

    @Override
    public void clear() {
        this.multimap.clear();
    }

    @Override
    public Set elementSet() {
        return this.multimap.keySet();
    }
}

