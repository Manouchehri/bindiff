/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedHashMultimap$ValueSet$1
implements Iterator {
    LinkedHashMultimap$ValueSetLink nextEntry;
    LinkedHashMultimap$ValueEntry toRemove;
    int expectedModCount;
    final /* synthetic */ LinkedHashMultimap$ValueSet this$1;

    LinkedHashMultimap$ValueSet$1(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        this.this$1 = linkedHashMultimap$ValueSet;
        this.nextEntry = LinkedHashMultimap$ValueSet.access$000(this.this$1);
        this.expectedModCount = LinkedHashMultimap$ValueSet.access$100(this.this$1);
    }

    private void checkForComodification() {
        if (LinkedHashMultimap$ValueSet.access$100(this.this$1) == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        this.checkForComodification();
        if (this.nextEntry == this.this$1) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = (LinkedHashMultimap$ValueEntry)this.nextEntry;
        Object object = linkedHashMultimap$ValueEntry.getValue();
        this.toRemove = linkedHashMultimap$ValueEntry;
        this.nextEntry = linkedHashMultimap$ValueEntry.getSuccessorInValueSet();
        return object;
    }

    @Override
    public void remove() {
        this.checkForComodification();
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$1.remove(this.toRemove.getValue());
        this.expectedModCount = LinkedHashMultimap$ValueSet.access$100(this.this$1);
        this.toRemove = null;
    }
}

