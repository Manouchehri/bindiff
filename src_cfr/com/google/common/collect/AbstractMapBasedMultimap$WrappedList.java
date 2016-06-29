/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList$WrappedListIterator;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedList
extends AbstractMapBasedMultimap$WrappedCollection
implements List {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$WrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable Object object, List list, @Nullable AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, list, abstractMapBasedMultimap$WrappedCollection);
    }

    List getListDelegate() {
        return (List)this.getDelegate();
    }

    public boolean addAll(int n2, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int n3 = this.size();
        boolean bl2 = this.getListDelegate().addAll(n2, collection);
        if (!bl2) return bl2;
        int n4 = this.getDelegate().size();
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (n4 - n3));
        if (n3 != 0) return bl2;
        this.addToMap();
        return bl2;
    }

    public Object get(int n2) {
        this.refreshIfEmpty();
        return this.getListDelegate().get(n2);
    }

    public Object set(int n2, Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().set(n2, object);
    }

    public void add(int n2, Object object) {
        this.refreshIfEmpty();
        boolean bl2 = this.getDelegate().isEmpty();
        this.getListDelegate().add(n2, object);
        AbstractMapBasedMultimap.access$208(this.this$0);
        if (!bl2) return;
        this.addToMap();
    }

    public Object remove(int n2) {
        this.refreshIfEmpty();
        Object e2 = this.getListDelegate().remove(n2);
        AbstractMapBasedMultimap.access$210(this.this$0);
        this.removeIfEmpty();
        return e2;
    }

    @Override
    public int indexOf(Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().lastIndexOf(object);
    }

    public ListIterator listIterator() {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this);
    }

    public ListIterator listIterator(int n2) {
        this.refreshIfEmpty();
        return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this, n2);
    }

    public List subList(int n2, int n3) {
        AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList /* !! */ ;
        this.refreshIfEmpty();
        if (this.getAncestor() == null) {
            abstractMapBasedMultimap$WrappedList /* !! */  = this;
            return AbstractMapBasedMultimap.access$300(this.this$0, this.getKey(), this.getListDelegate().subList(n2, n3), abstractMapBasedMultimap$WrappedList /* !! */ );
        }
        abstractMapBasedMultimap$WrappedList /* !! */  = this.getAncestor();
        return AbstractMapBasedMultimap.access$300(this.this$0, this.getKey(), this.getListDelegate().subList(n2, n3), abstractMapBasedMultimap$WrappedList /* !! */ );
    }
}

