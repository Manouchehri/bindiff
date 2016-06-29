/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
@GoogleInternal
public final class TopKSelector {
    private final int k;
    private final Comparator comparator;
    private final Object[] buffer;
    private int bufferSize;
    private Object threshold;

    public static TopKSelector least(int n2) {
        return TopKSelector.least(n2, Ordering.natural());
    }

    public static TopKSelector greatest(int n2) {
        return TopKSelector.greatest(n2, Ordering.natural());
    }

    public static TopKSelector least(int n2, Comparator comparator) {
        return new TopKSelector(comparator, n2);
    }

    public static TopKSelector greatest(int n2, Comparator comparator) {
        return new TopKSelector(Ordering.from(comparator).reverse(), n2);
    }

    private TopKSelector(Comparator comparator, int n2) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator, "comparator");
        this.k = n2;
        Preconditions.checkArgument(n2 >= 0, "k must be nonnegative, was %s", n2);
        this.buffer = new Object[n2 * 2];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public void offer(@Nullable Object object) {
        if (this.k == 0) {
            return;
        }
        if (this.bufferSize == 0) {
            this.buffer[0] = object;
            this.threshold = object;
            this.bufferSize = 1;
            return;
        }
        if (this.bufferSize < this.k) {
            this.buffer[this.bufferSize++] = object;
            if (this.comparator.compare(object, this.threshold) <= 0) return;
            this.threshold = object;
            return;
        }
        if (this.comparator.compare(object, this.threshold) >= 0) return;
        this.buffer[this.bufferSize++] = object;
        if (this.bufferSize != 2 * this.k) return;
        this.trim();
    }

    private void trim() {
        int n2;
        int n3 = 0;
        int n4 = 2 * this.k - 1;
        int n5 = 0;
        while (n3 < n4) {
            n2 = n3 + n4 + 1 >>> 1;
            int n6 = this.partition(n3, n4, n2);
            if (n6 > this.k) {
                n4 = n6 - 1;
                continue;
            }
            if (n6 >= this.k) break;
            n3 = Math.max(n6, n3 + 1);
            n5 = n6;
        }
        this.bufferSize = this.k;
        this.threshold = this.buffer[n5];
        n2 = n5 + 1;
        while (n2 < this.k) {
            if (this.comparator.compare(this.buffer[n2], this.threshold) > 0) {
                this.threshold = this.buffer[n2];
            }
            ++n2;
        }
    }

    private int partition(int n2, int n3, int n4) {
        Object object = this.buffer[n4];
        this.buffer[n4] = this.buffer[n3];
        int n5 = n2;
        int n6 = n2;
        do {
            if (n6 >= n3) {
                this.buffer[n3] = this.buffer[n5];
                this.buffer[n5] = object;
                return n5;
            }
            if (this.comparator.compare(this.buffer[n6], object) < 0) {
                this.swap(n5, n6);
                ++n5;
            }
            ++n6;
        } while (true);
    }

    private void swap(int n2, int n3) {
        Object object = this.buffer[n2];
        this.buffer[n2] = this.buffer[n3];
        this.buffer[n3] = object;
    }

    public void offerAll(Iterable iterable) {
        this.offerAll(iterable.iterator());
    }

    public void offerAll(Iterator iterator) {
        while (iterator.hasNext()) {
            this.offer(iterator.next());
        }
    }

    public List topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        if (this.bufferSize <= this.k) return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
        Arrays.fill(this.buffer, this.k, this.buffer.length, null);
        this.bufferSize = this.k;
        this.threshold = this.buffer[this.k - 1];
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }
}

