/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface Weigher {
    public int weigh(Object var1, Object var2);
}

