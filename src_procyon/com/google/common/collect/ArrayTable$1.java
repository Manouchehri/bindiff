package com.google.common.collect;

class ArrayTable$1 extends AbstractIndexedListIterator
{
    final /* synthetic */ ArrayTable this$0;
    
    ArrayTable$1(final ArrayTable this$0, final int n) {
        this.this$0 = this$0;
        super(n);
    }
    
    @Override
    protected Table$Cell get(final int n) {
        return new ArrayTable$1$1(this, n);
    }
}
