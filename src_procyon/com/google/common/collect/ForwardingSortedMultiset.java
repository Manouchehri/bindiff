package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class ForwardingSortedMultiset extends ForwardingMultiset implements SortedMultiset
{
    @Override
    protected abstract SortedMultiset delegate();
    
    @Override
    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }
    
    @Override
    public Comparator comparator() {
        return this.delegate().comparator();
    }
    
    @Override
    public SortedMultiset descendingMultiset() {
        return this.delegate().descendingMultiset();
    }
    
    @Override
    public Multiset$Entry firstEntry() {
        return this.delegate().firstEntry();
    }
    
    protected Multiset$Entry standardFirstEntry() {
        final Iterator<Multiset$Entry> iterator = (Iterator<Multiset$Entry>)this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset$Entry multiset$Entry = iterator.next();
        return Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
    }
    
    @Override
    public Multiset$Entry lastEntry() {
        return this.delegate().lastEntry();
    }
    
    protected Multiset$Entry standardLastEntry() {
        final Iterator<Multiset$Entry> iterator = (Iterator<Multiset$Entry>)this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset$Entry multiset$Entry = iterator.next();
        return Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
    }
    
    @Override
    public Multiset$Entry pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }
    
    protected Multiset$Entry standardPollFirstEntry() {
        final Iterator iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset$Entry multiset$Entry = iterator.next();
        final Multiset$Entry immutableEntry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return immutableEntry;
    }
    
    @Override
    public Multiset$Entry pollLastEntry() {
        return this.delegate().pollLastEntry();
    }
    
    protected Multiset$Entry standardPollLastEntry() {
        final Iterator iterator = this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        final Multiset$Entry multiset$Entry = iterator.next();
        final Multiset$Entry immutableEntry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return immutableEntry;
    }
    
    @Override
    public SortedMultiset headMultiset(final Object o, final BoundType boundType) {
        return this.delegate().headMultiset(o, boundType);
    }
    
    @Override
    public SortedMultiset subMultiset(final Object o, final BoundType boundType, final Object o2, final BoundType boundType2) {
        return this.delegate().subMultiset(o, boundType, o2, boundType2);
    }
    
    protected SortedMultiset standardSubMultiset(final Object o, final BoundType boundType, final Object o2, final BoundType boundType2) {
        return this.tailMultiset(o, boundType).headMultiset(o2, boundType2);
    }
    
    @Override
    public SortedMultiset tailMultiset(final Object o, final BoundType boundType) {
        return this.delegate().tailMultiset(o, boundType);
    }
}
