/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractMapBasedMultimap$AsMap$AsMapEntries
extends Maps$EntrySet {
    final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;

    AbstractMapBasedMultimap$AsMap$AsMapEntries(AbstractMapBasedMultimap$AsMap asMap) {
        this.this$1 = asMap;
    }

    @Override
    Map map() {
        return this.this$1;
    }

    @Override
    public Iterator iterator() {
        return new AbstractMapBasedMultimap$AsMap$AsMapIterator(this.this$1);
    }

    @Override
    public boolean contains(Object object) {
        return Collections2.safeContains(this.this$1.submap.entrySet(), object);
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        AbstractMapBasedMultimap.access$400(this.this$1.this$0, entry.getKey());
        return true;
    }
}

