package com.google.common.base;

import java.io.*;
import javax.annotation.*;

public final class Equivalence$Wrapper implements Serializable
{
    private final Equivalence equivalence;
    @Nullable
    private final Object reference;
    private static final long serialVersionUID = 0L;
    
    private Equivalence$Wrapper(final Equivalence equivalence, @Nullable final Object reference) {
        this.equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.reference = reference;
    }
    
    @Nullable
    public Object get() {
        return this.reference;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Equivalence$Wrapper) {
            final Equivalence$Wrapper equivalence$Wrapper = (Equivalence$Wrapper)o;
            if (this.equivalence.equals(equivalence$Wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, equivalence$Wrapper.reference);
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.equivalence.hash(this.reference);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.equivalence);
        final String value2 = String.valueOf(this.reference);
        return new StringBuilder(7 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(".wrap(").append(value2).append(")").toString();
    }
}
