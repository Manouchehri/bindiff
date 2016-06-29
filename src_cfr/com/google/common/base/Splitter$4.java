/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;
import java.util.Iterator;

final class Splitter$4
implements Splitter$Strategy {
    final /* synthetic */ int val$length;

    Splitter$4(int n2) {
        this.val$length = n2;
    }

    @Override
    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        return new Splitter$4$1(this, splitter, charSequence);
    }
}

