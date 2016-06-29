package com.google.common.util.concurrent;

class AbstractService$5 extends Monitor$Guard
{
    final /* synthetic */ AbstractService this$0;
    
    AbstractService$5(final AbstractService this$0, final Monitor monitor) {
        this.this$0 = this$0;
        super(monitor);
    }
    
    @Override
    public boolean isSatisfied() {
        return this.this$0.state() == Service$State.NEW;
    }
}
