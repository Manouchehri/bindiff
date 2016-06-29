package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

class CompactHashMap$EntrySetView extends Maps$EntrySet
{
    final /* synthetic */ CompactHashMap this$0;
    
    CompactHashMap$EntrySetView(final CompactHashMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return new CompactHashMap$EntrySetView$1(this);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final int access$200 = this.this$0.indexOf(entry.getKey());
            return access$200 != -1 && Objects.equal(this.this$0.values[access$200], entry.getValue());
        }
        return false;
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final int access$200 = this.this$0.indexOf(entry.getKey());
            if (access$200 != -1 && Objects.equal(this.this$0.values[access$200], entry.getValue())) {
                this.this$0.removeEntry(access$200);
                return true;
            }
        }
        return false;
    }
}
