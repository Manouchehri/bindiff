/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$AsMapView$1EntrySetImpl
extends Maps$EntrySet {
    final /* synthetic */ Maps$AsMapView this$0;

    Maps$AsMapView$1EntrySetImpl(Maps$AsMapView asMapView) {
        this.this$0 = asMapView;
    }

    @Override
    Map map() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$0.backingSet(), this.this$0.function);
    }
}

