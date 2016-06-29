package com.google.common.collect;

import com.google.common.primitives.*;

final class Multisets$5 extends Ordering
{
    public int compare(final Multiset$Entry multiset$Entry, final Multiset$Entry multiset$Entry2) {
        return Ints.compare(multiset$Entry2.getCount(), multiset$Entry.getCount());
    }
}
