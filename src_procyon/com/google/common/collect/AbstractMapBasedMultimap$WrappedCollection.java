package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;
import com.google.common.annotations.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedCollection extends AbstractCollection
{
    final Object key;
    Collection delegate;
    final AbstractMapBasedMultimap$WrappedCollection ancestor;
    final Collection ancestorDelegate;
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$WrappedCollection(final AbstractMapBasedMultimap this$0, @Nullable final Object key, final Collection delegate, @Nullable final AbstractMapBasedMultimap$WrappedCollection ancestor) {
        this.this$0 = this$0;
        this.key = key;
        this.delegate = delegate;
        this.ancestor = ancestor;
        this.ancestorDelegate = ((ancestor == null) ? null : ancestor.getDelegate());
    }
    
    void refreshIfEmpty() {
        if (this.ancestor != null) {
            this.ancestor.refreshIfEmpty();
            if (this.ancestor.getDelegate() != this.ancestorDelegate) {
                throw new ConcurrentModificationException();
            }
        }
        else if (this.delegate.isEmpty()) {
            final Collection delegate = this.this$0.map.get(this.key);
            if (delegate != null) {
                this.delegate = delegate;
            }
        }
    }
    
    void removeIfEmpty() {
        if (this.ancestor != null) {
            this.ancestor.removeIfEmpty();
        }
        else if (this.delegate.isEmpty()) {
            this.this$0.map.remove(this.key);
        }
    }
    
    Object getKey() {
        return this.key;
    }
    
    void addToMap() {
        if (this.ancestor != null) {
            this.ancestor.addToMap();
        }
        else {
            this.this$0.map.put(this.key, this.delegate);
        }
    }
    
    @Override
    public int size() {
        this.refreshIfEmpty();
        return this.delegate.size();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        this.refreshIfEmpty();
        return this.delegate.equals(o);
    }
    
    @Override
    public int hashCode() {
        this.refreshIfEmpty();
        return this.delegate.hashCode();
    }
    
    @Override
    public String toString() {
        this.refreshIfEmpty();
        return this.delegate.toString();
    }
    
    Collection getDelegate() {
        return this.delegate;
    }
    
    @Override
    public Iterator iterator() {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this);
    }
    
    @Override
    public boolean add(final Object o) {
        this.refreshIfEmpty();
        final boolean empty = this.delegate.isEmpty();
        final boolean add = this.delegate.add(o);
        if (add) {
            this.this$0.totalSize++;
            if (empty) {
                this.addToMap();
            }
        }
        return add;
    }
    
    AbstractMapBasedMultimap$WrappedCollection getAncestor() {
        return this.ancestor;
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        final int size = this.size();
        final boolean addAll = this.delegate.addAll(collection);
        if (addAll) {
            this.this$0.totalSize += this.delegate.size() - size;
            if (size == 0) {
                this.addToMap();
            }
        }
        return addAll;
    }
    
    @Override
    public boolean contains(final Object o) {
        this.refreshIfEmpty();
        return this.delegate.contains(o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        this.refreshIfEmpty();
        return this.delegate.containsAll(collection);
    }
    
    @Override
    public void clear() {
        final int size = this.size();
        if (size == 0) {
            return;
        }
        this.delegate.clear();
        this.this$0.totalSize -= size;
        this.removeIfEmpty();
    }
    
    @Override
    public boolean remove(final Object o) {
        this.refreshIfEmpty();
        final boolean remove = this.delegate.remove(o);
        if (remove) {
            this.this$0.totalSize--;
            this.removeIfEmpty();
        }
        return remove;
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        final int size = this.size();
        final boolean removeAll = this.delegate.removeAll(collection);
        if (removeAll) {
            this.this$0.totalSize += this.delegate.size() - size;
            this.removeIfEmpty();
        }
        return removeAll;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        final int size = this.size();
        final boolean retainAll = this.delegate.retainAll(collection);
        if (retainAll) {
            this.this$0.totalSize += this.delegate.size() - size;
            this.removeIfEmpty();
        }
        return retainAll;
    }
}
