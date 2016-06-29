/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$4$1
extends Splitter$SplittingIterator {
    final /* synthetic */ Splitter$4 this$0;

    Splitter$4$1(Splitter$4 var1_1, Splitter splitter, CharSequence charSequence) {
        this.this$0 = var1_1;
        super(splitter, charSequence);
    }

    @Override
    public int separatorStart(int n2) {
        int n3 = n2 + this.this$0.val$length;
        if (n3 >= this.toSplit.length()) return -1;
        int n4 = n3;
        return n4;
    }

    @Override
    public int separatorEnd(int n2) {
        return n2;
    }
}

