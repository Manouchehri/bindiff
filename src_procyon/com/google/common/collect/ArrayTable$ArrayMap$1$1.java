package com.google.common.collect;

class ArrayTable$ArrayMap$1$1 extends AbstractMapEntry
{
    final /* synthetic */ int val$index;
    final /* synthetic */ ArrayTable$ArrayMap$1 this$1;
    
    ArrayTable$ArrayMap$1$1(final ArrayTable$ArrayMap$1 this$1, final int val$index) {
        this.this$1 = this$1;
        this.val$index = val$index;
    }
    
    @Override
    public Object getKey() {
        return this.this$1.this$0.getKey(this.val$index);
    }
    
    @Override
    public Object getValue() {
        return this.this$1.this$0.getValue(this.val$index);
    }
    
    @Override
    public Object setValue(final Object o) {
        return this.this$1.this$0.setValue(this.val$index, o);
    }
}
