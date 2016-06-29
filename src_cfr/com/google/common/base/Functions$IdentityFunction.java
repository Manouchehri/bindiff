/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import javax.annotation.Nullable;

enum Functions$IdentityFunction implements Function
{
    INSTANCE;
    

    private Functions$IdentityFunction() {
    }

    @Nullable
    @Override
    public Object apply(@Nullable Object object) {
        return object;
    }

    public String toString() {
        return "Functions.identity()";
    }
}

