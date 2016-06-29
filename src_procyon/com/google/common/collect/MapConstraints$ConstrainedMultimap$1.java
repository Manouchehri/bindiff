package com.google.common.collect;

class MapConstraints$ConstrainedMultimap$1 implements Constraint
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ MapConstraints$ConstrainedMultimap this$0;
    
    MapConstraints$ConstrainedMultimap$1(final MapConstraints$ConstrainedMultimap this$0, final Object val$key) {
        this.this$0 = this$0;
        this.val$key = val$key;
    }
    
    @Override
    public Object checkElement(final Object o) {
        this.this$0.constraint.checkKeyValue(this.val$key, o);
        return o;
    }
}
