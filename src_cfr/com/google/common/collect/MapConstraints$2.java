/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Constraints;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$2$1;
import java.util.Collection;
import java.util.Map;

final class MapConstraints$2
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ MapConstraint val$constraint;

    MapConstraints$2(Map.Entry entry, MapConstraint mapConstraint) {
        this.val$entry = entry;
        this.val$constraint = mapConstraint;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$entry;
    }

    @Override
    public Collection getValue() {
        return Constraints.constrainedTypePreservingCollection((Collection)this.val$entry.getValue(), new MapConstraints$2$1(this));
    }
}

