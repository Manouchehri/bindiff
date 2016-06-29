/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class AbstractMapBasedMultimap$WrappedCollection$WrappedIterator
implements Iterator {
    final Iterator delegateIterator;
    final Collection originalDelegate;
    final /* synthetic */ AbstractMapBasedMultimap$WrappedCollection this$1;

    AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$1 = abstractMapBasedMultimap$WrappedCollection;
        this.originalDelegate = this.this$1.delegate;
        this.delegateIterator = AbstractMapBasedMultimap.access$100(abstractMapBasedMultimap$WrappedCollection.this$0, abstractMapBasedMultimap$WrappedCollection.delegate);
    }

    AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection, Iterator iterator) {
        this.this$1 = abstractMapBasedMultimap$WrappedCollection;
        this.originalDelegate = this.this$1.delegate;
        this.delegateIterator = iterator;
    }

    void validateIterator() {
        this.this$1.refreshIfEmpty();
        if (this.this$1.delegate == this.originalDelegate) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        this.validateIterator();
        return this.delegateIterator.hasNext();
    }

    public Object next() {
        this.validateIterator();
        return this.delegateIterator.next();
    }

    @Override
    public void remove() {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$210(this.this$1.this$0);
        this.this$1.removeIfEmpty();
    }

    Iterator getDelegateIterator() {
        this.validateIterator();
        return this.delegateIterator;
    }
}

