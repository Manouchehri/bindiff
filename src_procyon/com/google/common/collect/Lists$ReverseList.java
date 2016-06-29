package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Lists$ReverseList extends AbstractList
{
    private final List forwardList;
    
    Lists$ReverseList(final List list) {
        this.forwardList = (List)Preconditions.checkNotNull(list);
    }
    
    List getForwardList() {
        return this.forwardList;
    }
    
    private int reverseIndex(final int n) {
        final int size = this.size();
        Preconditions.checkElementIndex(n, size);
        return size - 1 - n;
    }
    
    private int reversePosition(final int n) {
        final int size = this.size();
        Preconditions.checkPositionIndex(n, size);
        return size - n;
    }
    
    @Override
    public void add(final int n, @Nullable final Object o) {
        this.forwardList.add(this.reversePosition(n), o);
    }
    
    @Override
    public void clear() {
        this.forwardList.clear();
    }
    
    @Override
    public Object remove(final int n) {
        return this.forwardList.remove(this.reverseIndex(n));
    }
    
    @Override
    protected void removeRange(final int n, final int n2) {
        this.subList(n, n2).clear();
    }
    
    @Override
    public Object set(final int n, @Nullable final Object o) {
        return this.forwardList.set(this.reverseIndex(n), o);
    }
    
    @Override
    public Object get(final int n) {
        return this.forwardList.get(this.reverseIndex(n));
    }
    
    @Override
    public int size() {
        return this.forwardList.size();
    }
    
    @Override
    public List subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        return Lists.reverse(this.forwardList.subList(this.reversePosition(n2), this.reversePosition(n)));
    }
    
    @Override
    public Iterator iterator() {
        return this.listIterator();
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return new Lists$ReverseList$1(this, this.forwardList.listIterator(this.reversePosition(n)));
    }
}
