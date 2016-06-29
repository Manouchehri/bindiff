package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

final class Sets$PowerSet extends AbstractSet
{
    final ImmutableMap inputSet;
    
    Sets$PowerSet(final Set set) {
        this.inputSet = Maps.indexMap(set);
        Preconditions.checkArgument(this.inputSet.size() <= 30, "Too many elements to create power set: %s > 30", this.inputSet.size());
    }
    
    @Override
    public int size() {
        return 1 << this.inputSet.size();
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public Iterator iterator() {
        return new Sets$PowerSet$1(this, this.size());
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o instanceof Set && this.inputSet.keySet().containsAll((Collection<?>)o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Sets$PowerSet) {
            return this.inputSet.equals(((Sets$PowerSet)o).inputSet);
        }
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.inputSet);
        return new StringBuilder(10 + String.valueOf(value).length()).append("powerSet(").append(value).append(")").toString();
    }
}
