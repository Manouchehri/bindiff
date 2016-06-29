/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

class MapConstraints$ConstrainedAsMapEntries$1
extends TransformedIterator {
    final /* synthetic */ MapConstraints$ConstrainedAsMapEntries this$0;

    MapConstraints$ConstrainedAsMapEntries$1(MapConstraints$ConstrainedAsMapEntries constrainedAsMapEntries, Iterator iterator) {
        this.this$0 = constrainedAsMapEntries;
        super(iterator);
    }

    Map.Entry transform(Map.Entry entry) {
        return MapConstraints.access$700(entry, MapConstraints$ConstrainedAsMapEntries.access$600(this.this$0));
    }
}

