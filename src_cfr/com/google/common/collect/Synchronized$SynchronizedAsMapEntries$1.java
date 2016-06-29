/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

class Synchronized$SynchronizedAsMapEntries$1
extends TransformedIterator {
    final /* synthetic */ Synchronized$SynchronizedAsMapEntries this$0;

    Synchronized$SynchronizedAsMapEntries$1(Synchronized$SynchronizedAsMapEntries synchronized$SynchronizedAsMapEntries, Iterator iterator) {
        this.this$0 = synchronized$SynchronizedAsMapEntries;
        super(iterator);
    }

    Map.Entry transform(Map.Entry entry) {
        return new Synchronized$SynchronizedAsMapEntries$1$1(this, entry);
    }
}

