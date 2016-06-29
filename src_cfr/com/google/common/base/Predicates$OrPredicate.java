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

class Predicates$OrPredicate
implements Predicate,
Serializable {
    private final List components;
    private static final long serialVersionUID = 0;

    private Predicates$OrPredicate(List list) {
        this.components = list;
    }

    @Override
    public boolean apply(@Nullable Object object) {
        int n2 = 0;
        while (n2 < this.components.size()) {
            if (((Predicate)this.components.get(n2)).apply(object)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public int hashCode() {
        return this.components.hashCode() + 87855567;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$OrPredicate)) return false;
        Predicates$OrPredicate predicates$OrPredicate = (Predicates$OrPredicate)object;
        return this.components.equals(predicates$OrPredicate.components);
    }

    public String toString() {
        String string = Predicates.access$800().join(this.components);
        return new StringBuilder(15 + String.valueOf(string).length()).append("Predicates.or(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$OrPredicate(List list, Predicates$1 predicates$1) {
        this(list);
    }
}

