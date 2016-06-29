/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$1;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

public abstract class Sets$SetView
extends AbstractSet {
    private Sets$SetView() {
    }

    public ImmutableSet immutableCopy() {
        return ImmutableSet.copyOf(this);
    }

    public Set copyInto(Set set) {
        set.addAll(this);
        return set;
    }

    /* synthetic */ Sets$SetView(Sets$1 sets$1) {
        this();
    }
}

