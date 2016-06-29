/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class ImmutableList$SubList
extends ImmutableList {
    final transient int offset;
    final transient int length;
    final /* synthetic */ ImmutableList this$0;

    ImmutableList$SubList(ImmutableList immutableList, int n2, int n3) {
        this.this$0 = immutableList;
        this.offset = n2;
        this.length = n3;
    }

    @Override
    public int size() {
        return this.length;
    }

    public Object get(int n2) {
        Preconditions.checkElementIndex(n2, this.length);
        return this.this$0.get(n2 + this.offset);
    }

    @Override
    public ImmutableList subList(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.length);
        return this.this$0.subList(n2 + this.offset, n3 + this.offset);
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

