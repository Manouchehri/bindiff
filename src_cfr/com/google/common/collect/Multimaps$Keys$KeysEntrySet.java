/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class Multimaps$Keys$KeysEntrySet
extends Multisets$EntrySet {
    final /* synthetic */ Multimaps$Keys this$0;

    Multimaps$Keys$KeysEntrySet(Multimaps$Keys multimaps$Keys) {
        this.this$0 = multimaps$Keys;
    }

    @Override
    Multiset multiset() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    @Override
    public int size() {
        return this.this$0.distinctElements();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.multimap.isEmpty();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        Collection collection = (Collection)this.this$0.multimap.asMap().get(multiset$Entry.getElement());
        if (collection == null) return false;
        if (collection.size() != multiset$Entry.getCount()) return false;
        return true;
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        Collection collection = (Collection)this.this$0.multimap.asMap().get(multiset$Entry.getElement());
        if (collection == null) return false;
        if (collection.size() != multiset$Entry.getCount()) return false;
        collection.clear();
        return true;
    }
}

