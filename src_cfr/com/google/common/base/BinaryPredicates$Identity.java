/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import javax.annotation.Nullable;

enum BinaryPredicates$Identity implements BinaryPredicate
{
    Identity;
    

    private BinaryPredicates$Identity() {
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        if (object != object2) return false;
        return true;
    }
}

