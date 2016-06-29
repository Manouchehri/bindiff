package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;
import javax.annotation.*;
import java.io.*;

class AbstractMapBasedMultiset$1$1 extends Multisets$AbstractEntry
{
    final /* synthetic */ Map.Entry val$mapEntry;
    final /* synthetic */ AbstractMapBasedMultiset$1 this$1;
    
    AbstractMapBasedMultiset$1$1(final AbstractMapBasedMultiset$1 this$1, final Map.Entry val$mapEntry) {
        this.this$1 = this$1;
        this.val$mapEntry = val$mapEntry;
    }
    
    @Override
    public Object getElement() {
        return this.val$mapEntry.getKey();
    }
    
    @Override
    public int getCount() {
        final Count count = this.val$mapEntry.getValue();
        if (count == null || count.get() == 0) {
            final Count count2 = this.this$1.this$0.backingMap.get(this.getElement());
            if (count2 != null) {
                return count2.get();
            }
        }
        return (count == null) ? 0 : count.get();
    }
}
