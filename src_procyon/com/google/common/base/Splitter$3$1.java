package com.google.common.base;

import java.util.regex.*;

class Splitter$3$1 extends Splitter$SplittingIterator
{
    final /* synthetic */ Matcher val$matcher;
    final /* synthetic */ Splitter$3 this$0;
    
    Splitter$3$1(final Splitter$3 this$0, final Splitter splitter, final CharSequence charSequence, final Matcher val$matcher) {
        this.this$0 = this$0;
        this.val$matcher = val$matcher;
        super(splitter, charSequence);
    }
    
    public int separatorStart(final int n) {
        return this.val$matcher.find(n) ? this.val$matcher.start() : -1;
    }
    
    public int separatorEnd(final int n) {
        return this.val$matcher.end();
    }
}
