/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Iterators$MergingIterator$1;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class Iterators$MergingIterator
extends UnmodifiableIterator {
    final Queue queue;

    public Iterators$MergingIterator(Iterable iterable, Comparator comparator) {
        Iterators$MergingIterator$1 iterators$MergingIterator$1 = new Iterators$MergingIterator$1(this, comparator);
        this.queue = new PriorityQueue(2, iterators$MergingIterator$1);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = (Iterator)iterator.next();
            if (!iterator2.hasNext()) continue;
            this.queue.add(Iterators.peekingIterator(iterator2));
        }
    }

    @Override
    public boolean hasNext() {
        if (this.queue.isEmpty()) return false;
        return true;
    }

    public Object next() {
        PeekingIterator peekingIterator = (PeekingIterator)this.queue.remove();
        Object object = peekingIterator.next();
        if (!peekingIterator.hasNext()) return object;
        this.queue.add(peekingIterator);
        return object;
    }
}

