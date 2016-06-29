/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeSet;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

final class TreeRangeSet$AsRanges
extends ForwardingCollection
implements Set {
    final Collection delegate;
    final /* synthetic */ TreeRangeSet this$0;

    TreeRangeSet$AsRanges(TreeRangeSet treeRangeSet, Collection collection) {
        this.this$0 = treeRangeSet;
        this.delegate = collection;
    }

    @Override
    protected Collection delegate() {
        return this.delegate;
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Sets.equalsImpl(this, object);
    }
}

