package com.google.common.collect;

import java.io.*;
import java.util.*;

final class ImmutableSortedMultiset$SerializedForm implements Serializable
{
    Comparator comparator;
    Object[] elements;
    int[] counts;
    
    ImmutableSortedMultiset$SerializedForm(final SortedMultiset sortedMultiset) {
        this.comparator = sortedMultiset.comparator();
        final int size = sortedMultiset.entrySet().size();
        this.elements = new Object[size];
        this.counts = new int[size];
        int n = 0;
        for (final Multiset$Entry multiset$Entry : sortedMultiset.entrySet()) {
            this.elements[n] = multiset$Entry.getElement();
            this.counts[n] = multiset$Entry.getCount();
            ++n;
        }
    }
    
    Object readResolve() {
        final int length = this.elements.length;
        final ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(this.comparator);
        for (int i = 0; i < length; ++i) {
            immutableSortedMultiset$Builder.addCopies(this.elements[i], this.counts[i]);
        }
        return immutableSortedMultiset$Builder.build();
    }
}
