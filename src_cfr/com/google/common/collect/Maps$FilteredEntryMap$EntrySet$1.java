/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

class Maps$FilteredEntryMap$EntrySet$1
extends TransformedIterator {
    final /* synthetic */ Maps$FilteredEntryMap$EntrySet this$1;

    Maps$FilteredEntryMap$EntrySet$1(Maps$FilteredEntryMap$EntrySet maps$FilteredEntryMap$EntrySet, Iterator iterator) {
        this.this$1 = maps$FilteredEntryMap$EntrySet;
        super(iterator);
    }

    Map.Entry transform(Map.Entry entry) {
        return new Maps$FilteredEntryMap$EntrySet$1$1(this, entry);
    }
}

