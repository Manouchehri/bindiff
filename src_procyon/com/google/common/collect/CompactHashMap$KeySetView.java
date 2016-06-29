package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;
import java.io.*;

class CompactHashMap$KeySetView extends Maps$KeySet
{
    final /* synthetic */ CompactHashMap this$0;
    
    CompactHashMap$KeySetView(final CompactHashMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Object[] toArray() {
        return ObjectArrays.copyAsObjectArray(this.this$0.keys, 0, this.this$0.size);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return ObjectArrays.toArrayImpl(this.this$0.keys, 0, this.this$0.size, array);
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        final int access$200 = this.this$0.indexOf(o);
        if (access$200 == -1) {
            return false;
        }
        this.this$0.removeEntry(access$200);
        return true;
    }
    
    @Override
    public Iterator iterator() {
        return new CompactHashMap$KeySetView$1(this);
    }
}
