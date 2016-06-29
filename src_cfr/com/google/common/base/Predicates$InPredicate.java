/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

class Predicates$InPredicate
implements Predicate,
Serializable {
    private final Collection target;
    private static final long serialVersionUID = 0;

    private Predicates$InPredicate(Collection collection) {
        this.target = (Collection)Preconditions.checkNotNull(collection);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        try {
            return this.target.contains(object);
        }
        catch (NullPointerException var2_2) {
            return false;
        }
        catch (ClassCastException var2_3) {
            return false;
        }
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Predicates$InPredicate)) return false;
        Predicates$InPredicate predicates$InPredicate = (Predicates$InPredicate)object;
        return this.target.equals(predicates$InPredicate.target);
    }

    public int hashCode() {
        return this.target.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.target);
        return new StringBuilder(15 + String.valueOf(string).length()).append("Predicates.in(").append(string).append(")").toString();
    }

    /* synthetic */ Predicates$InPredicate(Collection collection, Predicates$1 predicates$1) {
        this(collection);
    }
}

