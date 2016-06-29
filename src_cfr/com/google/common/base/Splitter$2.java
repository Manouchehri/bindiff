/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;
import java.util.Iterator;

final class Splitter$2
implements Splitter$Strategy {
    final /* synthetic */ String val$separator;

    Splitter$2(String string) {
        this.val$separator = string;
    }

    @Override
    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        return new Splitter$2$1(this, splitter, charSequence);
    }
}

