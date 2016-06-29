/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import java.util.Collection;
import java.util.List;

final class Multimaps$TransformedEntriesListMultimap
extends Multimaps$TransformedEntriesMultimap
implements ListMultimap {
    Multimaps$TransformedEntriesListMultimap(ListMultimap listMultimap, Maps$EntryTransformer maps$EntryTransformer) {
        super(listMultimap, maps$EntryTransformer);
    }

    @Override
    List transform(Object object, Collection collection) {
        return Lists.transform((List)collection, Maps.asValueToValueFunction(this.transformer, object));
    }

    @Override
    public List get(Object object) {
        return this.transform(object, this.fromMultimap.get(object));
    }

    @Override
    public List removeAll(Object object) {
        return this.transform(object, this.fromMultimap.removeAll(object));
    }

    @Override
    public List replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}

