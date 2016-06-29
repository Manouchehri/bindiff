package com.google.common.base;

import com.google.common.annotations.*;
import java.util.regex.*;

@GwtIncompatible("Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternFromStringPredicate extends Predicates$ContainsPatternPredicate
{
    private static final long serialVersionUID = 0L;
    
    Predicates$ContainsPatternFromStringPredicate(final String s) {
        super(Pattern.compile(s));
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.pattern.pattern());
        return new StringBuilder(28 + String.valueOf(value).length()).append("Predicates.containsPattern(").append(value).append(")").toString();
    }
}
