/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Maps$UnmodifiableEntries;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableEntrySet
extends Maps$UnmodifiableEntries
implements Set {
    Maps$UnmodifiableEntrySet(Set set) {
        super(set);
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

