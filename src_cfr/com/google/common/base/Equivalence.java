/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence$1;
import com.google.common.base.Equivalence$Equals;
import com.google.common.base.Equivalence$EquivalentToPredicate;
import com.google.common.base.Equivalence$Identity;
import com.google.common.base.Equivalence$Wrapper;
import com.google.common.base.Function;
import com.google.common.base.FunctionalEquivalence;
import com.google.common.base.PairwiseEquivalence;
import com.google.common.base.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public abstract class Equivalence {
    protected Equivalence() {
    }

    public final boolean equivalent(@Nullable Object object, @Nullable Object object2) {
        if (object == object2) {
            return true;
        }
        if (object == null) return false;
        if (object2 != null) return this.doEquivalent(object, object2);
        return false;
    }

    protected abstract boolean doEquivalent(Object var1, Object var2);

    public final int hash(@Nullable Object object) {
        if (object != null) return this.doHash(object);
        return 0;
    }

    protected abstract int doHash(Object var1);

    public final Equivalence onResultOf(Function function) {
        return new FunctionalEquivalence(function, this);
    }

    public final Equivalence$Wrapper wrap(@Nullable Object object) {
        return new Equivalence$Wrapper(this, object, null);
    }

    @GwtCompatible(serializable=1)
    public final Equivalence pairwise() {
        return new PairwiseEquivalence(this);
    }

    @Beta
    public final Predicate equivalentTo(@Nullable Object object) {
        return new Equivalence$EquivalentToPredicate(this, object);
    }

    public static Equivalence equals() {
        return Equivalence$Equals.INSTANCE;
    }

    public static Equivalence identity() {
        return Equivalence$Identity.INSTANCE;
    }
}

