/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSortedSet
extends AbstractMapBasedMultimap$WrappedCollection
implements SortedSet {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$WrappedSortedSet(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, SortedSet sortedSet, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, sortedSet, abstractMapBasedMultimap$WrappedCollection);
    }

    SortedSet getSortedSetDelegate() {
        return (SortedSet)this.getDelegate();
    }

    public Comparator comparator() {
        return this.getSortedSetDelegate().comparator();
    }

    public Object first() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().first();
    }

    public Object last() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().last();
    }

    public SortedSet headSet(Object object) {
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet /* !! */ ;
        this.refreshIfEmpty();
        if (this.getAncestor() == null) {
            abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this;
            return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().headSet(object), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
        }
        abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this.getAncestor();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().headSet(object), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
    }

    public SortedSet subSet(Object object, Object object2) {
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet /* !! */ ;
        this.refreshIfEmpty();
        if (this.getAncestor() == null) {
            abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this;
            return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().subSet(object, object2), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
        }
        abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this.getAncestor();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().subSet(object, object2), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
    }

    public SortedSet tailSet(Object object) {
        AbstractMapBasedMultimap$WrappedSortedSet abstractMapBasedMultimap$WrappedSortedSet /* !! */ ;
        this.refreshIfEmpty();
        if (this.getAncestor() == null) {
            abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this;
            return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().tailSet(object), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
        }
        abstractMapBasedMultimap$WrappedSortedSet /* !! */  = this.getAncestor();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().tailSet(object), abstractMapBasedMultimap$WrappedSortedSet /* !! */ );
    }
}

