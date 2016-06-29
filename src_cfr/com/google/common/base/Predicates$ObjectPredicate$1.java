/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$ObjectPredicate;
import javax.annotation.Nullable;

final class Predicates$ObjectPredicate$1
extends Predicates$ObjectPredicate {
    Predicates$ObjectPredicate$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        return true;
    }

    public String toString() {
        return "Predicates.alwaysTrue()";
    }
}

