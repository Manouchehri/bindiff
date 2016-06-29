/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSetMultimap
extends ForwardingMultimap
implements SetMultimap {
    @Override
    protected abstract SetMultimap delegate();

    @Override
    public Set entries() {
        return this.delegate().entries();
    }

    @Override
    public Set get(@Nullable Object object) {
        return this.delegate().get(object);
    }

    @Override
    public Set removeAll(@Nullable Object object) {
        return this.delegate().removeAll(object);
    }

    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }
}

