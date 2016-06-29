package com.google.common.base;

import java.util.*;

final class Splitter$2 implements Splitter$Strategy
{
    final /* synthetic */ String val$separator;
    
    Splitter$2(final String val$separator) {
        this.val$separator = val$separator;
    }
    
    @Override
    public Splitter$SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
        return new Splitter$2$1(this, splitter, charSequence);
    }
}
