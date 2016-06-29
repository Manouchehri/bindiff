/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Multimaps$AsMap$EntrySet
extends Maps$EntrySet {
    final /* synthetic */ Multimaps$AsMap this$0;

    Multimaps$AsMap$EntrySet(Multimaps$AsMap multimaps$AsMap) {
        this.this$0 = multimaps$AsMap;
    }

    @Override
    Map map() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(Multimaps$AsMap.access$200(this.this$0).keySet(), new Multimaps$AsMap$EntrySet$1(this));
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        this.this$0.removeValuesForKey(entry.getKey());
        return true;
    }
}

