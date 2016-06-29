/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class SmallSortedMap$EntrySet
extends AbstractSet {
    final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$EntrySet(SmallSortedMap smallSortedMap) {
        this.this$0 = smallSortedMap;
    }

    @Override
    public Iterator iterator() {
        return new SmallSortedMap$EntryIterator(this.this$0, null);
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(Object object) {
        Object v2;
        Map.Entry entry = (Map.Entry)object;
        Object object2 = this.this$0.get(entry.getKey());
        if (object2 == (v2 = entry.getValue())) return true;
        if (object2 == null) return false;
        if (!object2.equals(v2)) return false;
        return true;
    }

    @Override
    public boolean add(Map.Entry entry) {
        if (this.contains(entry)) return false;
        this.this$0.put((Comparable)entry.getKey(), entry.getValue());
        return true;
    }

    @Override
    public boolean remove(Object object) {
        Map.Entry entry = (Map.Entry)object;
        if (!this.contains(entry)) return false;
        this.this$0.remove(entry.getKey());
        return true;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    /* synthetic */ SmallSortedMap$EntrySet(SmallSortedMap smallSortedMap, SmallSortedMap$1 smallSortedMap$1) {
        this(smallSortedMap);
    }
}

