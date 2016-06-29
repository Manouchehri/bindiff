/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class PairwiseEquivalence
extends Equivalence
implements Serializable {
    final Equivalence elementEquivalence;
    private static final long serialVersionUID = 1;

    PairwiseEquivalence(Equivalence equivalence) {
        this.elementEquivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
    }

    protected boolean doEquivalent(Iterable iterable, Iterable iterable2) {
        Iterator iterator = iterable.iterator();
        Iterator iterator2 = iterable2.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            if (this.elementEquivalence.equivalent(iterator.next(), iterator2.next())) continue;
            return false;
        }
        if (iterator.hasNext()) return false;
        if (iterator2.hasNext()) return false;
        return true;
    }

    protected int doHash(Iterable iterable) {
        int n2 = 78721;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            n2 = n2 * 24943 + this.elementEquivalence.hash(t2);
        }
        return n2;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof PairwiseEquivalence)) return false;
        PairwiseEquivalence pairwiseEquivalence = (PairwiseEquivalence)object;
        return this.elementEquivalence.equals(pairwiseEquivalence.elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        String string = String.valueOf(this.elementEquivalence);
        return new StringBuilder(11 + String.valueOf(string).length()).append(string).append(".pairwise()").toString();
    }
}

