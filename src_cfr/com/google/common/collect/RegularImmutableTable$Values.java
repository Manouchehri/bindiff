/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;

final class RegularImmutableTable$Values
extends ImmutableList {
    final /* synthetic */ RegularImmutableTable this$0;

    private RegularImmutableTable$Values(RegularImmutableTable regularImmutableTable) {
        this.this$0 = regularImmutableTable;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    public Object get(int n2) {
        return this.this$0.getValue(n2);
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    /* synthetic */ RegularImmutableTable$Values(RegularImmutableTable regularImmutableTable, RegularImmutableTable$1 regularImmutableTable$1) {
        this(regularImmutableTable);
    }
}

