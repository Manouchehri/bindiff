/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableSet")
class AbstractMapBasedMultimap$WrappedNavigableSet
extends AbstractMapBasedMultimap$WrappedSortedSet
implements NavigableSet {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$WrappedNavigableSet(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, NavigableSet navigableSet, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, navigableSet, abstractMapBasedMultimap$WrappedCollection);
    }

    @Override
    NavigableSet getSortedSetDelegate() {
        return (NavigableSet)super.getSortedSetDelegate();
    }

    public Object lower(Object object) {
        return this.getSortedSetDelegate().lower(object);
    }

    public Object floor(Object object) {
        return this.getSortedSetDelegate().floor(object);
    }

    public Object ceiling(Object object) {
        return this.getSortedSetDelegate().ceiling(object);
    }

    public Object higher(Object object) {
        return this.getSortedSetDelegate().higher(object);
    }

    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    private NavigableSet wrap(NavigableSet navigableSet) {
        AbstractMapBasedMultimap$WrappedNavigableSet abstractMapBasedMultimap$WrappedNavigableSet /* !! */ ;
        if (this.getAncestor() == null) {
            abstractMapBasedMultimap$WrappedNavigableSet /* !! */  = this;
            return new AbstractMapBasedMultimap$WrappedNavigableSet(this.this$0, this.key, navigableSet, abstractMapBasedMultimap$WrappedNavigableSet /* !! */ );
        }
        abstractMapBasedMultimap$WrappedNavigableSet /* !! */  = this.getAncestor();
        return new AbstractMapBasedMultimap$WrappedNavigableSet(this.this$0, this.key, navigableSet, abstractMapBasedMultimap$WrappedNavigableSet /* !! */ );
    }

    public NavigableSet descendingSet() {
        return this.wrap(this.getSortedSetDelegate().descendingSet());
    }

    public Iterator descendingIterator() {
        return new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this, this.getSortedSetDelegate().descendingIterator());
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.wrap(this.getSortedSetDelegate().subSet(object, bl2, object2, bl3));
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.wrap(this.getSortedSetDelegate().headSet(object, bl2));
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.wrap(this.getSortedSetDelegate().tailSet(object, bl2));
    }
}

