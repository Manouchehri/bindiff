/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;

class Maps$UnmodifiableEntries
extends ForwardingCollection {
    private final Collection entries;

    Maps$UnmodifiableEntries(Collection collection) {
        this.entries = collection;
    }

    @Override
    protected Collection delegate() {
        return this.entries;
    }

    @Override
    public Iterator iterator() {
        return Maps.unmodifiableEntryIterator(this.entries.iterator());
    }

    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.standardToArray(arrobject);
    }
}

