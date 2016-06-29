package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class HashBiMap$Inverse$1$1$InverseEntry extends AbstractMapEntry
{
    HashBiMap$BiEntry delegate;
    final /* synthetic */ HashBiMap$Inverse$1$1 this$3;
    
    HashBiMap$Inverse$1$1$InverseEntry(final HashBiMap$Inverse$1$1 this$3, final HashBiMap$BiEntry delegate) {
        this.this$3 = this$3;
        this.delegate = delegate;
    }
    
    @Override
    public Object getKey() {
        return this.delegate.value;
    }
    
    @Override
    public Object getValue() {
        return this.delegate.key;
    }
    
    @Override
    public Object setValue(final Object o) {
        final Object key = this.delegate.key;
        final int smearedHash = Hashing.smearedHash(o);
        if (smearedHash == this.delegate.keyHash && Objects.equal(o, key)) {
            return o;
        }
        Preconditions.checkArgument(this.this$3.this$2.this$1.this$0.seekByKey(o, smearedHash) == null, "value already present: %s", o);
        this.this$3.this$2.this$1.this$0.delete(this.delegate);
        final HashBiMap$BiEntry delegate = new HashBiMap$BiEntry(o, smearedHash, this.delegate.value, this.delegate.valueHash);
        this.delegate = delegate;
        this.this$3.this$2.this$1.this$0.insert(delegate, null);
        this.this$3.expectedModCount = this.this$3.this$2.this$1.this$0.modCount;
        return key;
    }
}
