/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.AbstractNavigableMap$1;
import com.google.common.collect.Maps$DescendingMap;
import java.util.Iterator;
import java.util.NavigableMap;

final class AbstractNavigableMap$DescendingMap
extends Maps$DescendingMap {
    final /* synthetic */ AbstractNavigableMap this$0;

    private AbstractNavigableMap$DescendingMap(AbstractNavigableMap abstractNavigableMap) {
        this.this$0 = abstractNavigableMap;
    }

    @Override
    NavigableMap forward() {
        return this.this$0;
    }

    @Override
    Iterator entryIterator() {
        return this.this$0.descendingEntryIterator();
    }

    /* synthetic */ AbstractNavigableMap$DescendingMap(AbstractNavigableMap abstractNavigableMap, AbstractNavigableMap$1 abstractNavigableMap$1) {
        this(abstractNavigableMap);
    }
}

