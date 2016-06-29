package com.google.common.collect;

class HashBiMap$Inverse$InverseKeySet$1 extends HashBiMap$Itr
{
    final /* synthetic */ HashBiMap$Inverse$InverseKeySet this$2;
    
    HashBiMap$Inverse$InverseKeySet$1(final HashBiMap$Inverse$InverseKeySet this$2) {
        this.this$2 = this$2;
        super(this$2.this$1.this$0);
    }
    
    @Override
    Object output(final HashBiMap$BiEntry hashBiMap$BiEntry) {
        return hashBiMap$BiEntry.value;
    }
}
