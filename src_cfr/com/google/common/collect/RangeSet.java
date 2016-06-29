/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.Range;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public interface RangeSet {
    public boolean contains(Comparable var1);

    public Range rangeContaining(Comparable var1);

    public boolean encloses(Range var1);

    public boolean enclosesAll(RangeSet var1);

    public boolean isEmpty();

    public Range span();

    public Set asRanges();

    public Set asDescendingSetOfRanges();

    public RangeSet complement();

    public RangeSet subRangeSet(Range var1);

    public void add(Range var1);

    public void remove(Range var1);

    public void clear();

    public void addAll(RangeSet var1);

    public void removeAll(RangeSet var1);

    public boolean equals(@Nullable Object var1);

    public int hashCode();

    public String toString();
}

