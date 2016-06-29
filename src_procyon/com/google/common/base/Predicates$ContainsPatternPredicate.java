package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import java.util.regex.*;
import javax.annotation.*;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternPredicate implements Predicate, Serializable
{
    final Pattern pattern;
    private static final long serialVersionUID = 0L;
    
    Predicates$ContainsPatternPredicate(final Pattern pattern) {
        this.pattern = (Pattern)Preconditions.checkNotNull(pattern);
    }
    
    public boolean apply(final CharSequence charSequence) {
        return this.pattern.matcher(charSequence).find();
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.pattern.pattern(), this.pattern.flags());
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Predicates$ContainsPatternPredicate) {
            final Predicates$ContainsPatternPredicate predicates$ContainsPatternPredicate = (Predicates$ContainsPatternPredicate)o;
            return Objects.equal(this.pattern.pattern(), predicates$ContainsPatternPredicate.pattern.pattern()) && Objects.equal(this.pattern.flags(), predicates$ContainsPatternPredicate.pattern.flags());
        }
        return false;
    }
    
    @Override
    public String toString() {
        final String string = Objects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
        return new StringBuilder(21 + String.valueOf(string).length()).append("Predicates.contains(").append(string).append(")").toString();
    }
}
