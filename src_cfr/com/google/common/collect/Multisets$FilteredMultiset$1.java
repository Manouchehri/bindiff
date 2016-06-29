/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$FilteredMultiset;

class Multisets$FilteredMultiset$1
implements Predicate {
    final /* synthetic */ Multisets$FilteredMultiset this$0;

    Multisets$FilteredMultiset$1(Multisets$FilteredMultiset filteredMultiset) {
        this.this$0 = filteredMultiset;
    }

    public boolean apply(Multiset$Entry multiset$Entry) {
        return this.this$0.predicate.apply(multiset$Entry.getElement());
    }
}

