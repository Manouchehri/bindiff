/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingListMultimap
extends ForwardingMultimap
implements ListMultimap {
    protected ForwardingListMultimap() {
    }

    @Override
    protected abstract ListMultimap delegate();

    @Override
    public List get(@Nullable Object object) {
        return this.delegate().get(object);
    }

    @Override
    public List removeAll(@Nullable Object object) {
        return this.delegate().removeAll(object);
    }

    @Override
    public List replaceValues(Object object, Iterable iterable) {
        return this.delegate().replaceValues(object, iterable);
    }
}

