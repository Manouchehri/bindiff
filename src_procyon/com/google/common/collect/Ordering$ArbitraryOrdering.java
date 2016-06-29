package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;

@VisibleForTesting
class Ordering$ArbitraryOrdering extends Ordering
{
    private Map uids;
    
    Ordering$ArbitraryOrdering() {
        this.uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Ordering$ArbitraryOrdering$1(this));
    }
    
    @Override
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        if (o == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        final int identityHashCode = this.identityHashCode(o);
        final int identityHashCode2 = this.identityHashCode(o2);
        if (identityHashCode != identityHashCode2) {
            return (identityHashCode < identityHashCode2) ? -1 : 1;
        }
        final int compareTo = this.uids.get(o).compareTo(this.uids.get(o2));
        if (compareTo == 0) {
            throw new AssertionError();
        }
        return compareTo;
    }
    
    @Override
    public String toString() {
        return "Ordering.arbitrary()";
    }
    
    int identityHashCode(final Object o) {
        return System.identityHashCode(o);
    }
}
