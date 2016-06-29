package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$ArrayReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

@VisibleForTesting
class Striped$SmallLazyStriped extends Striped$PowerOfTwoStriped {
   final AtomicReferenceArray locks;
   final Supplier supplier;
   final int size;
   final ReferenceQueue queue = new ReferenceQueue();

   Striped$SmallLazyStriped(int var1, Supplier var2) {
      super(var1);
      this.size = this.mask == -1?Integer.MAX_VALUE:this.mask + 1;
      this.locks = new AtomicReferenceArray(this.size);
      this.supplier = var2;
   }

   public Object getAt(int var1) {
      if(this.size != Integer.MAX_VALUE) {
         Preconditions.checkElementIndex(var1, this.size());
      }

      Striped$SmallLazyStriped$ArrayReference var2 = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(var1);
      Object var3 = var2 == null?null:var2.get();
      if(var3 != null) {
         return var3;
      } else {
         Object var4 = this.supplier.get();
         Striped$SmallLazyStriped$ArrayReference var5 = new Striped$SmallLazyStriped$ArrayReference(var4, var1, this.queue);

         do {
            if(this.locks.compareAndSet(var1, var2, var5)) {
               this.drainQueue();
               return var4;
            }

            var2 = (Striped$SmallLazyStriped$ArrayReference)this.locks.get(var1);
            var3 = var2 == null?null:var2.get();
         } while(var3 == null);

         return var3;
      }
   }

   private void drainQueue() {
      Reference var1;
      while((var1 = this.queue.poll()) != null) {
         Striped$SmallLazyStriped$ArrayReference var2 = (Striped$SmallLazyStriped$ArrayReference)var1;
         this.locks.compareAndSet(var2.index, var2, (Object)null);
      }

   }

   public int size() {
      return this.size;
   }
}
