/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.Range;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public interface RangeMap {
    @Nullable
    public Object get(Comparable var1);

    @Nullable
    public Map.Entry getEntry(Comparable var1);

    public Range span();

    public void put(Range var1, Object var2);

    public void putAll(RangeMap var1);

    public void clear();

    public void remove(Range var1);

    public Map asMapOfRanges();

    public Map asDescendingMapOfRanges();

    public RangeMap subRangeMap(Range var1);

    public boolean equals(@Nullable Object var1);

    public int hashCode();

    public String toString();
}

