package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

final class CompactHashMap$MapEntry extends AbstractMapEntry
{
    @Nullable
    private final Object key;
    private int lastKnownIndex;
    final /* synthetic */ CompactHashMap this$0;
    
    CompactHashMap$MapEntry(final CompactHashMap this$0, final int lastKnownIndex) {
        this.this$0 = this$0;
        this.key = this$0.keys[lastKnownIndex];
        this.lastKnownIndex = lastKnownIndex;
    }
    
    @Override
    public Object getKey() {
        return this.key;
    }
    
    @Override
    public Object getValue() {
        if (this.lastKnownIndex == -1 || this.lastKnownIndex >= this.this$0.size() || !Objects.equal(this.key, this.this$0.keys[this.lastKnownIndex])) {
            this.lastKnownIndex = this.this$0.indexOf(this.key);
        }
        return (this.lastKnownIndex == -1) ? null : this.this$0.values[this.lastKnownIndex];
    }
}
