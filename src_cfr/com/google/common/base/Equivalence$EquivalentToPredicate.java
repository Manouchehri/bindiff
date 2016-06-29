/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Equivalence$EquivalentToPredicate
implements Predicate,
Serializable {
    private final Equivalence equivalence;
    @Nullable
    private final Object target;
    private static final long serialVersionUID = 0;

    Equivalence$EquivalentToPredicate(Equivalence equivalence, @Nullable Object object) {
        this.equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.target = object;
    }

    @Override
    public boolean apply(@Nullable Object object) {
        return this.equivalence.equivalent(object, this.target);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Equivalence$EquivalentToPredicate)) return false;
        Equivalence$EquivalentToPredicate equivalence$EquivalentToPredicate = (Equivalence$EquivalentToPredicate)object;
        if (!this.equivalence.equals(equivalence$EquivalentToPredicate.equivalence)) return false;
        if (!Objects.equal(this.target, equivalence$EquivalentToPredicate.target)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.equivalence, this.target);
    }

    public String toString() {
        String string = String.valueOf(this.equivalence);
        String string2 = String.valueOf(this.target);
        return new StringBuilder(15 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".equivalentTo(").append(string2).append(")").toString();
    }
}

