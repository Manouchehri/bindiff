package com.google.common.collect;

import java.io.*;
import java.util.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;

class AbstractBiMap$KeySet extends ForwardingSet
{
    final /* synthetic */ AbstractBiMap this$0;
    
    private AbstractBiMap$KeySet(final AbstractBiMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected Set delegate() {
        return this.this$0.delegate.keySet();
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
    
    @Override
    public boolean remove(final Object o) {
        if (!this.contains(o)) {
            return false;
        }
        this.this$0.removeFromBothMaps(o);
        return true;
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.standardRemoveAll(collection);
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.standardRetainAll(collection);
    }
    
    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.this$0.entrySet().iterator());
    }
}
