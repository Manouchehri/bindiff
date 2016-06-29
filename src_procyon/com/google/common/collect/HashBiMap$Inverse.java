package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

final class HashBiMap$Inverse extends AbstractMap implements BiMap, Serializable
{
    final /* synthetic */ HashBiMap this$0;
    
    private HashBiMap$Inverse(final HashBiMap this$0) {
        this.this$0 = this$0;
    }
    
    BiMap forward() {
        return this.this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.size;
    }
    
    @Override
    public void clear() {
        this.forward().clear();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.forward().containsValue(o);
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        return Maps.keyOrNull(this.this$0.seekByValue(o, Hashing.smearedHash(o)));
    }
    
    @Override
    public Object put(@Nullable final Object o, @Nullable final Object o2) {
        return this.this$0.putInverse(o, o2, false);
    }
    
    @Override
    public Object forcePut(@Nullable final Object o, @Nullable final Object o2) {
        return this.this$0.putInverse(o, o2, true);
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        final HashBiMap$BiEntry access$400 = this.this$0.seekByValue(o, Hashing.smearedHash(o));
        if (access$400 == null) {
            return null;
        }
        this.this$0.delete(access$400);
        access$400.prevInKeyInsertionOrder = null;
        access$400.nextInKeyInsertionOrder = null;
        return access$400.key;
    }
    
    @Override
    public BiMap inverse() {
        return this.forward();
    }
    
    @Override
    public Set keySet() {
        return new HashBiMap$Inverse$InverseKeySet(this);
    }
    
    @Override
    public Set values() {
        return this.forward().keySet();
    }
    
    @Override
    public Set entrySet() {
        return new HashBiMap$Inverse$1(this);
    }
    
    Object writeReplace() {
        return new HashBiMap$InverseSerializedForm(this.this$0);
    }
}
