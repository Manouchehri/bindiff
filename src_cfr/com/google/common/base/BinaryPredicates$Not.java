/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class BinaryPredicates$Not
implements BinaryPredicate,
Serializable {
    final BinaryPredicate predicate;
    private static final long serialVersionUID = 7318841078083112007L;

    BinaryPredicates$Not(BinaryPredicate binaryPredicate) {
        this.predicate = (BinaryPredicate)Preconditions.checkNotNull(binaryPredicate);
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        if (this.predicate.apply(object, object2)) return false;
        return true;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof BinaryPredicates$Not)) return false;
        BinaryPredicates$Not binaryPredicates$Not = (BinaryPredicates$Not)object;
        return this.predicate.equals(binaryPredicates$Not.predicate);
    }

    public int hashCode() {
        return this.predicate.hashCode();
    }
}

