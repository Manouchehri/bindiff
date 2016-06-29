/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Iterator;

class UnmodifiableLazyStringList$2
implements Iterator {
    Iterator iter;
    final /* synthetic */ UnmodifiableLazyStringList this$0;

    UnmodifiableLazyStringList$2(UnmodifiableLazyStringList unmodifiableLazyStringList) {
        this.this$0 = unmodifiableLazyStringList;
        this.iter = UnmodifiableLazyStringList.access$000(this.this$0).iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iter.hasNext();
    }

    public String next() {
        return (String)this.iter.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

