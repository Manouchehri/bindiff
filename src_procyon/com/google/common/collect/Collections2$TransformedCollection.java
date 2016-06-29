package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Collections2$TransformedCollection extends AbstractCollection
{
    final Collection fromCollection;
    final Function function;
    
    Collections2$TransformedCollection(final Collection collection, final Function function) {
        this.fromCollection = (Collection)Preconditions.checkNotNull(collection);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public void clear() {
        this.fromCollection.clear();
    }
    
    @Override
    public boolean isEmpty() {
        return this.fromCollection.isEmpty();
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.transform(this.fromCollection.iterator(), this.function);
    }
    
    @Override
    public int size() {
        return this.fromCollection.size();
    }
}
