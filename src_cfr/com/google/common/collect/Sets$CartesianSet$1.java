/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;

final class Sets$CartesianSet$1
extends ImmutableList {
    final /* synthetic */ ImmutableList val$axes;

    Sets$CartesianSet$1(ImmutableList immutableList) {
        this.val$axes = immutableList;
    }

    @Override
    public int size() {
        return this.val$axes.size();
    }

    public List get(int n2) {
        return ((ImmutableSet)this.val$axes.get(n2)).asList();
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

