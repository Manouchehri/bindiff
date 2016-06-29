/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1;
import java.util.Iterator;

class Converter$1$1
implements Iterator {
    private final Iterator fromIterator;
    final /* synthetic */ Converter$1 this$1;

    Converter$1$1(Converter$1 converter$1) {
        this.this$1 = converter$1;
        this.fromIterator = this.this$1.val$fromIterable.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.fromIterator.hasNext();
    }

    public Object next() {
        return this.this$1.this$0.convert(this.fromIterator.next());
    }

    @Override
    public void remove() {
        this.fromIterator.remove();
    }
}

