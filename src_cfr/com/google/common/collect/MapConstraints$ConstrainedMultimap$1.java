/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;

class MapConstraints$ConstrainedMultimap$1
implements Constraint {
    final /* synthetic */ Object val$key;
    final /* synthetic */ MapConstraints$ConstrainedMultimap this$0;

    MapConstraints$ConstrainedMultimap$1(MapConstraints$ConstrainedMultimap mapConstraints$ConstrainedMultimap, Object object) {
        this.this$0 = mapConstraints$ConstrainedMultimap;
        this.val$key = object;
    }

    @Override
    public Object checkElement(Object object) {
        this.this$0.constraint.checkKeyValue(this.val$key, object);
        return object;
    }
}

