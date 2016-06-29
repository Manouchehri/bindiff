/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$EnumSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import java.util.Map;

class MultimapBuilder$MultimapBuilderWithKeys$6
extends MultimapBuilder$SetMultimapBuilder {
    final /* synthetic */ Class val$valueClass;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;

    MultimapBuilder$MultimapBuilderWithKeys$6(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, Class class_) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$valueClass = class_;
    }

    @Override
    public SetMultimap build() {
        MultimapBuilder$EnumSetSupplier multimapBuilder$EnumSetSupplier = new MultimapBuilder$EnumSetSupplier(this.val$valueClass);
        return Multimaps.newSetMultimap(this.this$0.createMap(), multimapBuilder$EnumSetSupplier);
    }
}

