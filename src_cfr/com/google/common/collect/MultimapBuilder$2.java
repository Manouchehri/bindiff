/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.Map;

final class MultimapBuilder$2
extends MultimapBuilder$MultimapBuilderWithKeys {
    final /* synthetic */ int val$expectedKeys;

    MultimapBuilder$2(int n2) {
        this.val$expectedKeys = n2;
    }

    @Override
    Map createMap() {
        return Maps.newLinkedHashMapWithExpectedSize(this.val$expectedKeys);
    }
}

