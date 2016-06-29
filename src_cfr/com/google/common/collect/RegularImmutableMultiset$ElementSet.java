/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.RegularImmutableMultiset$1;
import javax.annotation.Nullable;

final class RegularImmutableMultiset$ElementSet
extends ImmutableSet$Indexed {
    final /* synthetic */ RegularImmutableMultiset this$0;

    private RegularImmutableMultiset$ElementSet(RegularImmutableMultiset regularImmutableMultiset) {
        this.this$0 = regularImmutableMultiset;
    }

    @Override
    Object get(int n2) {
        return RegularImmutableMultiset.access$100(this.this$0)[n2].getElement();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.this$0.contains(object);
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @Override
    public int size() {
        return RegularImmutableMultiset.access$100(this.this$0).length;
    }

    /* synthetic */ RegularImmutableMultiset$ElementSet(RegularImmutableMultiset regularImmutableMultiset, RegularImmutableMultiset$1 regularImmutableMultiset$1) {
        this(regularImmutableMultiset);
    }
}

