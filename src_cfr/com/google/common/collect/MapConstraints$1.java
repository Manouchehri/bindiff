/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.MapConstraint;
import java.util.Map;

final class MapConstraints$1
extends ForwardingMapEntry {
    final /* synthetic */ Map.Entry val$entry;
    final /* synthetic */ MapConstraint val$constraint;

    MapConstraints$1(Map.Entry entry, MapConstraint mapConstraint) {
        this.val$entry = entry;
        this.val$constraint = mapConstraint;
    }

    @Override
    protected Map.Entry delegate() {
        return this.val$entry;
    }

    @Override
    public Object setValue(Object object) {
        this.val$constraint.checkKeyValue(this.getKey(), object);
        return this.val$entry.setValue(object);
    }
}

