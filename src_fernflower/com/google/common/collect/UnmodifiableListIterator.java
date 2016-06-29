package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ListIterator;

@GwtCompatible
public abstract class UnmodifiableListIterator extends UnmodifiableIterator implements ListIterator {
   @Deprecated
   public final void add(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void set(Object var1) {
      throw new UnsupportedOperationException();
   }
}
