/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$EntrySet;
import java.util.Map;

@Beta
public abstract class ForwardingMap$StandardEntrySet
extends Maps$EntrySet {
    final /* synthetic */ ForwardingMap this$0;

    public ForwardingMap$StandardEntrySet(ForwardingMap forwardingMap) {
        this.this$0 = forwardingMap;
    }

    @Override
    Map map() {
        return this.this$0;
    }
}

