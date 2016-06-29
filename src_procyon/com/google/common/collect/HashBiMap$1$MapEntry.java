package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class HashBiMap$1$MapEntry extends AbstractMapEntry
{
    HashBiMap$BiEntry delegate;
    final /* synthetic */ HashBiMap$1 this$1;
    
    HashBiMap$1$MapEntry(final HashBiMap$1 this$1, final HashBiMap$BiEntry delegate) {
        this.this$1 = this$1;
        this.delegate = delegate;
    }
    
    @Override
    public Object getKey() {
        return this.delegate.key;
    }
    
    @Override
    public Object getValue() {
        return this.delegate.value;
    }
    
    @Override
    public Object setValue(final Object o) {
        final Object value = this.delegate.value;
        final int smearedHash = Hashing.smearedHash(o);
        if (smearedHash == this.delegate.valueHash && Objects.equal(o, value)) {
            return o;
        }
        Preconditions.checkArgument(this.this$1.this$0.seekByValue(o, smearedHash) == null, "value already present: %s", o);
        this.this$1.this$0.delete(this.delegate);
        final HashBiMap$BiEntry hashBiMap$BiEntry = new HashBiMap$BiEntry(this.delegate.key, this.delegate.keyHash, o, smearedHash);
        this.this$1.this$0.insert(hashBiMap$BiEntry, this.delegate);
        this.delegate.prevInKeyInsertionOrder = null;
        this.delegate.nextInKeyInsertionOrder = null;
        this.this$1.expectedModCount = this.this$1.this$0.modCount;
        if (this.this$1.toRemove == this.delegate) {
            this.this$1.toRemove = hashBiMap$BiEntry;
        }
        this.delegate = hashBiMap$BiEntry;
        return value;
    }
}
