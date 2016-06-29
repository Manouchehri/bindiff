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

final class BinaryPredicates$And
implements BinaryPredicate,
Serializable {
    final Iterable predicates;
    private static final long serialVersionUID = 4814831122225615776L;

    BinaryPredicates$And(Iterable iterable) {
        this.predicates = Preconditions.checkContentsNotNull(iterable);
    }

    @Override
    public boolean apply(@Nullable Object object, @Nullable Object object2) {
        BinaryPredicate binaryPredicate;
        Iterator iterator = this.predicates.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((binaryPredicate = (BinaryPredicate)iterator.next()).apply(object, object2));
        return false;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof BinaryPredicates$And)) return false;
        return BinaryPredicates.access$000(this.predicates, ((BinaryPredicates$And)object).predicates);
    }

    public int hashCode() {
        return BinaryPredicates.access$100(this.predicates);
    }
}

