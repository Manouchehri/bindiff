/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Multimap {
    public int size();

    public boolean isEmpty();

    public boolean containsKey(@Nullable Object var1);

    public boolean containsValue(@Nullable Object var1);

    public boolean containsEntry(@Nullable Object var1, @Nullable Object var2);

    public boolean put(@Nullable Object var1, @Nullable Object var2);

    public boolean remove(@Nullable Object var1, @Nullable Object var2);

    public boolean putAll(@Nullable Object var1, Iterable var2);

    public boolean putAll(Multimap var1);

    public Collection replaceValues(@Nullable Object var1, Iterable var2);

    public Collection removeAll(@Nullable Object var1);

    public void clear();

    public Collection get(@Nullable Object var1);

    public Set keySet();

    public Multiset keys();

    public Collection values();

    public Collection entries();

    public Map asMap();

    public boolean equals(@Nullable Object var1);

    public int hashCode();
}

