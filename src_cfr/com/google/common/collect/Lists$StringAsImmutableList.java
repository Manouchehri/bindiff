/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

final class Lists$StringAsImmutableList
extends ImmutableList {
    private final String string;

    Lists$StringAsImmutableList(String string) {
        this.string = string;
    }

    @Override
    public int indexOf(@Nullable Object object) {
        if (!(object instanceof Character)) return -1;
        int n2 = this.string.indexOf(((Character)object).charValue());
        return n2;
    }

    @Override
    public int lastIndexOf(@Nullable Object object) {
        if (!(object instanceof Character)) return -1;
        int n2 = this.string.lastIndexOf(((Character)object).charValue());
        return n2;
    }

    @Override
    public ImmutableList subList(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.size());
        return Lists.charactersOf(this.string.substring(n2, n3));
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    public Character get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return Character.valueOf(this.string.charAt(n2));
    }

    @Override
    public int size() {
        return this.string.length();
    }
}

