/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedAsMapValues;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class MapConstraints$ConstrainedAsMapValues$1
implements Iterator {
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ MapConstraints.ConstrainedAsMapValues this$0;

    MapConstraints$ConstrainedAsMapValues$1(MapConstraints.ConstrainedAsMapValues constrainedAsMapValues, Iterator iterator) {
        this.this$0 = constrainedAsMapValues;
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Collection next() {
        return (Collection)((Map.Entry)this.val$iterator.next()).getValue();
    }

    @Override
    public void remove() {
        this.val$iterator.remove();
    }
}

