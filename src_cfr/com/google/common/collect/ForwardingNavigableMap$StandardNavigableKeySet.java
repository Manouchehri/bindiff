/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.NavigableMap;

@Beta
public class ForwardingNavigableMap$StandardNavigableKeySet
extends Maps$NavigableKeySet {
    final /* synthetic */ ForwardingNavigableMap this$0;

    public ForwardingNavigableMap$StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
        this.this$0 = forwardingNavigableMap;
        super(forwardingNavigableMap);
    }
}

