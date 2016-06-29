package com.google.common.collect;

import com.google.common.annotations.*;
import java.io.*;
import javax.annotation.*;
import java.util.*;

class ImmutableMultiset$SerializedForm implements Serializable
{
    final Object[] elements;
    final int[] counts;
    private static final long serialVersionUID = 0L;
    
    ImmutableMultiset$SerializedForm(final Multiset multiset) {
        final int size = multiset.entrySet().size();
        this.elements = new Object[size];
        this.counts = new int[size];
        int n = 0;
        for (final Multiset$Entry multiset$Entry : multiset.entrySet()) {
            this.elements[n] = multiset$Entry.getElement();
            this.counts[n] = multiset$Entry.getCount();
            ++n;
        }
    }
    
    Object readResolve() {
        final LinkedHashMultiset create = LinkedHashMultiset.create(this.elements.length);
        for (int i = 0; i < this.elements.length; ++i) {
            create.add(this.elements[i], this.counts[i]);
        }
        return ImmutableMultiset.copyOf(create);
    }
}
