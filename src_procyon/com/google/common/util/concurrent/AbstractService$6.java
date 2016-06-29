package com.google.common.util.concurrent;

class AbstractService$6 extends Monitor$Guard
{
    final /* synthetic */ AbstractService this$0;
    
    AbstractService$6(final AbstractService this$0, final Monitor monitor) {
        this.this$0 = this$0;
        super(monitor);
    }
    
    @Override
    public boolean isSatisfied() {
        return this.this$0.state().compareTo(Service$State.RUNNING) <= 0;
    }
}
