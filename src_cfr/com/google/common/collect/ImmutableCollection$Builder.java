/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;

public abstract class ImmutableCollection$Builder {
    static final int DEFAULT_INITIAL_CAPACITY = 4;

    static int expandedCapacity(int n2, int n3) {
        if (n3 < 0) {
            throw new AssertionError((Object)"cannot store more than MAX_VALUE elements");
        }
        int n4 = n2 + (n2 >> 1) + 1;
        if (n4 < n3) {
            n4 = Integer.highestOneBit(n3 - 1) << 1;
        }
        if (n4 >= 0) return n4;
        return Integer.MAX_VALUE;
    }

    ImmutableCollection$Builder() {
    }

    public abstract ImmutableCollection$Builder add(Object var1);

    public /* varargs */ ImmutableCollection$Builder add(Object ... arrobject) {
        Object[] arrobject2 = arrobject;
        int n2 = arrobject2.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object = arrobject2[n3];
            this.add(object);
            ++n3;
        }
        return this;
    }

    public ImmutableCollection$Builder addAll(Iterable iterable) {
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            T t2 = iterator.next();
            this.add((Object)t2);
        }
        return this;
    }

    public ImmutableCollection$Builder addAll(Iterator iterator) {
        while (iterator.hasNext()) {
            this.add((Object)iterator.next());
        }
        return this;
    }

    public abstract ImmutableCollection build();
}

