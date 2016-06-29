package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
public abstract class ForwardingSortedSet extends ForwardingSet implements SortedSet
{
    @Override
    protected abstract SortedSet delegate();
    
    @Override
    public Comparator comparator() {
        return this.delegate().comparator();
    }
    
    @Override
    public Object first() {
        return this.delegate().first();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return this.delegate().headSet(o);
    }
    
    @Override
    public Object last() {
        return this.delegate().last();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return this.delegate().subSet(o, o2);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return this.delegate().tailSet(o);
    }
    
    private int unsafeCompare(final Object o, final Object o2) {
        final Comparator comparator = this.comparator();
        return (comparator == null) ? ((Comparable)o).compareTo(o2) : comparator.compare(o, o2);
    }
    
    @Beta
    @Override
    protected boolean standardContains(@Nullable final Object o) {
        try {
            return this.unsafeCompare(super.tailSet(o).first(), o) == 0;
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NoSuchElementException ex2) {
            return false;
        }
        catch (NullPointerException ex3) {
            return false;
        }
    }
    
    @Beta
    @Override
    protected boolean standardRemove(@Nullable final Object o) {
        try {
            final Iterator<Object> iterator = super.tailSet(o).iterator();
            if (iterator.hasNext() && this.unsafeCompare(iterator.next(), o) == 0) {
                iterator.remove();
                return true;
            }
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
        return false;
    }
    
    @Beta
    protected SortedSet standardSubSet(final Object o, final Object o2) {
        return this.tailSet(o).headSet(o2);
    }
}
