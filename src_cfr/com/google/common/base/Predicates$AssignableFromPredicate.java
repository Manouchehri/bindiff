/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtIncompatible(value="Class.isAssignableFrom")
class Predicates$AssignableFromPredicate
implements Predicate,
Serializable {
    private final Class clazz;
    private static final long serialVersionUID = 0;

    private Predicates$AssignableFromPredicate(Class class_) {
        this.clazz = (Class)Preconditions.checkNotNull(class_);
    }

    public boolean apply(Class class_) {
        return this.clazz.isAssignableFrom(class_);
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$AssignableFromPredicate)) return false;
        Predicates$AssignableFromPredicate predicates$AssignableFromPredicate = (Predicates$AssignableFromPredicate)object;
        if (this.clazz != predicates$AssignableFromPredicate.clazz) return false;
        return true;
    }

    public String toString() {
        String string = String.valueOf(this.clazz.getName());
        return new StringBuilder(27 + String.valueOf(string).length()).append("Predicates.assignableFrom(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$AssignableFromPredicate(Class class_, Predicates$1 predicates$1) {
        this(class_);
    }
}

