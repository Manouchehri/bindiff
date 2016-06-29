/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$NotPredicate
implements Predicate,
Serializable {
    final Predicate predicate;
    private static final long serialVersionUID = 0;

    Predicates$NotPredicate(Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        if (this.predicate.apply(object)) return false;
        return true;
    }

    public int hashCode() {
        return ~ this.predicate.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$NotPredicate)) return false;
        Predicates$NotPredicate predicates$NotPredicate = (Predicates$NotPredicate)object;
        return this.predicate.equals(predicates$NotPredicate.predicate);
    }

    public String toString() {
        String string = String.valueOf(this.predicate);
        return new StringBuilder(16 + String.valueOf(string).length()).append("Predicates.not(").append(string).append(")").toString();
    }
}

