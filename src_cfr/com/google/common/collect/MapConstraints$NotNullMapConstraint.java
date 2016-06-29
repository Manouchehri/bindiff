/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapConstraint;

enum MapConstraints$NotNullMapConstraint implements MapConstraint
{
    INSTANCE;
    

    private MapConstraints$NotNullMapConstraint() {
    }

    @Override
    public void checkKeyValue(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
    }

    @Override
    public String toString() {
        return "Not null";
    }
}

