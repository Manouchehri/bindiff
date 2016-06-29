package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$WrappedNavigableSet extends AbstractMapBasedMultimap$WrappedSortedSet implements NavigableSet
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$WrappedNavigableSet(final AbstractMapBasedMultimap this$0, @Nullable final Object o, final NavigableSet set, @Nullable final AbstractMapBasedMultimap$WrappedCollection collection) {
        this.this$0 = this$0;
        super(this$0, o, set, collection);
    }
    
    @Override
    NavigableSet getSortedSetDelegate() {
        return (NavigableSet)super.getSortedSetDelegate();
    }
    
    @Override
    public Object lower(final Object o) {
        return this.getSortedSetDelegate().lower(o);
    }
    
    @Override
    public Object floor(final Object o) {
        return this.getSortedSetDelegate().floor(o);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return this.getSortedSetDelegate().ceiling(o);
    }
    
    @Override
    public Object higher(final Object o) {
        return this.getSortedSetDelegate().higher(o);
    }
    
    @Override
    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }
    
    @Override
    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }
    
    private NavigableSet wrap(final NavigableSet set) {
        return new AbstractMapBasedMultimap$WrappedNavigableSet(this.this$0, this.key, set, (this.getAncestor() == null) ? this : this.getAncestor());
    }
    
    @Override
    public NavigableSet descendingSet() {
        return this.wrap(this.getSortedSetDelegate().descendingSet());
    }
    
    @Override
    public Iterator descendingIterator() {
        return new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this, this.getSortedSetDelegate().descendingIterator());
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return this.wrap(this.getSortedSetDelegate().subSet(o, b, o2, b2));
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return this.wrap(this.getSortedSetDelegate().headSet(o, b));
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return this.wrap(this.getSortedSetDelegate().tailSet(o, b));
    }
}
