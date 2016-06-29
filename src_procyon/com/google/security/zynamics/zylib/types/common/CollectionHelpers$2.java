package com.google.security.zynamics.zylib.types.common;

final class CollectionHelpers$2 implements IItemCallback
{
    final /* synthetic */ IFilteredItemCallback val$callback;
    
    CollectionHelpers$2(final IFilteredItemCallback val$callback) {
        this.val$callback = val$callback;
    }
    
    @Override
    public IterationMode next(final Object o) {
        if (this.val$callback.qualifies(o)) {
            return this.val$callback.next(o);
        }
        return IterationMode.CONTINUE;
    }
}
