/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$ArbitraryOrdering$1;
import com.google.common.collect.Platform;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
class Ordering$ArbitraryOrdering
extends Ordering {
    private Map uids;

    Ordering$ArbitraryOrdering() {
        this.uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Ordering$ArbitraryOrdering$1(this));
    }

    @Override
    public int compare(Object object, Object object2) {
        int n2;
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        int n3 = this.identityHashCode(object);
        if (n3 == (n2 = this.identityHashCode(object2))) {
            int n4 = ((Integer)this.uids.get(object)).compareTo((Integer)this.uids.get(object2));
            if (n4 != 0) return n4;
            throw new AssertionError();
        }
        if (n3 >= n2) return 1;
        return -1;
    }

    public String toString() {
        return "Ordering.arbitrary()";
    }

    int identityHashCode(Object object) {
        return System.identityHashCode(object);
    }
}

