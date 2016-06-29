/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$EntryFunction;
import java.util.Map;
import javax.annotation.Nullable;

final class Maps$EntryFunction$1
extends Maps$EntryFunction {
    Maps$EntryFunction$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Nullable
    public Object apply(Map.Entry entry) {
        return entry.getKey();
    }
}

