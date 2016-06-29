/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$Builder;
import com.google.common.collect.MinMaxPriorityQueue$Heap;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.MinMaxPriorityQueue$QueueIterator;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

@Beta
public final class MinMaxPriorityQueue
extends AbstractQueue {
    private final MinMaxPriorityQueue$Heap minHeap;
    private final MinMaxPriorityQueue$Heap maxHeap;
    @VisibleForTesting
    final int maximumSize;
    private Object[] queue;
    private int size;
    private int modCount;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private static final int DEFAULT_CAPACITY = 11;

    public static MinMaxPriorityQueue create() {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).create();
    }

    public static MinMaxPriorityQueue create(Iterable iterable) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).create(iterable);
    }

    public static MinMaxPriorityQueue$Builder orderedBy(Comparator comparator) {
        return new MinMaxPriorityQueue$Builder(comparator, null);
    }

    public static MinMaxPriorityQueue$Builder expectedSize(int n2) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).expectedSize(n2);
    }

    public static MinMaxPriorityQueue$Builder maximumSize(int n2) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).maximumSize(n2);
    }

    private MinMaxPriorityQueue(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder, int n2) {
        Ordering ordering = MinMaxPriorityQueue$Builder.access$200(minMaxPriorityQueue$Builder);
        this.minHeap = new MinMaxPriorityQueue$Heap(this, ordering);
        this.minHeap.otherHeap = this.maxHeap = new MinMaxPriorityQueue$Heap(this, ordering.reverse());
        this.maxHeap.otherHeap = this.minHeap;
        this.maximumSize = MinMaxPriorityQueue$Builder.access$300(minMaxPriorityQueue$Builder);
        this.queue = new Object[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(Object object) {
        this.offer(object);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean bl2 = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            this.offer(e2);
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public boolean offer(Object object) {
        Preconditions.checkNotNull(object);
        ++this.modCount;
        int n2 = this.size++;
        this.growIfNeeded();
        this.heapForIndex(n2).bubbleUp(n2, object);
        if (this.size <= this.maximumSize) return true;
        if (this.pollLast() != object) return true;
        return false;
    }

    @Override
    public Object poll() {
        if (this.isEmpty()) {
            return null;
        }
        Object object = this.removeAndGet(0);
        return object;
    }

    Object elementData(int n2) {
        return this.queue[n2];
    }

    @Override
    public Object peek() {
        if (this.isEmpty()) {
            return null;
        }
        Object object = this.elementData(0);
        return object;
    }

    private int getMaxElementIndex() {
        switch (this.size) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
        }
        if (this.maxHeap.compareElements(1, 2) > 0) return 2;
        return 1;
    }

    public Object pollFirst() {
        return this.poll();
    }

    public Object removeFirst() {
        return this.remove();
    }

    public Object peekFirst() {
        return this.peek();
    }

    public Object pollLast() {
        if (this.isEmpty()) {
            return null;
        }
        Object object = this.removeAndGet(this.getMaxElementIndex());
        return object;
    }

    public Object removeLast() {
        if (!this.isEmpty()) return this.removeAndGet(this.getMaxElementIndex());
        throw new NoSuchElementException();
    }

    public Object peekLast() {
        if (this.isEmpty()) {
            return null;
        }
        Object object = this.elementData(this.getMaxElementIndex());
        return object;
    }

    @VisibleForTesting
    MinMaxPriorityQueue$MoveDesc removeAt(int n2) {
        Preconditions.checkPositionIndex(n2, this.size);
        ++this.modCount;
        --this.size;
        if (this.size == n2) {
            this.queue[this.size] = null;
            return null;
        }
        Object object = this.elementData(this.size);
        int n3 = this.heapForIndex(this.size).getCorrectLastElement(object);
        Object object2 = this.elementData(this.size);
        this.queue[this.size] = null;
        MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = this.fillHole(n2, object2);
        if (n3 >= n2) return minMaxPriorityQueue$MoveDesc;
        if (minMaxPriorityQueue$MoveDesc != null) return new MinMaxPriorityQueue$MoveDesc(object, minMaxPriorityQueue$MoveDesc.replaced);
        return new MinMaxPriorityQueue$MoveDesc(object, object2);
    }

    private MinMaxPriorityQueue$MoveDesc fillHole(int n2, Object object) {
        int n3;
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap = this.heapForIndex(n2);
        int n4 = minMaxPriorityQueue$Heap.bubbleUpAlternatingLevels(n3 = minMaxPriorityQueue$Heap.fillHoleAt(n2), object);
        if (n4 == n3) {
            return minMaxPriorityQueue$Heap.tryCrossOverAndBubbleUp(n2, n3, object);
        }
        if (n4 >= n2) return null;
        MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = new MinMaxPriorityQueue$MoveDesc(object, this.elementData(n2));
        return minMaxPriorityQueue$MoveDesc;
    }

    private Object removeAndGet(int n2) {
        Object object = this.elementData(n2);
        this.removeAt(n2);
        return object;
    }

    private MinMaxPriorityQueue$Heap heapForIndex(int n2) {
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap;
        if (MinMaxPriorityQueue.isEvenLevel(n2)) {
            minMaxPriorityQueue$Heap = this.minHeap;
            return minMaxPriorityQueue$Heap;
        }
        minMaxPriorityQueue$Heap = this.maxHeap;
        return minMaxPriorityQueue$Heap;
    }

    @VisibleForTesting
    static boolean isEvenLevel(int n2) {
        int n3 = n2 + 1;
        Preconditions.checkState(n3 > 0, "negative index");
        if ((n3 & 1431655765) <= (n3 & -1431655766)) return false;
        return true;
    }

    @VisibleForTesting
    boolean isIntact() {
        int n2 = 1;
        while (n2 < this.size) {
            if (!MinMaxPriorityQueue$Heap.access$400(this.heapForIndex(n2), n2)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return new MinMaxPriorityQueue$QueueIterator(this, null);
    }

    @Override
    public void clear() {
        int n2 = 0;
        do {
            if (n2 >= this.size) {
                this.size = 0;
                return;
            }
            this.queue[n2] = null;
            ++n2;
        } while (true);
    }

    @Override
    public Object[] toArray() {
        Object[] arrobject = new Object[this.size];
        System.arraycopy(this.queue, 0, arrobject, 0, this.size);
        return arrobject;
    }

    public Comparator comparator() {
        return this.minHeap.ordering;
    }

    @VisibleForTesting
    int capacity() {
        return this.queue.length;
    }

    @VisibleForTesting
    static int initialQueueSize(int n2, int n3, Iterable iterable) {
        int n4 = n2 == -1 ? 11 : n2;
        if (!(iterable instanceof Collection)) return MinMaxPriorityQueue.capAtMaximumSize(n4, n3);
        int n5 = ((Collection)iterable).size();
        n4 = Math.max(n4, n5);
        return MinMaxPriorityQueue.capAtMaximumSize(n4, n3);
    }

    private void growIfNeeded() {
        if (this.size <= this.queue.length) return;
        int n2 = this.calculateNewCapacity();
        Object[] arrobject = new Object[n2];
        System.arraycopy(this.queue, 0, arrobject, 0, this.queue.length);
        this.queue = arrobject;
    }

    private int calculateNewCapacity() {
        int n2 = this.queue.length;
        int n3 = n2 < 64 ? (n2 + 1) * 2 : IntMath.checkedMultiply(n2 / 2, 3);
        return MinMaxPriorityQueue.capAtMaximumSize(n3, this.maximumSize);
    }

    private static int capAtMaximumSize(int n2, int n3) {
        return Math.min(n2 - 1, n3) + 1;
    }

    /* synthetic */ MinMaxPriorityQueue(MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder, int n2, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(minMaxPriorityQueue$Builder, n2);
    }

    static /* synthetic */ Object[] access$500(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.queue;
    }

    static /* synthetic */ int access$600(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.size;
    }

    static /* synthetic */ int access$700(MinMaxPriorityQueue minMaxPriorityQueue) {
        return minMaxPriorityQueue.modCount;
    }
}

