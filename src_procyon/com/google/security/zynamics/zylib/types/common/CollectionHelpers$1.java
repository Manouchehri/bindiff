package com.google.security.zynamics.zylib.types.common;

final class CollectionHelpers$1 implements IItemCallback
{
    final /* synthetic */ ICollectionFilter val$filter;
    final /* synthetic */ IItemCallback val$callback;
    
    CollectionHelpers$1(final ICollectionFilter val$filter, final IItemCallback val$callback) {
        this.val$filter = val$filter;
        this.val$callback = val$callback;
    }
    
    @Override
    public IterationMode next(final Object o) {
        if (this.val$filter.qualifies(o)) {
            return this.val$callback.next(o);
        }
        return IterationMode.CONTINUE;
    }
}
