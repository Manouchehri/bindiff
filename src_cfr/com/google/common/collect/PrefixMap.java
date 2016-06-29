/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;

@GoogleInternal
public interface PrefixMap {
    public Object put(CharSequence var1, Object var2);

    public Object get(CharSequence var1);

    public Object remove(CharSequence var1);
}

