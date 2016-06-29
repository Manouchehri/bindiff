/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

class MapConstraints$ConstrainedEntries$1
extends TransformedIterator {
    final /* synthetic */ MapConstraints$ConstrainedEntries this$0;

    MapConstraints$ConstrainedEntries$1(MapConstraints$ConstrainedEntries constrainedEntries, Iterator iterator) {
        this.this$0 = constrainedEntries;
        super(iterator);
    }

    Map.Entry transform(Map.Entry entry) {
        return MapConstraints.access$500(entry, this.this$0.constraint);
    }
}

