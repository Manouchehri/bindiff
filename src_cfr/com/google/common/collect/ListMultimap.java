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
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public interface ListMultimap
extends Multimap {
    @Override
    public List get(@Nullable Object var1);

    @Override
    public List removeAll(@Nullable Object var1);

    @Override
    public List replaceValues(Object var1, Iterable var2);

    @Override
    public Map asMap();

    @Override
    public boolean equals(@Nullable Object var1);
}

