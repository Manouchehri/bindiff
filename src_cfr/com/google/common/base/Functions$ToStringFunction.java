/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

enum Functions$ToStringFunction implements Function
{
    INSTANCE;
    

    private Functions$ToStringFunction() {
    }

    @Override
    public String apply(Object object) {
        Preconditions.checkNotNull(object);
        return object.toString();
    }

    public String toString() {
        return "Functions.toStringFunction()";
    }
}

