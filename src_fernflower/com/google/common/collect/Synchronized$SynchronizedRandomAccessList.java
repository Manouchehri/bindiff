package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedList;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Synchronized$SynchronizedRandomAccessList extends Synchronized$SynchronizedList implements RandomAccess {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedRandomAccessList(List var1, @Nullable Object var2) {
      super(var1, var2);
   }
}
