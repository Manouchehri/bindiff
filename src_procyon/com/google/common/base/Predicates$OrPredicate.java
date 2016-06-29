package com.google.common.base;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.regex.*;
import java.util.*;

class Predicates$OrPredicate implements Predicate, Serializable
{
    private final List components;
    private static final long serialVersionUID = 0L;
    
    private Predicates$OrPredicate(final List components) {
        this.components = components;
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        for (int i = 0; i < this.components.size(); ++i) {
            if (((Predicate)this.components.get(i)).apply(o)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.components.hashCode() + 87855567;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Predicates$OrPredicate && this.components.equals(((Predicates$OrPredicate)o).components);
    }
    
    @Override
    public String toString() {
        final String join = Predicates.COMMA_JOINER.join(this.components);
        return new StringBuilder(15 + String.valueOf(join).length()).append("Predicates.or(").append(join).append(")").toString();
    }
}
