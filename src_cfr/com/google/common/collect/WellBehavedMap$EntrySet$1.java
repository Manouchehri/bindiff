/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.TransformedIterator;
import com.google.common.collect.WellBehavedMap$EntrySet;
import com.google.common.collect.WellBehavedMap$EntrySet$1$1;
import java.util.Iterator;
import java.util.Map;

class WellBehavedMap$EntrySet$1
extends TransformedIterator {
    final /* synthetic */ WellBehavedMap$EntrySet this$1;

    WellBehavedMap$EntrySet$1(WellBehavedMap$EntrySet wellBehavedMap$EntrySet, Iterator iterator) {
        this.this$1 = wellBehavedMap$EntrySet;
        super(iterator);
    }

    @Override
    Map.Entry transform(Object object) {
        return new WellBehavedMap$EntrySet$1$1(this, object);
    }
}

