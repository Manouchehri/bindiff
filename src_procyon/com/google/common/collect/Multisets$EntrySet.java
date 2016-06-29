package com.google.common.collect;

import javax.annotation.*;

abstract class Multisets$EntrySet extends Sets$ImprovedAbstractSet
{
    abstract Multiset multiset();
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            return multiset$Entry.getCount() > 0 && this.multiset().count(multiset$Entry.getElement()) == multiset$Entry.getCount();
        }
        return false;
    }
    
    @Override
    public boolean remove(final Object o) {
        if (o instanceof Multiset$Entry) {
            final Multiset$Entry multiset$Entry = (Multiset$Entry)o;
            final Object element = multiset$Entry.getElement();
            final int count = multiset$Entry.getCount();
            if (count != 0) {
                return this.multiset().setCount(element, count, 0);
            }
        }
        return false;
    }
    
    @Override
    public void clear() {
        this.multiset().clear();
    }
}
