/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.WellBehavedMap;
import com.google.common.collect.WellBehavedMap$1;
import com.google.common.collect.WellBehavedMap$EntrySet$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class WellBehavedMap$EntrySet
extends Maps$EntrySet {
    final /* synthetic */ WellBehavedMap this$0;

    private WellBehavedMap$EntrySet(WellBehavedMap wellBehavedMap) {
        this.this$0 = wellBehavedMap;
    }

    @Override
    Map map() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return new WellBehavedMap$EntrySet$1(this, this.this$0.keySet().iterator());
    }

    /* synthetic */ WellBehavedMap$EntrySet(WellBehavedMap wellBehavedMap, WellBehavedMap$1 wellBehavedMap$1) {
        this(wellBehavedMap);
    }
}

