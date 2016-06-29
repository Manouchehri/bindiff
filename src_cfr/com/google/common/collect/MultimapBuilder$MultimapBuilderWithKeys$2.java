/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$LinkedListSupplier;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Multimaps;
import java.util.Map;

class MultimapBuilder$MultimapBuilderWithKeys$2
extends MultimapBuilder$ListMultimapBuilder {
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;

    MultimapBuilder$MultimapBuilderWithKeys$2(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
    }

    @Override
    public ListMultimap build() {
        return Multimaps.newListMultimap(this.this$0.createMap(), MultimapBuilder$LinkedListSupplier.instance());
    }
}

