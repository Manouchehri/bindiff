package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.math.*;

class MinMaxPriorityQueue$Heap
{
    final Ordering ordering;
    @Weak
    MinMaxPriorityQueue$Heap otherHeap;
    final /* synthetic */ MinMaxPriorityQueue this$0;
    
    MinMaxPriorityQueue$Heap(final MinMaxPriorityQueue this$0, final Ordering ordering) {
        this.this$0 = this$0;
        this.ordering = ordering;
    }
    
    int compareElements(final int n, final int n2) {
        return this.ordering.compare(this.this$0.elementData(n), this.this$0.elementData(n2));
    }
    
    MinMaxPriorityQueue$MoveDesc tryCrossOverAndBubbleUp(final int n, final int n2, final Object o) {
        final int crossOver = this.crossOver(n2, o);
        if (crossOver == n2) {
            return null;
        }
        Object o2;
        if (crossOver < n) {
            o2 = this.this$0.elementData(n);
        }
        else {
            o2 = this.this$0.elementData(this.getParentIndex(n));
        }
        if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, o) < n) {
            return new MinMaxPriorityQueue$MoveDesc(o, o2);
        }
        return null;
    }
    
    void bubbleUp(int n, final Object o) {
        final int crossOverUp = this.crossOverUp(n, o);
        MinMaxPriorityQueue$Heap otherHeap;
        if (crossOverUp == n) {
            otherHeap = this;
        }
        else {
            n = crossOverUp;
            otherHeap = this.otherHeap;
        }
        otherHeap.bubbleUpAlternatingLevels(n, o);
    }
    
    int bubbleUpAlternatingLevels(int i, final Object o) {
        while (i > 2) {
            final int grandparentIndex = this.getGrandparentIndex(i);
            final Object elementData = this.this$0.elementData(grandparentIndex);
            if (this.ordering.compare(elementData, o) <= 0) {
                break;
            }
            this.this$0.queue[i] = elementData;
            i = grandparentIndex;
        }
        this.this$0.queue[i] = o;
        return i;
    }
    
    int findMin(final int n, final int n2) {
        if (n >= this.this$0.size) {
            return -1;
        }
        Preconditions.checkState(n > 0);
        final int n3 = Math.min(n, this.this$0.size - n2) + n2;
        int n4 = n;
        for (int i = n + 1; i < n3; ++i) {
            if (this.compareElements(i, n4) < 0) {
                n4 = i;
            }
        }
        return n4;
    }
    
    int findMinChild(final int n) {
        return this.findMin(this.getLeftChildIndex(n), 2);
    }
    
    int findMinGrandChild(final int n) {
        final int leftChildIndex = this.getLeftChildIndex(n);
        if (leftChildIndex < 0) {
            return -1;
        }
        return this.findMin(this.getLeftChildIndex(leftChildIndex), 4);
    }
    
    int crossOverUp(final int n, final Object o) {
        if (n == 0) {
            this.this$0.queue[0] = o;
            return 0;
        }
        int parentIndex = this.getParentIndex(n);
        Object elementData = this.this$0.elementData(parentIndex);
        if (parentIndex != 0) {
            final int rightChildIndex = this.getRightChildIndex(this.getParentIndex(parentIndex));
            if (rightChildIndex != parentIndex && this.getLeftChildIndex(rightChildIndex) >= this.this$0.size) {
                final Object elementData2 = this.this$0.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
        }
        if (this.ordering.compare(elementData, o) < 0) {
            this.this$0.queue[n] = elementData;
            this.this$0.queue[parentIndex] = o;
            return parentIndex;
        }
        this.this$0.queue[n] = o;
        return n;
    }
    
    int getCorrectLastElement(final Object o) {
        final int parentIndex = this.getParentIndex(this.this$0.size);
        if (parentIndex != 0) {
            final int rightChildIndex = this.getRightChildIndex(this.getParentIndex(parentIndex));
            if (rightChildIndex != parentIndex && this.getLeftChildIndex(rightChildIndex) >= this.this$0.size) {
                final Object elementData = this.this$0.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, o) < 0) {
                    this.this$0.queue[rightChildIndex] = o;
                    this.this$0.queue[this.this$0.size] = elementData;
                    return rightChildIndex;
                }
            }
        }
        return this.this$0.size;
    }
    
    int crossOver(final int n, final Object o) {
        final int minChild = this.findMinChild(n);
        if (minChild > 0 && this.ordering.compare(this.this$0.elementData(minChild), o) < 0) {
            this.this$0.queue[n] = this.this$0.elementData(minChild);
            this.this$0.queue[minChild] = o;
            return minChild;
        }
        return this.crossOverUp(n, o);
    }
    
    int fillHoleAt(int n) {
        int minGrandChild;
        while ((minGrandChild = this.findMinGrandChild(n)) > 0) {
            this.this$0.queue[n] = this.this$0.elementData(minGrandChild);
            n = minGrandChild;
        }
        return n;
    }
    
    private boolean verifyIndex(final int n) {
        return (this.getLeftChildIndex(n) >= this.this$0.size || this.compareElements(n, this.getLeftChildIndex(n)) <= 0) && (this.getRightChildIndex(n) >= this.this$0.size || this.compareElements(n, this.getRightChildIndex(n)) <= 0) && (n <= 0 || this.compareElements(n, this.getParentIndex(n)) <= 0) && (n <= 2 || this.compareElements(this.getGrandparentIndex(n), n) <= 0);
    }
    
    private int getLeftChildIndex(final int n) {
        return n * 2 + 1;
    }
    
    private int getRightChildIndex(final int n) {
        return n * 2 + 2;
    }
    
    private int getParentIndex(final int n) {
        return (n - 1) / 2;
    }
    
    private int getGrandparentIndex(final int n) {
        return this.getParentIndex(this.getParentIndex(n));
    }
}
