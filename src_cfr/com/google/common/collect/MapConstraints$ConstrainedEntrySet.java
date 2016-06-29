/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedEntrySet
extends MapConstraints$ConstrainedEntries
implements Set {
    MapConstraints$ConstrainedEntrySet(Set set, MapConstraint mapConstraint) {
        super(set, mapConstraint);
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

