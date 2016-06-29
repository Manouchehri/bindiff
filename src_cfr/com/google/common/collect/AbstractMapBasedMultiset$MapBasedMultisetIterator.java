/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractMapBasedMultiset$MapBasedMultisetIterator
implements Iterator {
    final Iterator entryIterator;
    Map.Entry currentEntry;
    int occurrencesLeft;
    boolean canRemove;
    final /* synthetic */ AbstractMapBasedMultiset this$0;

    AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        this.this$0 = abstractMapBasedMultiset;
        this.entryIterator = AbstractMapBasedMultiset.access$000(abstractMapBasedMultiset).entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        if (this.occurrencesLeft > 0) return true;
        if (this.entryIterator.hasNext()) return true;
        return false;
    }

    public Object next() {
        if (this.occurrencesLeft == 0) {
            this.currentEntry = (Map.Entry)this.entryIterator.next();
            this.occurrencesLeft = ((Count)this.currentEntry.getValue()).get();
        }
        --this.occurrencesLeft;
        this.canRemove = true;
        return this.currentEntry.getKey();
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        int n2 = ((Count)this.currentEntry.getValue()).get();
        if (n2 <= 0) {
            throw new ConcurrentModificationException();
        }
        if (((Count)this.currentEntry.getValue()).addAndGet(-1) == 0) {
            this.entryIterator.remove();
        }
        AbstractMapBasedMultiset.access$110(this.this$0);
        this.canRemove = false;
    }
}

