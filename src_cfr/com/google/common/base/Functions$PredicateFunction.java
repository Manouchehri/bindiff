/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$PredicateFunction
implements Function,
Serializable {
    private final Predicate predicate;
    private static final long serialVersionUID = 0;

    private Functions$PredicateFunction(Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public Boolean apply(@Nullable Object object) {
        return this.predicate.apply(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$PredicateFunction)) return false;
        Functions$PredicateFunction functions$PredicateFunction = (Functions$PredicateFunction)object;
        return this.predicate.equals(functions$PredicateFunction.predicate);
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.predicate);
        return new StringBuilder(24 + String.valueOf(string).length()).append("Functions.forPredicate(").append(string).append(")").toString();
    }

    /* synthetic */ Functions$PredicateFunction(Predicate predicate, Functions$1 functions$1) {
        this(predicate);
    }
}

