package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public abstract class Equivalence
{
    public final boolean equivalent(@Nullable final Object o, @Nullable final Object o2) {
        return o == o2 || (o != null && o2 != null && this.doEquivalent(o, o2));
    }
    
    protected abstract boolean doEquivalent(final Object p0, final Object p1);
    
    public final int hash(@Nullable final Object o) {
        if (o == null) {
            return 0;
        }
        return this.doHash(o);
    }
    
    protected abstract int doHash(final Object p0);
    
    public final Equivalence onResultOf(final Function function) {
        return new FunctionalEquivalence(function, this);
    }
    
    public final Equivalence$Wrapper wrap(@Nullable final Object o) {
        return new Equivalence$Wrapper(this, o, null);
    }
    
    @GwtCompatible(serializable = true)
    public final Equivalence pairwise() {
        return new PairwiseEquivalence(this);
    }
    
    @Beta
    public final Predicate equivalentTo(@Nullable final Object o) {
        return new Equivalence$EquivalentToPredicate(this, o);
    }
    
    public static Equivalence equals() {
        return Equivalence$Equals.INSTANCE;
    }
    
    public static Equivalence identity() {
        return Equivalence$Identity.INSTANCE;
    }
}
