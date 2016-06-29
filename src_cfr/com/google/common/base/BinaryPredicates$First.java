/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

final class BinaryPredicates$First
implements BinaryPredicate,
Serializable {
    final Predicate predicate;
    private static final long serialVersionUID = 5389902773091803723L;

    BinaryPredicates$First(Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        return this.predicate.apply(object);
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof BinaryPredicates$First)) return false;
        BinaryPredicates$First binaryPredicates$First = (BinaryPredicates$First)object;
        return this.predicate.equals(binaryPredicates$First.predicate);
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }
}

