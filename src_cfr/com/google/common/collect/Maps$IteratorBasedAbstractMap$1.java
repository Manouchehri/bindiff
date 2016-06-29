/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map;

class Maps$IteratorBasedAbstractMap$1
extends Maps$EntrySet {
    final /* synthetic */ Maps$IteratorBasedAbstractMap this$0;

    Maps$IteratorBasedAbstractMap$1(Maps$IteratorBasedAbstractMap maps$IteratorBasedAbstractMap) {
        this.this$0 = maps$IteratorBasedAbstractMap;
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

