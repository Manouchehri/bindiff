/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedMultiset;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

final class ImmutableSortedMultiset$SerializedForm
implements Serializable {
    Comparator comparator;
    Object[] elements;
    int[] counts;

    ImmutableSortedMultiset$SerializedForm(SortedMultiset sortedMultiset) {
        this.comparator = sortedMultiset.comparator();
        int n2 = sortedMultiset.entrySet().size();
        this.elements = new Object[n2];
        this.counts = new int[n2];
        int n3 = 0;
        Iterator iterator = sortedMultiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            this.elements[n3] = multiset$Entry.getElement();
            this.counts[n3] = multiset$Entry.getCount();
            ++n3;
        }
    }

    Object readResolve() {
        int n2 = this.elements.length;
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(this.comparator);
        int n3 = 0;
        while (n3 < n2) {
            immutableSortedMultiset$Builder.addCopies(this.elements[n3], this.counts[n3]);
            ++n3;
        }
        return immutableSortedMultiset$Builder.build();
    }
}

