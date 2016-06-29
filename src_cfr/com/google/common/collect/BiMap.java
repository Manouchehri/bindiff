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
public interface BiMap
extends Map {
    @Nullable
    public Object put(@Nullable Object var1, @Nullable Object var2);

    @Nullable
    public Object forcePut(@Nullable Object var1, @Nullable Object var2);

    public void putAll(Map var1);

    public Set values();

    public BiMap inverse();
}

