/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapConstraint;

class MapConstraints$InverseConstraint
implements MapConstraint {
    final MapConstraint constraint;

    public MapConstraints$InverseConstraint(MapConstraint mapConstraint) {
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }

    @Override
    public void checkKeyValue(Object object, Object object2) {
        this.constraint.checkKeyValue(object2, object);
    }
}

