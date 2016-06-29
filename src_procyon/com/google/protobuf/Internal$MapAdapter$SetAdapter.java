package com.google.protobuf;

import java.util.*;

class Internal$MapAdapter$SetAdapter extends AbstractSet
{
    private final Set realSet;
    final /* synthetic */ Internal$MapAdapter this$0;
    
    public Internal$MapAdapter$SetAdapter(final Internal$MapAdapter this$0, final Set realSet) {
        this.this$0 = this$0;
        this.realSet = realSet;
    }
    
    public Iterator iterator() {
        return new Internal$MapAdapter$IteratorAdapter(this.this$0, this.realSet.iterator());
    }
    
    public int size() {
        return this.realSet.size();
    }
}
