/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public interface PeekingIterator
extends Iterator {
    public Object peek();

    public Object next();

    @Override
    public void remove();
}

