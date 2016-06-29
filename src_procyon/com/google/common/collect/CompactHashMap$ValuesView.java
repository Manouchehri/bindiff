package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;

class CompactHashMap$ValuesView extends Maps$Values
{
    final /* synthetic */ CompactHashMap this$0;
    
    CompactHashMap$ValuesView(final CompactHashMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Iterator iterator() {
        return new CompactHashMap$ValuesView$1(this);
    }
    
    @Override
    public Object[] toArray() {
        return ObjectArrays.copyAsObjectArray(this.this$0.values, 0, this.this$0.size);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return ObjectArrays.toArrayImpl(this.this$0.values, 0, this.this$0.size, array);
    }
}
