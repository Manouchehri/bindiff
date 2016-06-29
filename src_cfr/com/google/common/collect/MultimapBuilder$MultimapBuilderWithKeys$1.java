/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$ArrayListSupplier;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Multimaps;
import java.util.Map;

class MultimapBuilder$MultimapBuilderWithKeys$1
extends MultimapBuilder$ListMultimapBuilder {
    final /* synthetic */ int val$expectedValuesPerKey;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;

    MultimapBuilder$MultimapBuilderWithKeys$1(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, int n2) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$expectedValuesPerKey = n2;
    }

    @Override
    public ListMultimap build() {
        return Multimaps.newListMultimap(this.this$0.createMap(), new MultimapBuilder$ArrayListSupplier(this.val$expectedValuesPerKey));
    }
}

