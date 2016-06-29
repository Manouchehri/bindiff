package com.google.common.collect;

import java.util.*;

final class Maps$10 extends AbstractMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ Maps$EntryTransformer val$transformer;
    
    Maps$10(final Entry val$entry, final Maps$EntryTransformer val$transformer) {
        this.val$entry = val$entry;
        this.val$transformer = val$transformer;
    }
    
    @Override
    public Object getKey() {
        return this.val$entry.getKey();
    }
    
    @Override
    public Object getValue() {
        return this.val$transformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
    }
}
