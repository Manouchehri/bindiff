/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import javax.annotation.Nullable;

public interface Table$Cell {
    @Nullable
    public Object getRowKey();

    @Nullable
    public Object getColumnKey();

    @Nullable
    public Object getValue();

    public boolean equals(@Nullable Object var1);

    public int hashCode();
}

