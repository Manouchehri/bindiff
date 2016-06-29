package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

final class HashBiMap$Inverse$InverseKeySet extends Maps$KeySet
{
    final /* synthetic */ HashBiMap$Inverse this$1;
    
    HashBiMap$Inverse$InverseKeySet(final HashBiMap$Inverse this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        final HashBiMap$BiEntry access$400 = this.this$1.this$0.seekByValue(o, Hashing.smearedHash(o));
        if (access$400 == null) {
            return false;
        }
        this.this$1.this$0.delete(access$400);
        return true;
    }
    
    @Override
    public Iterator iterator() {
        return new HashBiMap$Inverse$InverseKeySet$1(this);
    }
}
