package com.google.common.util.concurrent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class Striped$SmallLazyStriped$ArrayReference extends WeakReference {
   final int index;

   Striped$SmallLazyStriped$ArrayReference(Object var1, int var2, ReferenceQueue var3) {
      super(var1, var3);
      this.index = var2;
   }
}
