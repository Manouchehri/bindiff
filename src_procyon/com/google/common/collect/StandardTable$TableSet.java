package com.google.common.collect;

abstract class StandardTable$TableSet extends Sets$ImprovedAbstractSet
{
    final /* synthetic */ StandardTable this$0;
    
    private StandardTable$TableSet(final StandardTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean isEmpty() {
        return this.this$0.backingMap.isEmpty();
    }
    
    @Override
    public void clear() {
        this.this$0.backingMap.clear();
    }
}
