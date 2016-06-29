package com.google.common.collect;

import java.util.*;

final class Maps$5 extends AbstractMapEntry
{
    final /* synthetic */ Entry val$entry;
    
    Maps$5(final Entry val$entry) {
        this.val$entry = val$entry;
    }
    
    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }
    
    @Override
    public Object getValue() {
        return this.val$entry.getValue();
    }
}
