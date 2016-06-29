/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$FilteredSet
extends Collections2$FilteredCollection
implements Set {
    Sets$FilteredSet(Set set, Predicate predicate) {
        super(set, predicate);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Sets.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

