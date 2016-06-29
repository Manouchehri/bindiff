package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapValues extends Synchronized$SynchronizedCollection {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedAsMapValues(Collection var1, @Nullable Object var2) {
      super(var1, var2, (Synchronized$1)null);
   }

   public Iterator iterator() {
      return new Synchronized$SynchronizedAsMapValues$1(this, super.iterator());
   }
}
