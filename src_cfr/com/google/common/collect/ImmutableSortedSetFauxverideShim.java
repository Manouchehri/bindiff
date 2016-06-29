/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;

abstract class ImmutableSortedSetFauxverideShim
extends ImmutableSet {
    ImmutableSortedSetFauxverideShim() {
    }

    @Deprecated
    public static ImmutableSortedSet$Builder builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet of(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet of(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet of(Object object, Object object2, Object object3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet of(Object object, Object object2, Object object3, Object object4) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet of(Object object, Object object2, Object object3, Object object4, Object object5) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static /* varargs */ ImmutableSortedSet of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object ... arrobject) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static ImmutableSortedSet copyOf(Object[] arrobject) {
        throw new UnsupportedOperationException();
    }
}

