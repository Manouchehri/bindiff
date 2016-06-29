package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class FilteredKeyMultimap$Entries extends ForwardingCollection
{
    final /* synthetic */ FilteredKeyMultimap this$0;
    
    FilteredKeyMultimap$Entries(final FilteredKeyMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected Collection delegate() {
        return Collections2.filter(this.this$0.unfiltered.entries(), this.this$0.entryPredicate());
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            if (this.this$0.unfiltered.containsKey(entry.getKey()) && this.this$0.keyPredicate.apply(entry.getKey())) {
                return this.this$0.unfiltered.remove(entry.getKey(), entry.getValue());
            }
        }
        return false;
    }
}
