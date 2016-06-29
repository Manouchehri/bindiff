package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;

final class CollectionHelpers$1 implements IItemCallback {
   // $FF: synthetic field
   final ICollectionFilter val$filter;
   // $FF: synthetic field
   final IItemCallback val$callback;

   CollectionHelpers$1(ICollectionFilter var1, IItemCallback var2) {
      this.val$filter = var1;
      this.val$callback = var2;
   }

   public IterationMode next(Object var1) {
      return this.val$filter.qualifies(var1)?this.val$callback.next(var1):IterationMode.CONTINUE;
   }
}
