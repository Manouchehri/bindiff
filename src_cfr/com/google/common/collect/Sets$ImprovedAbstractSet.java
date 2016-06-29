/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

abstract class Sets$ImprovedAbstractSet
extends AbstractSet {
    Sets$ImprovedAbstractSet() {
    }

    @Override
    public boolean removeAll(Collection collection) {
        return Sets.removeAllImpl((Set)this, collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return super.retainAll((Collection)Preconditions.checkNotNull(collection));
    }
}

