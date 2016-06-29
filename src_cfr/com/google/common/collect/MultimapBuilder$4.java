/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.EnumMap;
import java.util.Map;

final class MultimapBuilder$4
extends MultimapBuilder$MultimapBuilderWithKeys {
    final /* synthetic */ Class val$keyClass;

    MultimapBuilder$4(Class class_) {
        this.val$keyClass = class_;
    }

    @Override
    Map createMap() {
        return new EnumMap(this.val$keyClass);
    }
}

