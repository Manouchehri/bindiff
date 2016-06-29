/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SortedSetMultimapBuilder;
import com.google.common.collect.MultimapBuilder$TreeSetSupplier;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.Map;

class MultimapBuilder$MultimapBuilderWithKeys$5
extends MultimapBuilder$SortedSetMultimapBuilder {
    final /* synthetic */ Comparator val$comparator;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;

    MultimapBuilder$MultimapBuilderWithKeys$5(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, Comparator comparator) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$comparator = comparator;
    }

    @Override
    public SortedSetMultimap build() {
        return Multimaps.newSortedSetMultimap(this.this$0.createMap(), new MultimapBuilder$TreeSetSupplier(this.val$comparator));
    }
}

