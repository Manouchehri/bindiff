/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multisets$AbstractEntry;
import java.io.Serializable;
import javax.annotation.Nullable;

class Multisets$ImmutableEntry
extends Multisets$AbstractEntry
implements Serializable {
    @Nullable
    private final Object element;
    private final int count;
    private static final long serialVersionUID = 0;

    Multisets$ImmutableEntry(@Nullable Object object, int n2) {
        this.element = object;
        this.count = n2;
        CollectPreconditions.checkNonnegative(n2, "count");
    }

    @Nullable
    @Override
    public final Object getElement() {
        return this.element;
    }

    @Override
    public final int getCount() {
        return this.count;
    }

    public Multisets$ImmutableEntry nextInBucket() {
        return null;
    }
}

