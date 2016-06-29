package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class Collections2$FilteredCollection extends AbstractCollection
{
    final Collection unfiltered;
    final Predicate predicate;
    
    Collections2$FilteredCollection(final Collection unfiltered, final Predicate predicate) {
        this.unfiltered = unfiltered;
        this.predicate = predicate;
    }
    
    Collections2$FilteredCollection createCombined(final Predicate predicate) {
        return new Collections2$FilteredCollection(this.unfiltered, Predicates.and(this.predicate, predicate));
    }
    
    @Override
    public boolean add(final Object o) {
        Preconditions.checkArgument(this.predicate.apply(o));
        return this.unfiltered.add(o);
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Preconditions.checkArgument(this.predicate.apply(iterator.next()));
        }
        return this.unfiltered.addAll(collection);
    }
    
    @Override
    public void clear() {
        Iterables.removeIf(this.unfiltered, this.predicate);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return Collections2.safeContains(this.unfiltered, o) && this.predicate.apply(o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }
    
    @Override
    public boolean isEmpty() {
        return !Iterables.any(this.unfiltered, this.predicate);
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.contains(o) && this.unfiltered.remove(o);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(collection)));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(collection))));
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
    
    @Override
    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return Lists.newArrayList(this.iterator()).toArray(array);
    }
}
