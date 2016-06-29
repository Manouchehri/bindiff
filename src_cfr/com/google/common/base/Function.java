/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface Function {
    @Nullable
    public Object apply(@Nullable Object var1);

    public boolean equals(@Nullable Object var1);
}

