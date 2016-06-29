/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class Multimaps$UnmodifiableSetMultimap
extends Multimaps$UnmodifiableMultimap
implements SetMultimap {
    private static final long serialVersionUID = 0;

    Multimaps$UnmodifiableSetMultimap(SetMultimap setMultimap) {
        super(setMultimap);
    }

    @Override
    public SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }

    @Override
    public Set get(Object object) {
        return Collections.unmodifiableSet(this.delegate().get(object));
    }

    @Override
    public Set entries() {
        return Maps.unmodifiableEntrySet(this.delegate().entries());
    }

    @Override
    public Set removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }
}

