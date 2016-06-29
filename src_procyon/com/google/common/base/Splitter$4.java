package com.google.common.base;

import java.util.*;

final class Splitter$4 implements Splitter$Strategy
{
    final /* synthetic */ int val$length;
    
    Splitter$4(final int val$length) {
        this.val$length = val$length;
    }
    
    @Override
    public Splitter$SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
        return new Splitter$4$1(this, splitter, charSequence);
    }
}
