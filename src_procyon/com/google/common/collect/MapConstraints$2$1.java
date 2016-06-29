package com.google.common.collect;

class MapConstraints$2$1 implements Constraint
{
    final /* synthetic */ MapConstraints$2 this$0;
    
    MapConstraints$2$1(final MapConstraints$2 this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Object checkElement(final Object o) {
        this.this$0.val$constraint.checkKeyValue(this.this$0.getKey(), o);
        return o;
    }
}
