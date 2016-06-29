/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$EntrySetSerializedForm;
import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.Multiset$Entry;
import java.util.Set;

final class ImmutableMultiset$EntrySet
extends ImmutableSet$Indexed {
    private static final long serialVersionUID = 0;
    final /* synthetic */ ImmutableMultiset this$0;

    private ImmutableMultiset$EntrySet(ImmutableMultiset immutableMultiset) {
        this.this$0 = immutableMultiset;
    }

    @Override
    boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    @Override
    Multiset$Entry get(int n2) {
        return this.this$0.getEntry(n2);
    }

    @Override
    public int size() {
        return this.this$0.elementSet().size();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Multiset$Entry)) return false;
        Multiset$Entry multiset$Entry = (Multiset$Entry)object;
        if (multiset$Entry.getCount() <= 0) {
            return false;
        }
        int n2 = this.this$0.count(multiset$Entry.getElement());
        if (n2 != multiset$Entry.getCount()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.this$0.hashCode();
    }

    @Override
    Object writeReplace() {
        return new ImmutableMultiset$EntrySetSerializedForm(this.this$0);
    }

    /* synthetic */ ImmutableMultiset$EntrySet(ImmutableMultiset immutableMultiset, ImmutableMultiset$1 immutableMultiset$1) {
        this(immutableMultiset);
    }
}

