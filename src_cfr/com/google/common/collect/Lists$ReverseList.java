/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Lists$ReverseList$1;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Lists$ReverseList
extends AbstractList {
    private final List forwardList;

    Lists$ReverseList(List list) {
        this.forwardList = (List)Preconditions.checkNotNull(list);
    }

    List getForwardList() {
        return this.forwardList;
    }

    private int reverseIndex(int n2) {
        int n3 = this.size();
        Preconditions.checkElementIndex(n2, n3);
        return n3 - 1 - n2;
    }

    private int reversePosition(int n2) {
        int n3 = this.size();
        Preconditions.checkPositionIndex(n2, n3);
        return n3 - n2;
    }

    @Override
    public void add(int n2, @Nullable Object object) {
        this.forwardList.add(this.reversePosition(n2), object);
    }

    @Override
    public void clear() {
        this.forwardList.clear();
    }

    @Override
    public Object remove(int n2) {
        return this.forwardList.remove(this.reverseIndex(n2));
    }

    @Override
    protected void removeRange(int n2, int n3) {
        this.subList(n2, n3).clear();
    }

    @Override
    public Object set(int n2, @Nullable Object object) {
        return this.forwardList.set(this.reverseIndex(n2), object);
    }

    @Override
    public Object get(int n2) {
        return this.forwardList.get(this.reverseIndex(n2));
    }

    @Override
    public int size() {
        return this.forwardList.size();
    }

    @Override
    public List subList(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.size());
        return Lists.reverse(this.forwardList.subList(this.reversePosition(n3), this.reversePosition(n2)));
    }

    @Override
    public Iterator iterator() {
        return this.listIterator();
    }

    @Override
    public ListIterator listIterator(int n2) {
        int n3 = this.reversePosition(n2);
        ListIterator listIterator = this.forwardList.listIterator(n3);
        return new Lists$ReverseList$1(this, listIterator);
    }

    static /* synthetic */ int access$000(Lists$ReverseList lists$ReverseList, int n2) {
        return lists$ReverseList.reversePosition(n2);
    }
}

