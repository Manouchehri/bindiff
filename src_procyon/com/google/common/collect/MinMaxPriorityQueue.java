package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import com.google.common.math.*;
import java.util.*;
import com.google.j2objc.annotations.*;

@Beta
public final class MinMaxPriorityQueue extends AbstractQueue
{
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
    
    public static MinMaxPriorityQueue create(final Iterable iterable) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).create(iterable);
    }
    
    public static MinMaxPriorityQueue$Builder orderedBy(final Comparator comparator) {
        return new MinMaxPriorityQueue$Builder(comparator, null);
    }
    
    public static MinMaxPriorityQueue$Builder expectedSize(final int n) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).expectedSize(n);
    }
    
    public static MinMaxPriorityQueue$Builder maximumSize(final int n) {
        return new MinMaxPriorityQueue$Builder(Ordering.natural(), null).maximumSize(n);
    }
    
    private MinMaxPriorityQueue(final MinMaxPriorityQueue$Builder minMaxPriorityQueue$Builder, final int n) {
        final Ordering access$200 = minMaxPriorityQueue$Builder.ordering();
        this.minHeap = new MinMaxPriorityQueue$Heap(this, access$200);
        this.maxHeap = new MinMaxPriorityQueue$Heap(this, access$200.reverse());
        this.minHeap.otherHeap = this.maxHeap;
        this.maxHeap.otherHeap = this.minHeap;
        this.maximumSize = minMaxPriorityQueue$Builder.maximumSize;
        this.queue = new Object[n];
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean add(final Object o) {
        this.offer(o);
        return true;
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        boolean b = false;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.offer(iterator.next());
            b = true;
        }
        return b;
    }
    
    @Override
    public boolean offer(final Object o) {
        Preconditions.checkNotNull(o);
        ++this.modCount;
        final int n = this.size++;
        this.growIfNeeded();
        this.heapForIndex(n).bubbleUp(n, o);
        return this.size <= this.maximumSize || this.pollLast() != o;
    }
    
    @Override
    public Object poll() {
        return this.isEmpty() ? null : this.removeAndGet(0);
    }
    
    Object elementData(final int n) {
        return this.queue[n];
    }
    
    @Override
    public Object peek() {
        return this.isEmpty() ? null : this.elementData(0);
    }
    
    private int getMaxElementIndex() {
        switch (this.size) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            default: {
                return (this.maxHeap.compareElements(1, 2) <= 0) ? 1 : 2;
            }
        }
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
        return this.isEmpty() ? null : this.removeAndGet(this.getMaxElementIndex());
    }
    
    public Object removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.removeAndGet(this.getMaxElementIndex());
    }
    
    public Object peekLast() {
        return this.isEmpty() ? null : this.elementData(this.getMaxElementIndex());
    }
    
    @VisibleForTesting
    MinMaxPriorityQueue$MoveDesc removeAt(final int n) {
        Preconditions.checkPositionIndex(n, this.size);
        ++this.modCount;
        --this.size;
        if (this.size == n) {
            this.queue[this.size] = null;
            return null;
        }
        final Object elementData = this.elementData(this.size);
        final int correctLastElement = this.heapForIndex(this.size).getCorrectLastElement(elementData);
        final Object elementData2 = this.elementData(this.size);
        this.queue[this.size] = null;
        final MinMaxPriorityQueue$MoveDesc fillHole = this.fillHole(n, elementData2);
        if (correctLastElement >= n) {
            return fillHole;
        }
        if (fillHole == null) {
            return new MinMaxPriorityQueue$MoveDesc(elementData, elementData2);
        }
        return new MinMaxPriorityQueue$MoveDesc(elementData, fillHole.replaced);
    }
    
    private MinMaxPriorityQueue$MoveDesc fillHole(final int n, final Object o) {
        final MinMaxPriorityQueue$Heap heapForIndex = this.heapForIndex(n);
        final int fillHole = heapForIndex.fillHoleAt(n);
        final int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHole, o);
        if (bubbleUpAlternatingLevels == fillHole) {
            return heapForIndex.tryCrossOverAndBubbleUp(n, fillHole, o);
        }
        return (bubbleUpAlternatingLevels < n) ? new MinMaxPriorityQueue$MoveDesc(o, this.elementData(n)) : null;
    }
    
    private Object removeAndGet(final int n) {
        final Object elementData = this.elementData(n);
        this.removeAt(n);
        return elementData;
    }
    
    private MinMaxPriorityQueue$Heap heapForIndex(final int n) {
        return isEvenLevel(n) ? this.minHeap : this.maxHeap;
    }
    
    @VisibleForTesting
    static boolean isEvenLevel(final int n) {
        final int n2 = n + 1;
        Preconditions.checkState(n2 > 0, (Object)"negative index");
        return (n2 & 0x55555555) > (n2 & 0xAAAAAAAA);
    }
    
    @VisibleForTesting
    boolean isIntact() {
        for (int i = 1; i < this.size; ++i) {
            if (!this.heapForIndex(i).verifyIndex(i)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Iterator iterator() {
        return new MinMaxPriorityQueue$QueueIterator(this, null);
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < this.size; ++i) {
            this.queue[i] = null;
        }
        this.size = 0;
    }
    
    @Override
    public Object[] toArray() {
        final Object[] array = new Object[this.size];
        System.arraycopy(this.queue, 0, array, 0, this.size);
        return array;
    }
    
    public Comparator comparator() {
        return this.minHeap.ordering;
    }
    
    @VisibleForTesting
    int capacity() {
        return this.queue.length;
    }
    
    @VisibleForTesting
    static int initialQueueSize(final int n, final int n2, final Iterable iterable) {
        int max = (n == -1) ? 11 : n;
        if (iterable instanceof Collection) {
            max = Math.max(max, ((Collection)iterable).size());
        }
        return capAtMaximumSize(max, n2);
    }
    
    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            final Object[] queue = new Object[this.calculateNewCapacity()];
            System.arraycopy(this.queue, 0, queue, 0, this.queue.length);
            this.queue = queue;
        }
    }
    
    private int calculateNewCapacity() {
        final int length = this.queue.length;
        return capAtMaximumSize((length < 64) ? ((length + 1) * 2) : IntMath.checkedMultiply(length / 2, 3), this.maximumSize);
    }
    
    private static int capAtMaximumSize(final int n, final int n2) {
        return Math.min(n - 1, n2) + 1;
    }
}
