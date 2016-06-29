/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$IsEqualToPredicate
implements Predicate,
Serializable {
    private final Object target;
    private static final long serialVersionUID = 0;

    private Predicates$IsEqualToPredicate(Object object) {
        this.target = object;
    }

    @Override
    public boolean apply(Object object) {
        return this.target.equals(object);
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$IsEqualToPredicate)) return false;
        Predicates$IsEqualToPredicate predicates$IsEqualToPredicate = (Predicates$IsEqualToPredicate)object;
        return this.target.equals(predicates$IsEqualToPredicate.target);
    }

    public String toString() {
        String string = String.valueOf(this.target);
        return new StringBuilder(20 + String.valueOf(string).length()).append("Predicates.equalTo(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$IsEqualToPredicate(Object object, Predicates$1 predicates$1) {
        this(object);
    }
}

