package com.google.common.collect;

import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedList extends AbstractMapBasedMultimap$WrappedCollection implements List
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$WrappedList(final AbstractMapBasedMultimap this$0, @Nullable final Object o, final List list, @Nullable final AbstractMapBasedMultimap$WrappedCollection collection) {
        this.this$0 = this$0;
        super(this$0, o, list, collection);
    }
    
    List getListDelegate() {
        return (List)this.getDelegate();
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        final int size = this.size();
        final boolean addAll = this.getListDelegate().addAll(n, collection);
        if (addAll) {
            this.this$0.totalSize += this.getDelegate().size() - size;
            if (size == 0) {
                this.addToMap();
            }
        }
        return addAll;
    }
    
    @Override
    public Object get(final int n) {
        this.refreshIfEmpty();
        return this.getListDelegate().get(n);
    }
    
    @Override
    public Object set(final int n, final Object o) {
        this.refreshIfEmpty();
        return this.getListDelegate().set(n, o);
    }
    
    @Override
    public void add(final int n, final Object o) {
        this.refreshIfEmpty();
        final boolean empty = this.getDelegate().isEmpty();
        this.getListDelegate().add(n, o);
        this.this$0.totalSize++;
        if (empty) {
            this.addToMap();
        }
    }
    
    @Override
    public Object remove(final int n) {
        this.refreshIfEmpty();
        final Object remove = this.getListDelegate().remove(n);
        this.this$0.totalSize--;
        this.removeIfEmpty();
        return remove;
    }
    
    @Override
    public int indexOf(final Object o) {
        this.refreshIfEmpty();
        return this.getListDelegate().indexOf(o);
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        this.refreshIfEmpty();
        return this.getListDelegate().lastIndexOf(o);
    }
    
    @Override
    public ListIterator listIterator() {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this);
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this, n);
    }
    
    @Override
    public List subList(final int n, final int n2) {
        this.refreshIfEmpty();
        return this.this$0.wrapList(this.getKey(), this.getListDelegate().subList(n, n2), (this.getAncestor() == null) ? this : this.getAncestor());
    }
}
