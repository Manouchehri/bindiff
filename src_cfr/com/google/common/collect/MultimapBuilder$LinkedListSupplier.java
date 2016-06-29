/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import java.util.LinkedList;
import java.util.List;

enum MultimapBuilder$LinkedListSupplier implements Supplier
{
    INSTANCE;
    

    private MultimapBuilder$LinkedListSupplier() {
    }

    public static Supplier instance() {
        return INSTANCE;
    }

    @Override
    public List get() {
        return new LinkedList();
    }
}

