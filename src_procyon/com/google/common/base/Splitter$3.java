package com.google.common.base;

import java.util.regex.*;
import java.util.*;

final class Splitter$3 implements Splitter$Strategy
{
    final /* synthetic */ Pattern val$separatorPattern;
    
    Splitter$3(final Pattern val$separatorPattern) {
        this.val$separatorPattern = val$separatorPattern;
    }
    
    @Override
    public Splitter$SplittingIterator iterator(final Splitter splitter, final CharSequence charSequence) {
        return new Splitter$3$1(this, splitter, charSequence, this.val$separatorPattern.matcher(charSequence));
    }
}
