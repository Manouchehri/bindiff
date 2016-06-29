/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$Node;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map;

class LinkedListMultimap$NodeIterator
implements ListIterator {
    int nextIndex;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    LinkedListMultimap$Node previous;
    int expectedModCount;
    final /* synthetic */ LinkedListMultimap this$0;

    LinkedListMultimap$NodeIterator(LinkedListMultimap linkedListMultimap, int n2) {
        this.this$0 = linkedListMultimap;
        this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
        int n3 = linkedListMultimap.size();
        Preconditions.checkPositionIndex(n2, n3);
        if (n2 >= n3 / 2) {
            this.previous = LinkedListMultimap.access$100(linkedListMultimap);
            this.nextIndex = n3;
            while (n2++ < n3) {
                this.previous();
            }
        } else {
            this.next = LinkedListMultimap.access$200(linkedListMultimap);
            while (n2-- > 0) {
                this.next();
            }
        }
        this.current = null;
    }

    private void checkForConcurrentModification() {
        if (LinkedListMultimap.access$000(this.this$0) == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        this.checkForConcurrentModification();
        if (this.next == null) return false;
        return true;
    }

    @Override
    public LinkedListMultimap$Node next() {
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.next);
        this.previous = this.current = this.next;
        this.next = this.next.next;
        ++this.nextIndex;
        return this.current;
    }

    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.current != null);
        if (this.current != this.next) {
            this.previous = this.current.previous;
            --this.nextIndex;
        } else {
            this.next = this.current.next;
        }
        LinkedListMultimap.access$400(this.this$0, this.current);
        this.current = null;
        this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
    }

    @Override
    public boolean hasPrevious() {
        this.checkForConcurrentModification();
        if (this.previous == null) return false;
        return true;
    }

    public LinkedListMultimap$Node previous() {
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.previous);
        this.next = this.current = this.previous;
        this.previous = this.previous.previous;
        --this.nextIndex;
        return this.current;
    }

    @Override
    public int nextIndex() {
        return this.nextIndex;
    }

    @Override
    public int previousIndex() {
        return this.nextIndex - 1;
    }

    public void set(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    public void add(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    void setValue(Object object) {
        Preconditions.checkState(this.current != null);
        this.current.value = object;
    }
}

