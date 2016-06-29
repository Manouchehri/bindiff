package com.google.common.base;

import java.util.*;

final class Splitter$1 implements Splitter$Strategy
{
    final /* synthetic */ CharMatcher val$separatorMatcher;
    
    Splitter$1(final CharMatcher val$separatorMatcher) {
        this.val$separatorMatcher = val$separatorMatcher;
    }
    
    @Override
    public Splitter$SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
        return new Splitter$1$1(this, splitter, charSequence);
    }
}
