package com.google.common.cache;

import java.util.*;

final class LocalCache$EntryIterator extends LocalCache$HashIterator
{
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$EntryIterator(final LocalCache this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Map.Entry next() {
        return this.nextEntry();
    }
}
