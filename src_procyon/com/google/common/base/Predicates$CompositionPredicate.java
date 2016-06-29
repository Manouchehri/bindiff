package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Predicates$CompositionPredicate implements Predicate, Serializable
{
    final Predicate p;
    final Function f;
    private static final long serialVersionUID = 0L;
    
    private Predicates$CompositionPredicate(final Predicate predicate, final Function function) {
        this.p = (Predicate)Preconditions.checkNotNull(predicate);
        this.f = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return this.p.apply(this.f.apply(o));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Predicates$CompositionPredicate) {
            final Predicates$CompositionPredicate predicates$CompositionPredicate = (Predicates$CompositionPredicate)o;
            return this.f.equals(predicates$CompositionPredicate.f) && this.p.equals(predicates$CompositionPredicate.p);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.f.hashCode() ^ this.p.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.p);
        final String value2 = String.valueOf(this.f);
        return new StringBuilder(2 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append("(").append(value2).append(")").toString();
    }
}
