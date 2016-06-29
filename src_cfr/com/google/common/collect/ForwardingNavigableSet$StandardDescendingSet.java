/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Sets$DescendingSet;
import java.util.NavigableSet;

@Beta
public class ForwardingNavigableSet$StandardDescendingSet
extends Sets$DescendingSet {
    final /* synthetic */ ForwardingNavigableSet this$0;

    public ForwardingNavigableSet$StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
        this.this$0 = forwardingNavigableSet;
        super(forwardingNavigableSet);
    }
}

