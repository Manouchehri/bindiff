/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

class MinMaxPriorityQueue$QueueIterator
implements Iterator {
    private int cursor;
    private int expectedModCount;
    private Queue forgetMeNot;
    private List skipMe;
    private Object lastFromForgetMeNot;
    private boolean canRemove;
    final /* synthetic */ MinMaxPriorityQueue this$0;

    private MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue) {
        this.this$0 = minMaxPriorityQueue;
        this.cursor = -1;
        this.expectedModCount = MinMaxPriorityQueue.access$700(this.this$0);
    }

    @Override
    public boolean hasNext() {
        this.checkModCount();
        if (this.nextNotInSkipMe(this.cursor + 1) < this.this$0.size()) return true;
        if (this.forgetMeNot == null) return false;
        if (this.forgetMeNot.isEmpty()) return false;
        return true;
    }

    public Object next() {
        this.checkModCount();
        int n2 = this.nextNotInSkipMe(this.cursor + 1);
        if (n2 < this.this$0.size()) {
            this.cursor = n2;
            this.canRemove = true;
            return this.this$0.elementData(this.cursor);
        }
        if (this.forgetMeNot == null) throw new NoSuchElementException("iterator moved past last element in queue.");
        this.cursor = this.this$0.size();
        this.lastFromForgetMeNot = this.forgetMeNot.poll();
        if (this.lastFromForgetMeNot == null) throw new NoSuchElementException("iterator moved past last element in queue.");
        this.canRemove = true;
        return this.lastFromForgetMeNot;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        this.checkModCount();
        this.canRemove = false;
        ++this.expectedModCount;
        if (this.cursor >= this.this$0.size()) {
            Preconditions.checkState(this.removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
            return;
        }
        MinMaxPriorityQueue$MoveDesc minMaxPriorityQueue$MoveDesc = this.this$0.removeAt(this.cursor);
        if (minMaxPriorityQueue$MoveDesc != null) {
            if (this.forgetMeNot == null) {
                this.forgetMeNot = new ArrayDeque();
                this.skipMe = new ArrayList(3);
            }
            this.forgetMeNot.add(minMaxPriorityQueue$MoveDesc.toTrickle);
            this.skipMe.add(minMaxPriorityQueue$MoveDesc.replaced);
        }
        --this.cursor;
    }

    private boolean containsExact(Iterable iterable, Object object) {
        Object t2;
        Iterator iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((t2 = iterator.next()) != object);
        return true;
    }

    boolean removeExact(Object object) {
        int n2 = 0;
        while (n2 < MinMaxPriorityQueue.access$600(this.this$0)) {
            if (MinMaxPriorityQueue.access$500(this.this$0)[n2] == object) {
                this.this$0.removeAt(n2);
                return true;
            }
            ++n2;
        }
        return false;
    }

    void checkModCount() {
        if (MinMaxPriorityQueue.access$700(this.this$0) == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    private int nextNotInSkipMe(int n2) {
        if (this.skipMe == null) return n2;
        while (n2 < this.this$0.size()) {
            if (!this.containsExact(this.skipMe, this.this$0.elementData(n2))) return n2;
            ++n2;
        }
        return n2;
    }

    /* synthetic */ MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue, MinMaxPriorityQueue$1 minMaxPriorityQueue$1) {
        this(minMaxPriorityQueue);
    }
}

