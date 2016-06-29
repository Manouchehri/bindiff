/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3;
import com.google.common.base.Splitter$SplittingIterator;
import java.util.regex.Matcher;

class Splitter$3$1
extends Splitter$SplittingIterator {
    final /* synthetic */ Matcher val$matcher;
    final /* synthetic */ Splitter.3 this$0;

    Splitter$3$1(Splitter.3 var1_1, Splitter splitter, CharSequence charSequence, Matcher matcher) {
        this.this$0 = var1_1;
        this.val$matcher = matcher;
        super(splitter, charSequence);
    }

    @Override
    public int separatorStart(int n2) {
        if (!this.val$matcher.find(n2)) return -1;
        int n3 = this.val$matcher.start();
        return n3;
    }

    @Override
    public int separatorEnd(int n2) {
        return this.val$matcher.end();
    }
}

