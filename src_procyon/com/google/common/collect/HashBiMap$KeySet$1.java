package com.google.common.collect;

class HashBiMap$KeySet$1 extends HashBiMap$Itr
{
    final /* synthetic */ HashBiMap$KeySet this$1;
    
    HashBiMap$KeySet$1(final HashBiMap$KeySet this$1) {
        this.this$1 = this$1;
        super(this$1.this$0);
    }
    
    @Override
    Object output(final HashBiMap$BiEntry hashBiMap$BiEntry) {
        return hashBiMap$BiEntry.key;
    }
}
