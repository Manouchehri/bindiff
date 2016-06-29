/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Objects$ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtIncompatible(value="Only used by other GWT-incompatible code.")
class Predicates$ContainsPatternPredicate
implements Predicate,
Serializable {
    final Pattern pattern;
    private static final long serialVersionUID = 0;

    Predicates$ContainsPatternPredicate(Pattern pattern) {
        this.pattern = (Pattern)Preconditions.checkNotNull(pattern);
    }

    public boolean apply(CharSequence charSequence) {
        return this.pattern.matcher(charSequence).find();
    }

    public int hashCode() {
        return Objects.hashCode(this.pattern.pattern(), this.pattern.flags());
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$ContainsPatternPredicate)) return false;
        Predicates$ContainsPatternPredicate predicates$ContainsPatternPredicate = (Predicates$ContainsPatternPredicate)object;
        if (!Objects.equal(this.pattern.pattern(), predicates$ContainsPatternPredicate.pattern.pattern())) return false;
        if (!Objects.equal(this.pattern.flags(), predicates$ContainsPatternPredicate.pattern.flags())) return false;
        return true;
    }

    public String toString() {
        String string = Objects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
        return new StringBuilder(21 + String.valueOf(string).length()).append("Predicates.contains(").append(string).append(")").toString();
    }
}

