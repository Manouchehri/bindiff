/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset$Entry;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class SortedMultisets {
    private SortedMultisets() {
    }

    private static Object getElementOrThrow(Multiset$Entry multiset$Entry) {
        if (multiset$Entry != null) return multiset$Entry.getElement();
        throw new NoSuchElementException();
    }

    private static Object getElementOrNull(@Nullable Multiset$Entry multiset$Entry) {
        if (multiset$Entry == null) {
            return null;
        }
        Object object = multiset$Entry.getElement();
        return object;
    }

    static /* synthetic */ Object access$000(Multiset$Entry multiset$Entry) {
        return SortedMultisets.getElementOrThrow(multiset$Entry);
    }

    static /* synthetic */ Object access$100(Multiset$Entry multiset$Entry) {
        return SortedMultisets.getElementOrNull(multiset$Entry);
    }
}

