/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.BinaryPredicate;
import com.google.common.base.BinaryPredicates;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

final class BinaryPredicates$Or
implements BinaryPredicate,
Serializable {
    final Iterable predicates;
    private static final long serialVersionUID = -1352468805830701672L;

    BinaryPredicates$Or(Iterable iterable) {
        this.predicates = Preconditions.checkContentsNotNull(iterable);
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        BinaryPredicate binaryPredicate;
        Iterator iterator = this.predicates.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(binaryPredicate = (BinaryPredicate)iterator.next()).apply(object, object2));
        return true;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof BinaryPredicates$Or)) return false;
        return BinaryPredicates.access$000(this.predicates, ((BinaryPredicates$Or)object).predicates);
    }

    public int hashCode() {
        return BinaryPredicates.access$100(this.predicates);
    }
}

