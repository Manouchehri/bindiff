package com.google.common.collect;

import java.util.*;

class DenseImmutableTable$ImmutableArrayMap$1 extends AbstractIterator
{
    private int index;
    private final int maxIndex;
    final /* synthetic */ DenseImmutableTable$ImmutableArrayMap this$0;
    
    DenseImmutableTable$ImmutableArrayMap$1(final DenseImmutableTable$ImmutableArrayMap this$0) {
        this.this$0 = this$0;
        this.index = -1;
        this.maxIndex = this.this$0.keyToIndex().size();
    }
    
    @Override
    protected Map.Entry computeNext() {
        ++this.index;
        while (this.index < this.maxIndex) {
            final Object value = this.this$0.getValue(this.index);
            if (value != null) {
                return Maps.immutableEntry(this.this$0.getKey(this.index), value);
            }
            ++this.index;
        }
        return (Map.Entry)this.endOfData();
    }
}
