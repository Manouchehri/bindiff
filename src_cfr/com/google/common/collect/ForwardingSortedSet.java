/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSet
extends ForwardingSet
implements SortedSet {
    protected ForwardingSortedSet() {
    }

    @Override
    protected abstract SortedSet delegate();

    public Comparator comparator() {
        return this.delegate().comparator();
    }

    public Object first() {
        return this.delegate().first();
    }

    public SortedSet headSet(Object object) {
        return this.delegate().headSet(object);
    }

    public Object last() {
        return this.delegate().last();
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.delegate().subSet(object, object2);
    }

    public SortedSet tailSet(Object object) {
        return this.delegate().tailSet(object);
    }

    private int unsafeCompare(Object object, Object object2) {
        int n2;
        Comparator comparator = this.comparator();
        if (comparator == null) {
            n2 = ((Comparable)object).compareTo(object2);
            return n2;
        }
        n2 = comparator.compare(object, object2);
        return n2;
    }

    @Beta
    @Override
    protected boolean standardContains(@Nullable Object object) {
        try {
            ForwardingSortedSet forwardingSortedSet = this;
            Object object2 = forwardingSortedSet.tailSet(object).first();
            if (this.unsafeCompare(object2, object) != 0) return false;
            return true;
        }
        catch (ClassCastException var2_3) {
            return false;
        }
        catch (NoSuchElementException var2_4) {
            return false;
        }
        catch (NullPointerException var2_5) {
            return false;
        }
    }

    @Beta
    @Override
    protected boolean standardRemove(@Nullable Object object) {
        try {
            ForwardingSortedSet forwardingSortedSet = this;
            Iterator<Object> iterator = forwardingSortedSet.tailSet(object).iterator();
            if (!iterator.hasNext()) return false;
            Object object2 = iterator.next();
            if (this.unsafeCompare(object2, object) != 0) return false;
            iterator.remove();
            return true;
        }
        catch (ClassCastException var2_3) {
            return false;
        }
        catch (NullPointerException var2_4) {
            return false;
        }
    }

    @Beta
    protected SortedSet standardSubSet(Object object, Object object2) {
        return this.tailSet(object).headSet(object2);
    }
}

