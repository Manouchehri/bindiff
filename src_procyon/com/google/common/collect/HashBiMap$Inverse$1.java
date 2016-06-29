package com.google.common.collect;

import java.util.*;

class HashBiMap$Inverse$1 extends Maps$EntrySet
{
    final /* synthetic */ HashBiMap$Inverse this$1;
    
    HashBiMap$Inverse$1(final HashBiMap$Inverse this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    Map map() {
        return this.this$1;
    }
    
    @Override
    public Iterator iterator() {
        return new HashBiMap$Inverse$1$1(this);
    }
}
