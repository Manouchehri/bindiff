/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;

final class Lists$CharSequenceAsList
extends AbstractList {
    private final CharSequence sequence;

    Lists$CharSequenceAsList(CharSequence charSequence) {
        this.sequence = charSequence;
    }

    @Override
    public Character get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return Character.valueOf(this.sequence.charAt(n2));
    }

    @Override
    public int size() {
        return this.sequence.length();
    }
}

