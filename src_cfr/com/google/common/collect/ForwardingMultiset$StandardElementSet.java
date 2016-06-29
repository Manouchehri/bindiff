/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet;

@Beta
public class ForwardingMultiset$StandardElementSet
extends Multisets$ElementSet {
    final /* synthetic */ ForwardingMultiset this$0;

    public ForwardingMultiset$StandardElementSet(ForwardingMultiset forwardingMultiset) {
        this.this$0 = forwardingMultiset;
    }

    @Override
    Multiset multiset() {
        return this.this$0;
    }
}

