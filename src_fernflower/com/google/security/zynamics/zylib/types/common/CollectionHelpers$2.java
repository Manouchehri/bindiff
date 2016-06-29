package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class CollectionHelpers$2 implements IItemCallback {
   // $FF: synthetic field
   final IFilteredItemCallback val$callback;

   CollectionHelpers$2(IFilteredItemCallback var1) {
      this.val$callback = var1;
   }

   public IterationMode next(Object var1) {
      return this.val$callback.qualifies(var1)?this.val$callback.next(var1):IterationMode.CONTINUE;
   }
}
