/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class FunctionalEquivalence
extends Equivalence
implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function function;
    private final Equivalence resultEquivalence;

    FunctionalEquivalence(Function function, Equivalence equivalence) {
        this.function = (Function)Preconditions.checkNotNull(function);
        this.resultEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
    }

    @Override
    protected boolean doEquivalent(Object object, Object object2) {
        return this.resultEquivalence.equivalent(this.function.apply(object), this.function.apply(object2));
    }

    @Override
    protected int doHash(Object object) {
        return this.resultEquivalence.hash(this.function.apply(object));
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof FunctionalEquivalence)) return false;
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence)object;
        if (!this.function.equals(functionalEquivalence.function)) return false;
        if (!this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.resultEquivalence);
    }

    public String toString() {
        String string = String.valueOf(this.resultEquivalence);
        String string2 = String.valueOf(this.function);
        return new StringBuilder(13 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".onResultOf(").append(string2).append(")").toString();
    }
}

