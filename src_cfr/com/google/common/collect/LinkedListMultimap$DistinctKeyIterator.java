/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.Sets;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

class LinkedListMultimap$DistinctKeyIterator
implements Iterator {
    final Set seenKeys;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    int expectedModCount;
    final /* synthetic */ LinkedListMultimap this$0;

    private LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
        this.seenKeys = Sets.newHashSetWithExpectedSize(this.this$0.keySet().size());
        this.next = LinkedListMultimap.access$200(this.this$0);
        this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
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

    public Object next() {
        this.checkForConcurrentModification();
        LinkedListMultimap.access$300(this.next);
        this.current = this.next;
        this.seenKeys.add(this.current.key);
        do {
            this.next = this.next.next;
            if (this.next == null) return this.current.key;
        } while (!this.seenKeys.add(this.next.key));
        return this.current.key;
    }

    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.current != null);
        LinkedListMultimap.access$500(this.this$0, this.current.key);
        this.current = null;
        this.expectedModCount = LinkedListMultimap.access$000(this.this$0);
    }

    /* synthetic */ LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap linkedListMultimap, LinkedListMultimap$1 linkedListMultimap$1) {
        this(linkedListMultimap);
    }
}

