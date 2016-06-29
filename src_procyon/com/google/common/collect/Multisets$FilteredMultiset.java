package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

final class Multisets$FilteredMultiset extends AbstractMultiset
{
    final Multiset unfiltered;
    final Predicate predicate;
    
    Multisets$FilteredMultiset(final Multiset multiset, final Predicate predicate) {
        this.unfiltered = (Multiset)Preconditions.checkNotNull(multiset);
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }
    
    @Override
    Set createElementSet() {
        return Sets.filter(this.unfiltered.elementSet(), this.predicate);
    }
    
    @Override
    Set createEntrySet() {
        return Sets.filter(this.unfiltered.entrySet(), new Multisets$FilteredMultiset$1(this));
    }
    
    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    int distinctElements() {
        return this.elementSet().size();
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final int count = this.unfiltered.count(o);
        if (count > 0) {
            return this.predicate.apply(o) ? count : false;
        }
        return 0;
    }
    
    @Override
    public int add(@Nullable final Object o, final int n) {
        Preconditions.checkArgument(this.predicate.apply(o), "Element %s does not match predicate %s", o, this.predicate);
        return this.unfiltered.add(o, n);
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        CollectPreconditions.checkNonnegative(n, "occurrences");
        if (n == 0) {
            return this.count(o);
        }
        return this.contains(o) ? this.unfiltered.remove(o, n) : 0;
    }
    
    @Override
    public void clear() {
        this.elementSet().clear();
    }
}
