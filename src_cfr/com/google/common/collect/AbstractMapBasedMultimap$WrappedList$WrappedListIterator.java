/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class AbstractMapBasedMultimap$WrappedList$WrappedListIterator
extends AbstractMapBasedMultimap$WrappedCollection$WrappedIterator
implements ListIterator {
    final /* synthetic */ AbstractMapBasedMultimap$WrappedList this$1;

    AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList) {
        this.this$1 = abstractMapBasedMultimap$WrappedList;
        super(abstractMapBasedMultimap$WrappedList);
    }

    public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList, int n2) {
        this.this$1 = abstractMapBasedMultimap$WrappedList;
        super(abstractMapBasedMultimap$WrappedList, abstractMapBasedMultimap$WrappedList.getListDelegate().listIterator(n2));
    }

    private ListIterator getDelegateListIterator() {
        return (ListIterator)this.getDelegateIterator();
    }

    @Override
    public boolean hasPrevious() {
        return this.getDelegateListIterator().hasPrevious();
    }

    public Object previous() {
        return this.getDelegateListIterator().previous();
    }

    @Override
    public int nextIndex() {
        return this.getDelegateListIterator().nextIndex();
    }

    @Override
    public int previousIndex() {
        return this.getDelegateListIterator().previousIndex();
    }

    public void set(Object object) {
        this.getDelegateListIterator().set(object);
    }

    public void add(Object object) {
        boolean bl2 = this.this$1.isEmpty();
        this.getDelegateListIterator().add(object);
        AbstractMapBasedMultimap.access$208(this.this$1.this$0);
        if (!bl2) return;
        this.this$1.addToMap();
    }
}

