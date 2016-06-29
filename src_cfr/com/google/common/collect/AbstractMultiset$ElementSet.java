/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet;

class AbstractMultiset$ElementSet
extends Multisets$ElementSet {
    final /* synthetic */ AbstractMultiset this$0;

    AbstractMultiset$ElementSet(AbstractMultiset abstractMultiset) {
        this.this$0 = abstractMultiset;
    }

    @Override
    Multiset multiset() {
        return this.this$0;
    }
}

