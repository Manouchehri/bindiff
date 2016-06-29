/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import javax.annotation.Nullable;

public interface MapDifference$ValueDifference {
    public Object leftValue();

    public Object rightValue();

    public boolean equals(@Nullable Object var1);

    public int hashCode();
}

