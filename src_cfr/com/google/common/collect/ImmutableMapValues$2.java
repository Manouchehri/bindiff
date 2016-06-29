/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMapValues;
import java.util.Map;

class ImmutableMapValues$2
extends ImmutableAsList {
    final /* synthetic */ ImmutableList val$entryList;
    final /* synthetic */ ImmutableMapValues this$0;

    ImmutableMapValues$2(ImmutableMapValues immutableMapValues, ImmutableList immutableList) {
        this.this$0 = immutableMapValues;
        this.val$entryList = immutableList;
    }

    public Object get(int n2) {
        return ((Map.Entry)this.val$entryList.get(n2)).getValue();
    }

    @Override
    ImmutableCollection delegateCollection() {
        return this.this$0;
    }
}

