/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$BuilderMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableMultimap$Builder {
    Multimap builderMultimap = new ImmutableMultimap$BuilderMultimap();
    Comparator keyComparator;
    Comparator valueComparator;

    public ImmutableMultimap$Builder put(Object object, Object object2) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        this.builderMultimap.put(object, object2);
        return this;
    }

    public ImmutableMultimap$Builder put(Map.Entry entry) {
        return this.put(entry.getKey(), entry.getValue());
    }

    @Beta
    public ImmutableMultimap$Builder putAll(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.put(entry);
        }
        return this;
    }

    public ImmutableMultimap$Builder putAll(Object object, Iterable iterable) {
        if (object == null) {
            String string;
            String string2 = String.valueOf(Iterables.toString(iterable));
            if (string2.length() != 0) {
                string = "null key in entry: null=".concat(string2);
                throw new NullPointerException(string);
            }
            string = new String("null key in entry: null=");
            throw new NullPointerException(string);
        }
        Collection collection = this.builderMultimap.get(object);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            CollectPreconditions.checkEntryNotNull(object, t2);
            collection.add(t2);
        }
        return this;
    }

    public /* varargs */ ImmutableMultimap$Builder putAll(Object object, Object ... arrobject) {
        return this.putAll(object, Arrays.asList(arrobject));
    }

    public ImmutableMultimap$Builder putAll(Multimap multimap) {
        Iterator iterator = multimap.asMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.putAll(entry.getKey(), (Iterable)entry.getValue());
        }
        return this;
    }

    public ImmutableMultimap$Builder orderKeysBy(Comparator comparator) {
        this.keyComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }

    public ImmutableMultimap$Builder orderValuesBy(Comparator comparator) {
        this.valueComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }

    public ImmutableMultimap build() {
        Object object;
        Collection collection2;
        if (this.valueComparator != null) {
            for (Collection collection2 : this.builderMultimap.asMap().values()) {
                object = (List)collection2;
                Collections.sort(object, this.valueComparator);
            }
        }
        if (this.keyComparator == null) return ImmutableMultimap.copyOf(this.builderMultimap);
        ImmutableMultimap$BuilderMultimap immutableMultimap$BuilderMultimap = new ImmutableMultimap$BuilderMultimap();
        collection2 = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet());
        object = collection2.iterator();
        do {
            if (!object.hasNext()) {
                this.builderMultimap = immutableMultimap$BuilderMultimap;
                return ImmutableMultimap.copyOf(this.builderMultimap);
            }
            Map.Entry entry = (Map.Entry)object.next();
            immutableMultimap$BuilderMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
        } while (true);
    }
}

