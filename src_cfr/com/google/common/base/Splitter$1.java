/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;
import java.util.Iterator;

final class Splitter$1
implements Splitter$Strategy {
    final /* synthetic */ CharMatcher val$separatorMatcher;

    Splitter$1(CharMatcher charMatcher) {
        this.val$separatorMatcher = charMatcher;
    }

    @Override
    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        return new Splitter$1$1(this, splitter, charSequence);
    }
}

