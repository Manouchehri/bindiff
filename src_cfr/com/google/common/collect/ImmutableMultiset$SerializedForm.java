/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

class ImmutableMultiset$SerializedForm
implements Serializable {
    final Object[] elements;
    final int[] counts;
    private static final long serialVersionUID = 0;

    ImmutableMultiset$SerializedForm(Multiset multiset) {
        int n2 = multiset.entrySet().size();
        this.elements = new Object[n2];
        this.counts = new int[n2];
        int n3 = 0;
        Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            this.elements[n3] = multiset$Entry.getElement();
            this.counts[n3] = multiset$Entry.getCount();
            ++n3;
        }
    }

    Object readResolve() {
        LinkedHashMultiset linkedHashMultiset = LinkedHashMultiset.create(this.elements.length);
        int n2 = 0;
        while (n2 < this.elements.length) {
            linkedHashMultiset.add(this.elements[n2], this.counts[n2]);
            ++n2;
        }
        return ImmutableMultiset.copyOf(linkedHashMultiset);
    }
}

