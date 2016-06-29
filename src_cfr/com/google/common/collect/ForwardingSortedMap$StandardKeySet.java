/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Maps$SortedKeySet;
import java.util.SortedMap;

@Beta
public class ForwardingSortedMap$StandardKeySet
extends Maps$SortedKeySet {
    final /* synthetic */ ForwardingSortedMap this$0;

    public ForwardingSortedMap$StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
        this.this$0 = forwardingSortedMap;
        super(forwardingSortedMap);
    }
}

