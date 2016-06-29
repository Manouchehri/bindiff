package com.google.common.collect;

import java.util.*;

class HashBiMap$1 extends HashBiMap$Itr
{
    final /* synthetic */ HashBiMap this$0;
    
    HashBiMap$1(final HashBiMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    Map.Entry output(final HashBiMap$BiEntry hashBiMap$BiEntry) {
        return new HashBiMap$1$MapEntry(this, hashBiMap$BiEntry);
    }
}
