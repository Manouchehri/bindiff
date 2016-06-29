/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Striped;
import com.google.common.util.concurrent.Striped$1;

abstract class Striped$PowerOfTwoStriped
extends Striped {
    final int mask;

    Striped$PowerOfTwoStriped(int n2) {
        super(null);
        Preconditions.checkArgument(n2 > 0, "Stripes must be positive");
        this.mask = n2 > 1073741824 ? -1 : Striped.access$200(n2) - 1;
    }

    @Override
    final int indexFor(Object object) {
        int n2 = Striped.access$300(object.hashCode());
        return n2 & this.mask;
    }

    @Override
    public final Object get(Object object) {
        return this.getAt(this.indexFor(object));
    }
}

