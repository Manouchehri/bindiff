/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$2;

class MapConstraints$2$1
implements Constraint {
    final /* synthetic */ MapConstraints$2 this$0;

    MapConstraints$2$1(MapConstraints$2 var1_1) {
        this.this$0 = var1_1;
    }

    @Override
    public Object checkElement(Object object) {
        this.this$0.val$constraint.checkKeyValue(this.this$0.getKey(), object);
        return object;
    }
}

