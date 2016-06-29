/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ComparisonChain$1;
import com.google.common.collect.ComparisonChain$InactiveComparisonChain;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new ComparisonChain$1();
    private static final ComparisonChain LESS = new ComparisonChain$InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new ComparisonChain$InactiveComparisonChain(1);

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(Comparable var1, Comparable var2);

    public abstract ComparisonChain compare(@Nullable Object var1, @Nullable Object var2, Comparator var3);

    public abstract ComparisonChain compare(int var1, int var2);

    public abstract ComparisonChain compare(long var1, long var3);

    public abstract ComparisonChain compare(float var1, float var2);

    public abstract ComparisonChain compare(double var1, double var3);

    @Deprecated
    public final ComparisonChain compare(Boolean bl2, Boolean bl3) {
        return this.compareFalseFirst(bl2, bl3);
    }

    public abstract ComparisonChain compareTrueFirst(boolean var1, boolean var2);

    public abstract ComparisonChain compareFalseFirst(boolean var1, boolean var2);

    public abstract int result();

    /* synthetic */ ComparisonChain(ComparisonChain$1 comparisonChain$1) {
        this();
    }

    static /* synthetic */ ComparisonChain access$100() {
        return LESS;
    }

    static /* synthetic */ ComparisonChain access$200() {
        return GREATER;
    }

    static /* synthetic */ ComparisonChain access$300() {
        return ACTIVE;
    }
}

