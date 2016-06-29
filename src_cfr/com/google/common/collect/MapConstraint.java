/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Deprecated
@GwtCompatible
@Beta
public interface MapConstraint {
    public void checkKeyValue(@Nullable Object var1, @Nullable Object var2);

    public String toString();
}

