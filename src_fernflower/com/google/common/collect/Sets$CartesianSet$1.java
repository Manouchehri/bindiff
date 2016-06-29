package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;

final class Sets$CartesianSet$1 extends ImmutableList {
   // $FF: synthetic field
   final ImmutableList val$axes;

   Sets$CartesianSet$1(ImmutableList var1) {
      this.val$axes = var1;
   }

   public int size() {
      return this.val$axes.size();
   }

   public List get(int var1) {
      return ((ImmutableSet)this.val$axes.get(var1)).asList();
   }

   boolean isPartialView() {
      return true;
   }
}
