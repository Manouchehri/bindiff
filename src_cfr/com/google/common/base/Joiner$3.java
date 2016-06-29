/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import java.util.AbstractList;

final class Joiner$3
extends AbstractList {
    final /* synthetic */ Object[] val$rest;
    final /* synthetic */ Object val$first;
    final /* synthetic */ Object val$second;

    Joiner$3(Object[] arrobject, Object object, Object object2) {
        this.val$rest = arrobject;
        this.val$first = object;
        this.val$second = object2;
    }

    @Override
    public int size() {
        return this.val$rest.length + 2;
    }

    @Override
    public Object get(int n2) {
        switch (n2) {
            case 0: {
                return this.val$first;
            }
            case 1: {
                return this.val$second;
            }
        }
        return this.val$rest[n2 - 2];
    }
}

