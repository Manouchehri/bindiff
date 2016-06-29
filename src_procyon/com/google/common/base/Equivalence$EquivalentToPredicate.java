package com.google.common.base;

import java.io.*;
import javax.annotation.*;

final class Equivalence$EquivalentToPredicate implements Predicate, Serializable
{
    private final Equivalence equivalence;
    @Nullable
    private final Object target;
    private static final long serialVersionUID = 0L;
    
    Equivalence$EquivalentToPredicate(final Equivalence equivalence, @Nullable final Object target) {
        this.equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.target = target;
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return this.equivalence.equivalent(o, this.target);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Equivalence$EquivalentToPredicate) {
            final Equivalence$EquivalentToPredicate equivalence$EquivalentToPredicate = (Equivalence$EquivalentToPredicate)o;
            return this.equivalence.equals(equivalence$EquivalentToPredicate.equivalence) && Objects.equal(this.target, equivalence$EquivalentToPredicate.target);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.equivalence, this.target);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.equivalence);
        final String value2 = String.valueOf(this.target);
        return new StringBuilder(15 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".equivalentTo(").append(value2).append(")").toString();
    }
}
