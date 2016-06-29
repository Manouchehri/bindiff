package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

final class HashBiMap$KeySet extends Maps$KeySet
{
    final /* synthetic */ HashBiMap this$0;
    
    HashBiMap$KeySet(final HashBiMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Iterator iterator() {
        return new HashBiMap$KeySet$1(this);
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        final HashBiMap$BiEntry access$300 = this.this$0.seekByKey(o, Hashing.smearedHash(o));
        if (access$300 == null) {
            return false;
        }
        this.this$0.delete(access$300);
        access$300.prevInKeyInsertionOrder = null;
        access$300.nextInKeyInsertionOrder = null;
        return true;
    }
}
