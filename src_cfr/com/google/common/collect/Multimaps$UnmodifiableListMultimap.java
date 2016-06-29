/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Multimaps$UnmodifiableListMultimap
extends Multimaps$UnmodifiableMultimap
implements ListMultimap {
    private static final long serialVersionUID = 0;

    Multimaps$UnmodifiableListMultimap(ListMultimap listMultimap) {
        super(listMultimap);
    }

    @Override
    public ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }

    @Override
    public List get(Object object) {
        return Collections.unmodifiableList(this.delegate().get(object));
    }

    @Override
    public List removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}

