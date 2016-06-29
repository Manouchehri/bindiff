/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$ElementSet;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

class Multisets$ElementSet$1
extends TransformedIterator {
    final /* synthetic */ Multisets$ElementSet this$0;

    Multisets$ElementSet$1(Multisets$ElementSet multisets$ElementSet, Iterator iterator) {
        this.this$0 = multisets$ElementSet;
        super(iterator);
    }

    Object transform(Multiset$Entry multiset$Entry) {
        return multiset$Entry.getElement();
    }
}

