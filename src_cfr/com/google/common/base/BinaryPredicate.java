/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GoogleInternal
@GwtCompatible
public interface BinaryPredicate {
    public boolean apply(@Nullable Object var1, @Nullable Object var2);
}

