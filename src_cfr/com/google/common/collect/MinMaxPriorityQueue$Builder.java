/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@Beta
public final class MinMaxPriorityQueue$Builder {
    private static final int UNSET_EXPECTED_SIZE = -1;
    private final Comparator comparator;
    private int expectedSize = -1;
    private int maximumSize = Integer.MAX_VALUE;

    private MinMaxPriorityQueue$Builder(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    public MinMaxPriorityQueue$Builder expectedSize(int n2) {
        Preconditions.checkArgument(n2 >= 0);
        this.expectedSize = n2;
        return this;
    }

    public MinMaxPriorityQueue$Builder maximumSize(int n2) {
        Preconditions.checkArgument(n2 > 0);
        this.maximumSize = n2;
        return this;
    }

    public MinMaxPriorityQueue create() {
        return this.create(Collections.emptySet());
    }

    public MinMaxPriorityQueue create(Iterable iterable) {
        MinMaxPriorityQueue minMaxPriorityQueue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable), null);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            minMaxPriorityQueue.offer(t2);
        }
        return minMaxPriorityQueue;
    }

    private Ordering ordering() {
        return Ordering.from(this.comparator);
    }

    /* synthetic */ MinMaxPriorityQueue$Builder(Comparator comparator, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(comparator);
    }

    static /* synthetic */ Ordering access$200(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder) {
        return minMaxPriorityQueue$Builder.ordering();
    }

    static /* synthetic */ int access$300(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder) {
        return minMaxPriorityQueue$Builder.maximumSize;
    }
}

