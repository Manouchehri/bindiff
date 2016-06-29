/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$1$1
extends Splitter$SplittingIterator {
    final /* synthetic */ Splitter$1 this$0;

    Splitter$1$1(Splitter$1 var1_1, Splitter splitter, CharSequence charSequence) {
        this.this$0 = var1_1;
        super(splitter, charSequence);
    }

    @Override
    int separatorStart(int n2) {
        return this.this$0.val$separatorMatcher.indexIn(this.toSplit, n2);
    }

    @Override
    int separatorEnd(int n2) {
        return n2 + 1;
    }
}

