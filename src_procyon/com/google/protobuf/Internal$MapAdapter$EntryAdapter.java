package com.google.protobuf;

import java.util.*;

class Internal$MapAdapter$EntryAdapter implements Entry
{
    private final Entry realEntry;
    final /* synthetic */ Internal$MapAdapter this$0;
    
    public Internal$MapAdapter$EntryAdapter(final Internal$MapAdapter this$0, final Entry realEntry) {
        this.this$0 = this$0;
        this.realEntry = realEntry;
    }
    
    public Object getKey() {
        return this.realEntry.getKey();
    }
    
    public Object getValue() {
        return this.this$0.valueConverter.doForward(this.realEntry.getValue());
    }
    
    public Object setValue(final Object o) {
        final Object setValue = this.realEntry.setValue(this.this$0.valueConverter.doBackward(o));
        if (setValue == null) {
            return null;
        }
        return this.this$0.valueConverter.doForward(setValue);
    }
}
