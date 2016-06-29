/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicates$ContainsPatternPredicate;
import java.util.regex.Pattern;

@GwtIncompatible(value="Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternFromStringPredicate
extends Predicates$ContainsPatternPredicate {
    private static final long serialVersionUID = 0;

    Predicates$ContainsPatternFromStringPredicate(String string) {
        super(Pattern.compile(string));
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.pattern.pattern());
        return new StringBuilder(28 + String.valueOf(string).length()).append("Predicates.containsPattern(").append(string).append(")").toString();
    }
}

