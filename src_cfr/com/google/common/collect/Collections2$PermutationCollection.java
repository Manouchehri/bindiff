/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$PermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$PermutationCollection
extends AbstractCollection {
    final ImmutableList inputList;

    Collections2$PermutationCollection(ImmutableList immutableList) {
        this.inputList = immutableList;
    }

    @Override
    public int size() {
        return IntMath.factorial(this.inputList.size());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Collections2$PermutationIterator(this.inputList);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof List)) return false;
        List list = (List)object;
        return Collections2.access$100(this.inputList, list);
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.inputList);
        return new StringBuilder(14 + String.valueOf(string).length()).append("permutations(").append(string).append(")").toString();
    }
}

