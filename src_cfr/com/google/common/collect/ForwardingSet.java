/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSet
extends ForwardingCollection
implements Set {
    protected ForwardingSet() {
    }

    @Override
    protected abstract Set delegate();

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) return true;
        if (this.delegate().equals(object)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.delegate().hashCode();
    }

    @Override
    protected boolean standardRemoveAll(Collection collection) {
        return Sets.removeAllImpl((Set)this, (Collection)Preconditions.checkNotNull(collection));
    }

    protected boolean standardEquals(@Nullable Object object) {
        return Sets.equalsImpl(this, object);
    }

    protected int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }
}

