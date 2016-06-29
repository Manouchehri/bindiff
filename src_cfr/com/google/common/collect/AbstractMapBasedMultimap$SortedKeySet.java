/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedKeySet
extends AbstractMapBasedMultimap$KeySet
implements SortedSet {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$SortedKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap sortedMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    SortedMap sortedMap() {
        return (SortedMap)super.map();
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public Object first() {
        return this.sortedMap().firstKey();
    }

    public SortedSet headSet(Object object) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().headMap(object));
    }

    public Object last() {
        return this.sortedMap().lastKey();
    }

    public SortedSet subSet(Object object, Object object2) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().subMap(object, object2));
    }

    public SortedSet tailSet(Object object) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().tailMap(object));
    }
}

