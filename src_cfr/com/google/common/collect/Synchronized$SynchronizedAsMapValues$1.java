/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues;
import com.google.common.collect.TransformedIterator;
import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1
extends TransformedIterator {
    final /* synthetic */ Synchronized$SynchronizedAsMapValues this$0;

    Synchronized$SynchronizedAsMapValues$1(Synchronized$SynchronizedAsMapValues synchronized$SynchronizedAsMapValues, Iterator iterator) {
        this.this$0 = synchronized$SynchronizedAsMapValues;
        super(iterator);
    }

    Collection transform(Collection collection) {
        return Synchronized.access$400(collection, this.this$0.mutex);
    }
}

