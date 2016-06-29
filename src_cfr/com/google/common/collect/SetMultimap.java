/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface SetMultimap
extends Multimap {
    @Override
    public Set get(@Nullable Object var1);

    @Override
    public Set removeAll(@Nullable Object var1);

    @Override
    public Set replaceValues(Object var1, Iterable var2);

    @Override
    public Set entries();

    @Override
    public Map asMap();

    @Override
    public boolean equals(@Nullable Object var1);
}

