/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.Maps$Values;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
abstract class Maps$ViewCachingAbstractMap
extends AbstractMap {
    private transient Set entrySet;
    private transient Set keySet;
    private transient Collection values;

    Maps$ViewCachingAbstractMap() {
    }

    abstract Set createEntrySet();

    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 == null) {
            set = this.entrySet = this.createEntrySet();
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Set keySet() {
        Set set;
        Set set2 = this.keySet;
        if (set2 == null) {
            set = this.keySet = this.createKeySet();
            return set;
        }
        set = set2;
        return set;
    }

    Set createKeySet() {
        return new Maps$KeySet(this);
    }

    @Override
    public Collection values() {
        Collection collection;
        Collection collection2 = this.values;
        if (collection2 == null) {
            collection = this.values = this.createValues();
            return collection;
        }
        collection = collection2;
        return collection;
    }

    Collection createValues() {
        return new Maps$Values(this);
    }
}

