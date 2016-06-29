/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.Ordering;
import com.google.j2objc.annotations.Weak;

class MinMaxPriorityQueue$Heap {
    final Ordering ordering;
    @Weak
    MinMaxPriorityQueue$Heap otherHeap;
    final /* synthetic */ MinMaxPriorityQueue this$0;

    MinMaxPriorityQueue$Heap(MinMaxPriorityQueue minMaxPriorityQueue, Ordering ordering) {
        this.this$0 = minMaxPriorityQueue;
        this.ordering = ordering;
    }

    int compareElements(int n2, int n3) {
        return this.ordering.compare(this.this$0.elementData(n2), this.this$0.elementData(n3));
    }

    MinMaxPriorityQueue$MoveDesc tryCrossOverAndBubbleUp(int n2, int n3, Object object) {
        int n4 = this.crossOver(n3, object);
        if (n4 == n3) {
            return null;
        }
        Object object2 = n4 < n2 ? this.this$0.elementData(n2) : this.this$0.elementData(this.getParentIndex(n2));
        if (this.otherHeap.bubbleUpAlternatingLevels(n4, object) >= n2) return null;
        return new MinMaxPriorityQueue$MoveDesc(object, object2);
    }

    void bubbleUp(int n2, Object object) {
        MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap;
        int n3 = this.crossOverUp(n2, object);
        if (n3 == n2) {
            minMaxPriorityQueue$Heap = this;
        } else {
            n2 = n3;
            minMaxPriorityQueue$Heap = this.otherHeap;
        }
        minMaxPriorityQueue$Heap.bubbleUpAlternatingLevels(n2, object);
    }

    int bubbleUpAlternatingLevels(int n2, Object object) {
        Object object2;
        int n3;
        while (n2 > 2 && this.ordering.compare(object2 = this.this$0.elementData(n3 = this.getGrandparentIndex(n2)), object) > 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = object2;
            n2 = n3;
        }
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = object;
        return n2;
    }

    int findMin(int n2, int n3) {
        if (n2 >= MinMaxPriorityQueue.access$600(this.this$0)) {
            return -1;
        }
        Preconditions.checkState(n2 > 0);
        int n4 = Math.min(n2, MinMaxPriorityQueue.access$600(this.this$0) - n3) + n3;
        int n5 = n2;
        int n6 = n2 + 1;
        while (n6 < n4) {
            if (this.compareElements(n6, n5) < 0) {
                n5 = n6;
            }
            ++n6;
        }
        return n5;
    }

    int findMinChild(int n2) {
        return this.findMin(this.getLeftChildIndex(n2), 2);
    }

    int findMinGrandChild(int n2) {
        int n3 = this.getLeftChildIndex(n2);
        if (n3 >= 0) return this.findMin(this.getLeftChildIndex(n3), 4);
        return -1;
    }

    int crossOverUp(int n2, Object object) {
        int n3;
        Object object2;
        int n4;
        if (n2 == 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[0] = object;
            return 0;
        }
        int n5 = this.getParentIndex(n2);
        Object object3 = this.this$0.elementData(n5);
        if (n5 != 0 && (n3 = this.getRightChildIndex(n4 = this.getParentIndex(n5))) != n5 && this.getLeftChildIndex(n3) >= MinMaxPriorityQueue.access$600(this.this$0) && this.ordering.compare(object2 = this.this$0.elementData(n3), object3) < 0) {
            n5 = n3;
            object3 = object2;
        }
        if (this.ordering.compare(object3, object) < 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = object3;
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n5] = object;
            return n5;
        }
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = object;
        return n2;
    }

    int getCorrectLastElement(Object object) {
        int n2 = this.getParentIndex(MinMaxPriorityQueue.access$600(this.this$0));
        if (n2 == 0) return MinMaxPriorityQueue.access$600(this.this$0);
        int n3 = this.getParentIndex(n2);
        int n4 = this.getRightChildIndex(n3);
        if (n4 == n2) return MinMaxPriorityQueue.access$600(this.this$0);
        if (this.getLeftChildIndex(n4) < MinMaxPriorityQueue.access$600(this.this$0)) return MinMaxPriorityQueue.access$600(this.this$0);
        Object object2 = this.this$0.elementData(n4);
        if (this.ordering.compare(object2, object) >= 0) return MinMaxPriorityQueue.access$600(this.this$0);
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n4] = object;
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[MinMaxPriorityQueue.access$600((MinMaxPriorityQueue)this.this$0)] = object2;
        return n4;
    }

    int crossOver(int n2, Object object) {
        int n3 = this.findMinChild(n2);
        if (n3 <= 0) return this.crossOverUp(n2, object);
        if (this.ordering.compare(this.this$0.elementData(n3), object) >= 0) return this.crossOverUp(n2, object);
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = this.this$0.elementData(n3);
        MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n3] = object;
        return n3;
    }

    int fillHoleAt(int n2) {
        int n3;
        while ((n3 = this.findMinGrandChild(n2)) > 0) {
            MinMaxPriorityQueue.access$500((MinMaxPriorityQueue)this.this$0)[n2] = this.this$0.elementData(n3);
            n2 = n3;
        }
        return n2;
    }

    private boolean verifyIndex(int n2) {
        if (this.getLeftChildIndex(n2) < MinMaxPriorityQueue.access$600(this.this$0) && this.compareElements(n2, this.getLeftChildIndex(n2)) > 0) {
            return false;
        }
        if (this.getRightChildIndex(n2) < MinMaxPriorityQueue.access$600(this.this$0) && this.compareElements(n2, this.getRightChildIndex(n2)) > 0) {
            return false;
        }
        if (n2 > 0 && this.compareElements(n2, this.getParentIndex(n2)) > 0) {
            return false;
        }
        if (n2 <= 2) return true;
        if (this.compareElements(this.getGrandparentIndex(n2), n2) <= 0) return true;
        return false;
    }

    private int getLeftChildIndex(int n2) {
        return n2 * 2 + 1;
    }

    private int getRightChildIndex(int n2) {
        return n2 * 2 + 2;
    }

    private int getParentIndex(int n2) {
        return (n2 - 1) / 2;
    }

    private int getGrandparentIndex(int n2) {
        return this.getParentIndex(this.getParentIndex(n2));
    }

    static /* synthetic */ boolean access$400(MinMaxPriorityQueue$Heap minMaxPriorityQueue$Heap, int n2) {
        return minMaxPriorityQueue$Heap.verifyIndex(n2);
    }
}

