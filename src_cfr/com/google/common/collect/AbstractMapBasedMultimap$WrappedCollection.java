/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedCollection
extends AbstractCollection {
    final Object key;
    Collection delegate;
    final AbstractMapBasedMultimap$WrappedCollection ancestor;
    final Collection ancestorDelegate;
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$WrappedCollection(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, Collection collection, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        this.key = object;
        this.delegate = collection;
        this.ancestor = abstractMapBasedMultimap$WrappedCollection;
        this.ancestorDelegate = abstractMapBasedMultimap$WrappedCollection == null ? null : abstractMapBasedMultimap$WrappedCollection.getDelegate();
    }

    void refreshIfEmpty() {
        if (this.ancestor != null) {
            this.ancestor.refreshIfEmpty();
            if (this.ancestor.getDelegate() == this.ancestorDelegate) return;
            throw new ConcurrentModificationException();
        }
        if (!this.delegate.isEmpty()) return;
        Collection collection = (Collection)AbstractMapBasedMultimap.access$000(this.this$0).get(this.key);
        if (collection == null) return;
        this.delegate = collection;
    }

    void removeIfEmpty() {
        if (this.ancestor != null) {
            this.ancestor.removeIfEmpty();
            return;
        }
        if (!this.delegate.isEmpty()) return;
        AbstractMapBasedMultimap.access$000(this.this$0).remove(this.key);
    }

    Object getKey() {
        return this.key;
    }

    void addToMap() {
        if (this.ancestor != null) {
            this.ancestor.addToMap();
            return;
        }
        AbstractMapBasedMultimap.access$000(this.this$0).put(this.key, this.delegate);
    }

    @Override
    public int size() {
        this.refreshIfEmpty();
        return this.delegate.size();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        this.refreshIfEmpty();
        return this.delegate.equals(object);
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
    public boolean add(Object object) {
        this.refreshIfEmpty();
        boolean bl2 = this.delegate.isEmpty();
        boolean bl3 = this.delegate.add(object);
        if (!bl3) return bl3;
        AbstractMapBasedMultimap.access$208(this.this$0);
        if (!bl2) return bl3;
        this.addToMap();
        return bl3;
    }

    AbstractMapBasedMultimap$WrappedCollection getAncestor() {
        return this.ancestor;
    }

    @Override
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int n2 = this.size();
        boolean bl2 = this.delegate.addAll(collection);
        if (!bl2) return bl2;
        int n3 = this.delegate.size();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (n3 - n2));
        if (n2 != 0) return bl2;
        this.addToMap();
        return bl2;
    }

    @Override
    public boolean contains(Object object) {
        this.refreshIfEmpty();
        return this.delegate.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        this.refreshIfEmpty();
        return this.delegate.containsAll(collection);
    }

    @Override
    public void clear() {
        int n2 = this.size();
        if (n2 == 0) {
            return;
        }
        this.delegate.clear();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - n2);
        this.removeIfEmpty();
    }

    @Override
    public boolean remove(Object object) {
        this.refreshIfEmpty();
        boolean bl2 = this.delegate.remove(object);
        if (!bl2) return bl2;
        AbstractMapBasedMultimap.access$210(this.this$0);
        this.removeIfEmpty();
        return bl2;
    }

    @Override
    public boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int n2 = this.size();
        boolean bl2 = this.delegate.removeAll(collection);
        if (!bl2) return bl2;
        int n3 = this.delegate.size();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (n3 - n2));
        this.removeIfEmpty();
        return bl2;
    }

    @Override
    public boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        int n2 = this.size();
        boolean bl2 = this.delegate.retainAll(collection);
        if (!bl2) return bl2;
        int n3 = this.delegate.size();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (n3 - n2));
        this.removeIfEmpty();
        return bl2;
    }
}

