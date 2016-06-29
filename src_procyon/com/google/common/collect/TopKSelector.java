package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
@GoogleInternal
public final class TopKSelector
{
    private final int k;
    private final Comparator comparator;
    private final Object[] buffer;
    private int bufferSize;
    private Object threshold;
    
    public static TopKSelector least(final int n) {
        return least(n, Ordering.natural());
    }
    
    public static TopKSelector greatest(final int n) {
        return greatest(n, Ordering.natural());
    }
    
    public static TopKSelector least(final int n, final Comparator comparator) {
        return new TopKSelector(comparator, n);
    }
    
    public static TopKSelector greatest(final int n, final Comparator comparator) {
        return new TopKSelector(Ordering.from(comparator).reverse(), n);
    }
    
    private TopKSelector(final Comparator comparator, final int k) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator, (Object)"comparator");
        this.k = k;
        Preconditions.checkArgument(k >= 0, "k must be nonnegative, was %s", k);
        this.buffer = new Object[k * 2];
        this.bufferSize = 0;
        this.threshold = null;
    }
    
    public void offer(@Nullable final Object o) {
        if (this.k == 0) {
            return;
        }
        if (this.bufferSize == 0) {
            this.buffer[0] = o;
            this.threshold = o;
            this.bufferSize = 1;
        }
        else if (this.bufferSize < this.k) {
            this.buffer[this.bufferSize++] = o;
            if (this.comparator.compare(o, this.threshold) > 0) {
                this.threshold = o;
            }
        }
        else if (this.comparator.compare(o, this.threshold) < 0) {
            this.buffer[this.bufferSize++] = o;
            if (this.bufferSize == 2 * this.k) {
                this.trim();
            }
        }
    }
    
    private void trim() {
        int i = 0;
        int n = 2 * this.k - 1;
        int n2 = 0;
        while (i < n) {
            final int partition = this.partition(i, n, i + n + 1 >>> 1);
            if (partition > this.k) {
                n = partition - 1;
            }
            else {
                if (partition >= this.k) {
                    break;
                }
                i = Math.max(partition, i + 1);
                n2 = partition;
            }
        }
        this.bufferSize = this.k;
        this.threshold = this.buffer[n2];
        for (int j = n2 + 1; j < this.k; ++j) {
            if (this.comparator.compare(this.buffer[j], this.threshold) > 0) {
                this.threshold = this.buffer[j];
            }
        }
    }
    
    private int partition(final int n, final int n2, final int n3) {
        final Object o = this.buffer[n3];
        this.buffer[n3] = this.buffer[n2];
        int n4 = n;
        for (int i = n; i < n2; ++i) {
            if (this.comparator.compare(this.buffer[i], o) < 0) {
                this.swap(n4, i);
                ++n4;
            }
        }
        this.buffer[n2] = this.buffer[n4];
        this.buffer[n4] = o;
        return n4;
    }
    
    private void swap(final int n, final int n2) {
        final Object o = this.buffer[n];
        this.buffer[n] = this.buffer[n2];
        this.buffer[n2] = o;
    }
    
    public void offerAll(final Iterable iterable) {
        this.offerAll(iterable.iterator());
    }
    
    public void offerAll(final Iterator iterator) {
        while (iterator.hasNext()) {
            this.offer(iterator.next());
        }
    }
    
    public List topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        if (this.bufferSize > this.k) {
            Arrays.fill(this.buffer, this.k, this.buffer.length, null);
            this.bufferSize = this.k;
            this.threshold = this.buffer[this.k - 1];
        }
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])Arrays.copyOf(this.buffer, this.bufferSize)));
    }
}
