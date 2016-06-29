/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$CompositionPredicate
implements Predicate,
Serializable {
    final Predicate p;
    final Function f;
    private static final long serialVersionUID = 0;

    private Predicates$CompositionPredicate(Predicate predicate, Function function) {
        this.p = (Predicate)Preconditions.checkNotNull(predicate);
        this.f = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        return this.p.apply(this.f.apply(object));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$CompositionPredicate)) return false;
        Predicates$CompositionPredicate predicates$CompositionPredicate = (Predicates$CompositionPredicate)object;
        if (!this.f.equals(predicates$CompositionPredicate.f)) return false;
        if (!this.p.equals(predicates$CompositionPredicate.p)) return false;
        return true;
    }

    public int hashCode() {
        return this.f.hashCode() ^ this.p.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.p);
        String string2 = String.valueOf(this.f);
        return new StringBuilder(2 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("(").append(string2).append(")").toString();
    }

    /* synthetic */ Predicates$CompositionPredicate(Predicate predicate, Function function, Predicates$1 predicates$1) {
        this(predicate, function);
    }
}

