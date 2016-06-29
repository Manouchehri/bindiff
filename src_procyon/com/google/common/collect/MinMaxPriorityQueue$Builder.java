package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@Beta
public final class MinMaxPriorityQueue$Builder
{
    private static final int UNSET_EXPECTED_SIZE = -1;
    private final Comparator comparator;
    private int expectedSize;
    private int maximumSize;
    
    private MinMaxPriorityQueue$Builder(final Comparator comparator) {
        this.expectedSize = -1;
        this.maximumSize = Integer.MAX_VALUE;
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }
    
    public MinMaxPriorityQueue$Builder expectedSize(final int expectedSize) {
        Preconditions.checkArgument(expectedSize >= 0);
        this.expectedSize = expectedSize;
        return this;
    }
    
    public MinMaxPriorityQueue$Builder maximumSize(final int maximumSize) {
        Preconditions.checkArgument(maximumSize > 0);
        this.maximumSize = maximumSize;
        return this;
    }
    
    public MinMaxPriorityQueue create() {
        return this.create(Collections.emptySet());
    }
    
    public MinMaxPriorityQueue create(final Iterable iterable) {
        final MinMaxPriorityQueue minMaxPriorityQueue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable), null);
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            minMaxPriorityQueue.offer(iterator.next());
        }
        return minMaxPriorityQueue;
    }
    
    private Ordering ordering() {
        return Ordering.from(this.comparator);
    }
}
