/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$HashSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import java.util.Map;

class MultimapBuilder$MultimapBuilderWithKeys$3
extends MultimapBuilder$SetMultimapBuilder {
    final /* synthetic */ int val$expectedValuesPerKey;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;

    MultimapBuilder$MultimapBuilderWithKeys$3(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, int n2) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$expectedValuesPerKey = n2;
    }

    @Override
    public SetMultimap build() {
        return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder$HashSetSupplier(this.val$expectedValuesPerKey));
    }
}

