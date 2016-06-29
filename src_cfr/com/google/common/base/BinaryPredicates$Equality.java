/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

enum BinaryPredicates$Equality implements BinaryPredicate
{
    Equality;
    

    private BinaryPredicates$Equality() {
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        return Objects.equal(object, object2);
    }
}

