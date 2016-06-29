package com.google.common.base;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.regex.*;
import java.util.*;

class Predicates$AndPredicate implements Predicate, Serializable
{
    private final List components;
    private static final long serialVersionUID = 0L;
    
    private Predicates$AndPredicate(final List components) {
        this.components = components;
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        for (int i = 0; i < this.components.size(); ++i) {
            if (!((Predicate)this.components.get(i)).apply(o)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.components.hashCode() + 306654252;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$AndPredicate && this.components.equals(((Predicates$AndPredicate)o).components);
    }
    
    @Override
    public String toString() {
        final String join = Predicates.COMMA_JOINER.join(this.components);
        return new StringBuilder(16 + String.valueOf(join).length()).append("Predicates.and(").append(join).append(")").toString();
    }
}
