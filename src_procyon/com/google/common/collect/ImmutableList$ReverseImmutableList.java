package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class ImmutableList$ReverseImmutableList extends ImmutableList
{
    private final transient ImmutableList forwardList;
    
    ImmutableList$ReverseImmutableList(final ImmutableList forwardList) {
        this.forwardList = forwardList;
    }
    
    private int reverseIndex(final int n) {
        return this.size() - 1 - n;
    }
    
    private int reversePosition(final int n) {
        return this.size() - n;
    }
    
    @Override
    public ImmutableList reverse() {
        return this.forwardList;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.forwardList.contains(o);
    }
    
    @Override
    public int indexOf(@Nullable final Object o) {
        final int lastIndex = this.forwardList.lastIndexOf(o);
        return (lastIndex >= 0) ? this.reverseIndex(lastIndex) : -1;
    }
    
    @Override
    public int lastIndexOf(@Nullable final Object o) {
        final int index = this.forwardList.indexOf(o);
        return (index >= 0) ? this.reverseIndex(index) : -1;
    }
    
    @Override
    public ImmutableList subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        return this.forwardList.subList(this.reversePosition(n2), this.reversePosition(n)).reverse();
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.forwardList.get(this.reverseIndex(n));
    }
    
    @Override
    public int size() {
        return this.forwardList.size();
    }
    
    @Override
    boolean isPartialView() {
        return this.forwardList.isPartialView();
    }
}
