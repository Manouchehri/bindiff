package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.math.*;

class MinMaxPriorityQueue$QueueIterator implements Iterator
{
    private int cursor;
    private int expectedModCount;
    private Queue forgetMeNot;
    private List skipMe;
    private Object lastFromForgetMeNot;
    private boolean canRemove;
    final /* synthetic */ MinMaxPriorityQueue this$0;
    
    private MinMaxPriorityQueue$QueueIterator(final MinMaxPriorityQueue this$0) {
        this.this$0 = this$0;
        this.cursor = -1;
        this.expectedModCount = this.this$0.modCount;
    }
    
    @Override
    public boolean hasNext() {
        this.checkModCount();
        return this.nextNotInSkipMe(this.cursor + 1) < this.this$0.size() || (this.forgetMeNot != null && !this.forgetMeNot.isEmpty());
    }
    
    @Override
    public Object next() {
        this.checkModCount();
        final int nextNotInSkipMe = this.nextNotInSkipMe(this.cursor + 1);
        if (nextNotInSkipMe < this.this$0.size()) {
            this.cursor = nextNotInSkipMe;
            this.canRemove = true;
            return this.this$0.elementData(this.cursor);
        }
        if (this.forgetMeNot != null) {
            this.cursor = this.this$0.size();
            this.lastFromForgetMeNot = this.forgetMeNot.poll();
            if (this.lastFromForgetMeNot != null) {
                this.canRemove = true;
                return this.lastFromForgetMeNot;
            }
        }
        throw new NoSuchElementException("iterator moved past last element in queue.");
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        this.checkModCount();
        this.canRemove = false;
        ++this.expectedModCount;
        if (this.cursor < this.this$0.size()) {
            final MinMaxPriorityQueue$MoveDesc remove = this.this$0.removeAt(this.cursor);
            if (remove != null) {
                if (this.forgetMeNot == null) {
                    this.forgetMeNot = new ArrayDeque();
                    this.skipMe = new ArrayList(3);
                }
                this.forgetMeNot.add(remove.toTrickle);
                this.skipMe.add(remove.replaced);
            }
            --this.cursor;
        }
        else {
            Preconditions.checkState(this.removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }
    }
    
    private boolean containsExact(final Iterable iterable, final Object o) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == o) {
                return true;
            }
        }
        return false;
    }
    
    boolean removeExact(final Object o) {
        for (int i = 0; i < this.this$0.size; ++i) {
            if (this.this$0.queue[i] == o) {
                this.this$0.removeAt(i);
                return true;
            }
        }
        return false;
    }
    
    void checkModCount() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
    
    private int nextNotInSkipMe(int n) {
        if (this.skipMe != null) {
            while (n < this.this$0.size() && this.containsExact(this.skipMe, this.this$0.elementData(n))) {
                ++n;
            }
        }
        return n;
    }
}
