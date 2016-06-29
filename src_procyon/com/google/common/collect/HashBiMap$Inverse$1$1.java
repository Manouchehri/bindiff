package com.google.common.collect;

import java.util.*;

class HashBiMap$Inverse$1$1 extends HashBiMap$Itr
{
    final /* synthetic */ HashBiMap$Inverse$1 this$2;
    
    HashBiMap$Inverse$1$1(final HashBiMap$Inverse$1 this$2) {
        this.this$2 = this$2;
        super(this$2.this$1.this$0);
    }
    
    @Override
    Map.Entry output(final HashBiMap$BiEntry hashBiMap$BiEntry) {
        return new HashBiMap$Inverse$1$1$InverseEntry(this, hashBiMap$BiEntry);
    }
}
