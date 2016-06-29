/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multimaps$Keys$1$1;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

class Multimaps$Keys$1
extends TransformedIterator {
    final /* synthetic */ Multimaps$Keys this$0;

    Multimaps$Keys$1(Multimaps$Keys multimaps$Keys, Iterator iterator) {
        this.this$0 = multimaps$Keys;
        super(iterator);
    }

    Multiset$Entry transform(Map.Entry entry) {
        return new Multimaps$Keys$1$1(this, entry);
    }
}

