package com.google.common.base;

import java.util.*;

class CharsetCache$1 extends LinkedHashMap
{
    final /* synthetic */ int val$missCacheSize;
    final /* synthetic */ CharsetCache this$0;
    
    CharsetCache$1(final CharsetCache this$0, final int n, final float n2, final boolean b, final int val$missCacheSize) {
        this.this$0 = this$0;
        this.val$missCacheSize = val$missCacheSize;
        super(n, n2, b);
    }
    
    @Override
    protected boolean removeEldestEntry(final Map.Entry entry) {
        return this.size() > this.val$missCacheSize;
    }
}
