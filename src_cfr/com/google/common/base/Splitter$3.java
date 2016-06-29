/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Splitter$3
implements Splitter$Strategy {
    final /* synthetic */ Pattern val$separatorPattern;

    Splitter$3(Pattern pattern) {
        this.val$separatorPattern = pattern;
    }

    @Override
    public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
        Matcher matcher = this.val$separatorPattern.matcher(charSequence);
        return new Splitter$3$1(this, splitter, charSequence, matcher);
    }
}

