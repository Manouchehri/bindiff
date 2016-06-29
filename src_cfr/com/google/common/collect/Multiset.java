/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface Multiset
extends Collection {
    public int count(@Nullable Object var1);

    public int add(@Nullable Object var1, int var2);

    public int remove(@Nullable Object var1, int var2);

    public int setCount(Object var1, int var2);

    public boolean setCount(Object var1, int var2, int var3);

    public Set elementSet();

    public Set entrySet();

    @Override
    public boolean equals(@Nullable Object var1);

    @Override
    public int hashCode();

    public String toString();

    @Override
    public Iterator iterator();

    @Override
    public boolean contains(@Nullable Object var1);

    public boolean containsAll(Collection var1);

    public boolean add(Object var1);

    @Override
    public boolean remove(@Nullable Object var1);

    public boolean removeAll(Collection var1);

    public boolean retainAll(Collection var1);
}

