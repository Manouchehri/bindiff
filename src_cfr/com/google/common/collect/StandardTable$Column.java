/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column$EntrySet;
import com.google.common.collect.StandardTable$Column$KeySet;
import com.google.common.collect.StandardTable$Column$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$Column
extends Maps$ViewCachingAbstractMap {
    final Object columnKey;
    final /* synthetic */ StandardTable this$0;

    StandardTable$Column(StandardTable standardTable, Object object) {
        this.this$0 = standardTable;
        this.columnKey = Preconditions.checkNotNull(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        return this.this$0.put(object, this.columnKey, object2);
    }

    @Override
    public Object get(Object object) {
        return this.this$0.get(object, this.columnKey);
    }

    @Override
    public boolean containsKey(Object object) {
        return this.this$0.contains(object, this.columnKey);
    }

    @Override
    public Object remove(Object object) {
        return this.this$0.remove(object, this.columnKey);
    }

    boolean removeFromColumnIf(Predicate predicate) {
        boolean bl2 = false;
        Iterator iterator = this.this$0.backingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Map map = (Map)entry.getValue();
            Object v2 = map.get(this.columnKey);
            if (v2 == null || !predicate.apply(Maps.immutableEntry(entry.getKey(), v2))) continue;
            map.remove(this.columnKey);
            bl2 = true;
            if (!map.isEmpty()) continue;
            iterator.remove();
        }
        return bl2;
    }

    @Override
    Set createEntrySet() {
        return new StandardTable$Column$EntrySet(this, null);
    }

    @Override
    Set createKeySet() {
        return new StandardTable$Column$KeySet(this);
    }

    @Override
    Collection createValues() {
        return new StandardTable$Column$Values(this);
    }
}

