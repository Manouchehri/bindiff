/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Table {
    public boolean contains(@Nullable Object var1, @Nullable Object var2);

    public boolean containsRow(@Nullable Object var1);

    public boolean containsColumn(@Nullable Object var1);

    public boolean containsValue(@Nullable Object var1);

    public Object get(@Nullable Object var1, @Nullable Object var2);

    public boolean isEmpty();

    public int size();

    public boolean equals(@Nullable Object var1);

    public int hashCode();

    public void clear();

    @Nullable
    public Object put(Object var1, Object var2, Object var3);

    public void putAll(Table var1);

    @Nullable
    public Object remove(@Nullable Object var1, @Nullable Object var2);

    public Map row(Object var1);

    public Map column(Object var1);

    public Set cellSet();

    public Set rowKeySet();

    public Set columnKeySet();

    public Collection values();

    public Map rowMap();

    public Map columnMap();
}

