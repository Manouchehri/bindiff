package com.google.common.collect;

import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.primitives.*;
import com.google.common.math.*;
import java.util.*;
import java.io.*;

class ConcurrentHashMultiset$2 extends AbstractIterator
{
    private Iterator mapEntries;
    final /* synthetic */ ConcurrentHashMultiset this$0;
    
    ConcurrentHashMultiset$2(final ConcurrentHashMultiset this$0) {
        this.this$0 = this$0;
        this.mapEntries = this.this$0.countMap.entrySet().iterator();
    }
    
    @Override
    protected Multiset$Entry computeNext() {
        while (this.mapEntries.hasNext()) {
            final Map.Entry<K, AtomicInteger> entry = this.mapEntries.next();
            final int value = entry.getValue().get();
            if (value != 0) {
                return Multisets.immutableEntry(entry.getKey(), value);
            }
        }
        return (Multiset$Entry)this.endOfData();
    }
}
