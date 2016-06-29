/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$KeySet;
import java.util.Map;

@Beta
public class ForwardingMap$StandardKeySet
extends Maps$KeySet {
    final /* synthetic */ ForwardingMap this$0;

    public ForwardingMap$StandardKeySet(ForwardingMap forwardingMap) {
        this.this$0 = forwardingMap;
        super(forwardingMap);
    }
}

