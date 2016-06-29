/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet$Indexed;

class ImmutableSet$Indexed$1
extends ImmutableAsList {
    final /* synthetic */ ImmutableSet$Indexed this$0;

    ImmutableSet$Indexed$1(ImmutableSet$Indexed immutableSet$Indexed) {
        this.this$0 = immutableSet$Indexed;
    }

    public Object get(int n2) {
        return this.this$0.get(n2);
    }

    @Override
    ImmutableSet$Indexed delegateCollection() {
        return this.this$0;
    }
}

