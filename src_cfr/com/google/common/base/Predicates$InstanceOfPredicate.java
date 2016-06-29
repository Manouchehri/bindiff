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

@GwtIncompatible(value="Class.isInstance")
class Predicates$InstanceOfPredicate
implements Predicate,
Serializable {
    private final Class clazz;
    private static final long serialVersionUID = 0;

    private Predicates$InstanceOfPredicate(Class class_) {
        this.clazz = (Class)Preconditions.checkNotNull(class_);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        return this.clazz.isInstance(object);
    }

    public int hashCode() {
        return this.clazz.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$InstanceOfPredicate)) return false;
        Predicates$InstanceOfPredicate predicates$InstanceOfPredicate = (Predicates$InstanceOfPredicate)object;
        if (this.clazz != predicates$InstanceOfPredicate.clazz) return false;
        return true;
    }

    public String toString() {
        String string = String.valueOf(this.clazz.getName());
        return new StringBuilder(23 + String.valueOf(string).length()).append("Predicates.instanceOf(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$InstanceOfPredicate(Class class_, Predicates$1 predicates$1) {
        this(class_);
    }
}

