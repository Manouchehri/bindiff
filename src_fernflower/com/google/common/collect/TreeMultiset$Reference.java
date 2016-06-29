package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import java.util.ConcurrentModificationException;
import javax.annotation.Nullable;

final class TreeMultiset$Reference {
   @Nullable
   private Object value;

   private TreeMultiset$Reference() {
   }

   @Nullable
   public Object get() {
      return this.value;
   }

   public void checkAndSet(@Nullable Object var1, Object var2) {
      if(this.value != var1) {
         throw new ConcurrentModificationException();
      } else {
         this.value = var2;
      }
   }

   // $FF: synthetic method
   TreeMultiset$Reference(TreeMultiset$1 var1) {
      this();
   }
}
