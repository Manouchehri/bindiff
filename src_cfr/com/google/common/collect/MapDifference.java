/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public interface MapDifference {
    public boolean areEqual();

    public Map entriesOnlyOnLeft();

    public Map entriesOnlyOnRight();

    public Map entriesInCommon();

    public Map entriesDiffering();

    public boolean equals(@Nullable Object var1);

    public int hashCode();
}

