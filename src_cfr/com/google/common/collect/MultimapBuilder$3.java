/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class MultimapBuilder$3
extends MultimapBuilder$MultimapBuilderWithKeys {
    final /* synthetic */ Comparator val$comparator;

    MultimapBuilder$3(Comparator comparator) {
        this.val$comparator = comparator;
    }

    @Override
    Map createMap() {
        return new TreeMap(this.val$comparator);
    }
}

