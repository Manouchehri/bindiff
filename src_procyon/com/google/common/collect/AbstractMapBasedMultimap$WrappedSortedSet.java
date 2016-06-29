package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedSortedSet extends AbstractMapBasedMultimap$WrappedCollection implements SortedSet
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$WrappedSortedSet(final AbstractMapBasedMultimap this$0, @Nullable final Object o, final SortedSet set, @Nullable final AbstractMapBasedMultimap$WrappedCollection collection) {
        this.this$0 = this$0;
        super(this$0, o, set, collection);
    }
    
    SortedSet getSortedSetDelegate() {
        return (SortedSet)this.getDelegate();
    }
    
    @Override
    public Comparator comparator() {
        return this.getSortedSetDelegate().comparator();
    }
    
    @Override
    public Object first() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().first();
    }
    
    @Override
    public Object last() {
        this.refreshIfEmpty();
        return this.getSortedSetDelegate().last();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().headSet(o), (this.getAncestor() == null) ? this : this.getAncestor());
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().subSet(o, o2), (this.getAncestor() == null) ? this : this.getAncestor());
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().tailSet(o), (this.getAncestor() == null) ? this : this.getAncestor());
    }
}
