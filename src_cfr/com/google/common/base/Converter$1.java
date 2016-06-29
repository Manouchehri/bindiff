/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1$1;
import java.util.Iterator;

class Converter$1
implements Iterable {
    final /* synthetic */ Iterable val$fromIterable;
    final /* synthetic */ Converter this$0;

    Converter$1(Converter converter, Iterable iterable) {
        this.this$0 = converter;
        this.val$fromIterable = iterable;
    }

    public Iterator iterator() {
        return new Converter$1$1(this);
    }
}

