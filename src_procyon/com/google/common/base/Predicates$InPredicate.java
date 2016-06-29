package com.google.common.base;

import java.io.*;
import java.util.*;
import javax.annotation.*;

class Predicates$InPredicate implements Predicate, Serializable
{
    private final Collection target;
    private static final long serialVersionUID = 0L;
    
    private Predicates$InPredicate(final Collection collection) {
        this.target = (Collection)Preconditions.checkNotNull(collection);
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        try {
            return this.target.contains(o);
        }
        catch (NullPointerException ex) {
            return false;
        }
        catch (ClassCastException ex2) {
            return false;
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$InPredicate && this.target.equals(((Predicates$InPredicate)o).target);
    }
    
    @Override
    public int hashCode() {
        return this.target.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.target);
        return new StringBuilder(15 + String.valueOf(value).length()).append("Predicates.in(").append(value).append(")").toString();
    }
}
