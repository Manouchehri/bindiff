/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Lists$ReverseList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Lists$ReverseList$1
implements ListIterator {
    boolean canRemoveOrSet;
    final /* synthetic */ ListIterator val$forwardIterator;
    final /* synthetic */ Lists$ReverseList this$0;

    Lists$ReverseList$1(Lists$ReverseList lists$ReverseList, ListIterator listIterator) {
        this.this$0 = lists$ReverseList;
        this.val$forwardIterator = listIterator;
    }

    public void add(Object object) {
        this.val$forwardIterator.add(object);
        this.val$forwardIterator.previous();
        this.canRemoveOrSet = false;
    }

    @Override
    public boolean hasNext() {
        return this.val$forwardIterator.hasPrevious();
    }

    @Override
    public boolean hasPrevious() {
        return this.val$forwardIterator.hasNext();
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.canRemoveOrSet = true;
        return this.val$forwardIterator.previous();
    }

    @Override
    public int nextIndex() {
        return Lists$ReverseList.access$000(this.this$0, this.val$forwardIterator.nextIndex());
    }

    public Object previous() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.canRemoveOrSet = true;
        return this.val$forwardIterator.next();
    }

    @Override
    public int previousIndex() {
        return this.nextIndex() - 1;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemoveOrSet);
        this.val$forwardIterator.remove();
        this.canRemoveOrSet = false;
    }

    public void set(Object object) {
        Preconditions.checkState(this.canRemoveOrSet);
        this.val$forwardIterator.set(object);
    }
}

