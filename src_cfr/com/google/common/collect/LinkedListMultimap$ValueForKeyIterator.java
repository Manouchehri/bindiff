/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import java.util.ListIterator;
import javax.annotation.Nullable;

class LinkedListMultimap$ValueForKeyIterator
implements ListIterator {
    final Object key;
    int nextIndex;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    LinkedListMultimap$Node previous;
    final /* synthetic */ LinkedListMultimap this$0;

    LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap linkedListMultimap, @Nullable Object object) {
        this.this$0 = linkedListMultimap;
        this.key = object;
        LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(linkedListMultimap).get(object);
        this.next = linkedListMultimap$KeyList == null ? null : linkedListMultimap$KeyList.head;
    }

    public LinkedListMultimap$ValueForKeyIterator(LinkedListMultimap linkedListMultimap, @Nullable Object object, int n2) {
        this.this$0 = linkedListMultimap;
        LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(linkedListMultimap).get(object);
        int n3 = linkedListMultimap$KeyList == null ? 0 : linkedListMultimap$KeyList.count;
        Preconditions.checkPositionIndex(n2, n3);
        if (n2 >= n3 / 2) {
            this.previous = linkedListMultimap$KeyList == null ? null : linkedListMultimap$KeyList.tail;
            this.nextIndex = n3;
            while (n2++ < n3) {
                this.previous();
            }
        } else {
            LinkedListMultimap$Node linkedListMultimap$Node = this.next = linkedListMultimap$KeyList == null ? null : linkedListMultimap$KeyList.head;
            while (n2-- > 0) {
                this.next();
            }
        }
        this.key = object;
        this.current = null;
    }

    @Override
    public boolean hasNext() {
        if (this.next == null) return false;
        return true;
    }

    @Override
    public Object next() {
        LinkedListMultimap.access$300(this.next);
        this.previous = this.current = this.next;
        this.next = this.next.nextSibling;
        ++this.nextIndex;
        return this.current.value;
    }

    @Override
    public boolean hasPrevious() {
        if (this.previous == null) return false;
        return true;
    }

    public Object previous() {
        LinkedListMultimap.access$300(this.previous);
        this.next = this.current = this.previous;
        this.previous = this.previous.previousSibling;
        --this.nextIndex;
        return this.current.value;
    }

    @Override
    public int nextIndex() {
        return this.nextIndex;
    }

    @Override
    public int previousIndex() {
        return this.nextIndex - 1;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.current != null);
        if (this.current != this.next) {
            this.previous = this.current.previousSibling;
            --this.nextIndex;
        } else {
            this.next = this.current.nextSibling;
        }
        LinkedListMultimap.access$400(this.this$0, this.current);
        this.current = null;
    }

    public void set(Object object) {
        Preconditions.checkState(this.current != null);
        this.current.value = object;
    }

    public void add(Object object) {
        this.previous = LinkedListMultimap.access$700(this.this$0, this.key, object, this.next);
        ++this.nextIndex;
        this.current = null;
    }
}

