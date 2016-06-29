package com.google.common.collect;

class WellBehavedMap$EntrySet$1$1 extends AbstractMapEntry
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ WellBehavedMap$EntrySet$1 this$2;
    
    WellBehavedMap$EntrySet$1$1(final WellBehavedMap$EntrySet$1 this$2, final Object val$key) {
        this.this$2 = this$2;
        this.val$key = val$key;
    }
    
    @Override
    public Object getKey() {
        return this.val$key;
    }
    
    @Override
    public Object getValue() {
        return this.this$2.this$1.this$0.get(this.val$key);
    }
    
    @Override
    public Object setValue(final Object o) {
        return this.this$2.this$1.this$0.put(this.val$key, o);
    }
}
