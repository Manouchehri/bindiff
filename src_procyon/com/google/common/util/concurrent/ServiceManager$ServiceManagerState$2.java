package com.google.common.util.concurrent;

class ServiceManager$ServiceManagerState$2 extends Monitor$Guard
{
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;
    
    ServiceManager$ServiceManagerState$2(final ServiceManager$ServiceManagerState this$0, final Monitor monitor) {
        this.this$0 = this$0;
        super(monitor);
    }
    
    @Override
    public boolean isSatisfied() {
        return this.this$0.states.count(Service$State.TERMINATED) + this.this$0.states.count(Service$State.FAILED) == this.this$0.numberOfServices;
    }
}
