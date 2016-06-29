/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class ImmutableList$ReverseImmutableList
extends ImmutableList {
    private final transient ImmutableList forwardList;

    ImmutableList$ReverseImmutableList(ImmutableList immutableList) {
        this.forwardList = immutableList;
    }

    private int reverseIndex(int n2) {
        return this.size() - 1 - n2;
    }

    private int reversePosition(int n2) {
        return this.size() - n2;
    }

    @Override
    public ImmutableList reverse() {
        return this.forwardList;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.forwardList.contains(object);
    }

    @Override
    public int indexOf(@Nullable Object object) {
        int n2 = this.forwardList.lastIndexOf(object);
        if (n2 < 0) return -1;
        int n3 = this.reverseIndex(n2);
        return n3;
    }

    @Override
    public int lastIndexOf(@Nullable Object object) {
        int n2 = this.forwardList.indexOf(object);
        if (n2 < 0) return -1;
        int n3 = this.reverseIndex(n2);
        return n3;
    }

    @Override
    public ImmutableList subList(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.size());
        return this.forwardList.subList(this.reversePosition(n3), this.reversePosition(n2)).reverse();
    }

    public Object get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return this.forwardList.get(this.reverseIndex(n2));
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

