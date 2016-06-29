/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$DescendingMap;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

class Maps$DescendingMap$1EntrySetImpl
extends Maps$EntrySet {
    final /* synthetic */ Maps$DescendingMap this$0;

    Maps$DescendingMap$1EntrySetImpl(Maps$DescendingMap maps$DescendingMap) {
        this.this$0 = maps$DescendingMap;
    }

    @Override
    Map map() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }
}

