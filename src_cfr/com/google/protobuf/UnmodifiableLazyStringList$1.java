/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ListIterator;

class UnmodifiableLazyStringList$1
implements ListIterator {
    ListIterator iter;
    final /* synthetic */ int val$index;
    final /* synthetic */ UnmodifiableLazyStringList this$0;

    UnmodifiableLazyStringList$1(UnmodifiableLazyStringList unmodifiableLazyStringList, int n2) {
        this.this$0 = unmodifiableLazyStringList;
        this.val$index = n2;
        this.iter = UnmodifiableLazyStringList.access$000(this.this$0).listIterator(this.val$index);
    }

    @Override
    public boolean hasNext() {
        return this.iter.hasNext();
    }

    @Override
    public String next() {
        return (String)this.iter.next();
    }

    @Override
    public boolean hasPrevious() {
        return this.iter.hasPrevious();
    }

    public String previous() {
        return (String)this.iter.previous();
    }

    @Override
    public int nextIndex() {
        return this.iter.nextIndex();
    }

    @Override
    public int previousIndex() {
        return this.iter.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void set(String string) {
        throw new UnsupportedOperationException();
    }

    public void add(String string) {
        throw new UnsupportedOperationException();
    }
}

