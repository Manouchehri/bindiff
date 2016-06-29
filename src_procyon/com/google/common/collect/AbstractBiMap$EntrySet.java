package com.google.common.collect;

import java.util.*;
import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;

class AbstractBiMap$EntrySet extends ForwardingSet
{
    final Set esDelegate;
    final /* synthetic */ AbstractBiMap this$0;
    
    private AbstractBiMap$EntrySet(final AbstractBiMap this$0) {
        this.this$0 = this$0;
        this.esDelegate = this.this$0.delegate.entrySet();
    }
    
    @Override
    protected Set delegate() {
        return this.esDelegate;
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
    
    @Override
    public boolean remove(final Object o) {
        if (!this.esDelegate.contains(o)) {
            return false;
        }
        final Map.Entry entry = (Map.Entry)o;
        this.this$0.inverse.delegate.remove(entry.getValue());
        this.esDelegate.remove(entry);
        return true;
    }
    
    @Override
    public Iterator iterator() {
        return new AbstractBiMap$EntrySet$1(this, this.esDelegate.iterator());
    }
    
    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.standardToArray(array);
    }
    
    @Override
    public boolean contains(final Object o) {
        return Maps.containsEntryImpl(this.delegate(), o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.standardContainsAll(collection);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.standardRemoveAll(collection);
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.standardRetainAll(collection);
    }
}
