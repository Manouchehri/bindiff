/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

class Predicates$AndPredicate
implements Predicate,
Serializable {
    private final List components;
    private static final long serialVersionUID = 0;

    private Predicates$AndPredicate(List list) {
        this.components = list;
    }

    @Override
    public boolean apply(@Nullable Object object) {
        int n2 = 0;
        while (n2 < this.components.size()) {
            if (!((Predicate)this.components.get(n2)).apply(object)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public int hashCode() {
        return this.components.hashCode() + 306654252;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$AndPredicate)) return false;
        Predicates$AndPredicate predicates$AndPredicate = (Predicates$AndPredicate)object;
        return this.components.equals(predicates$AndPredicate.components);
    }

    public String toString() {
        String string = Predicates.access$800().join(this.components);
        return new StringBuilder(16 + String.valueOf(string).length()).append("Predicates.and(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$AndPredicate(List list, Predicates$1 predicates$1) {
        this(list);
    }
}

