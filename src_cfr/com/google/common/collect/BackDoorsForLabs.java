/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Synchronized;
import javax.annotation.Nullable;

@GwtCompatible
@GoogleInternal
public final class BackDoorsForLabs {
    private BackDoorsForLabs() {
    }

    public static Multimap synchronizedMultimap(Multimap multimap, @Nullable Object object) {
        return Synchronized.multimap(multimap, object);
    }

    public static SetMultimap synchronizedSetMultimap(SetMultimap setMultimap, @Nullable Object object) {
        return Synchronized.setMultimap(setMultimap, object);
    }
}

