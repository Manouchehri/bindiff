package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

class Synchronized$SynchronizedObject implements Serializable {
   final Object delegate;
   final Object mutex;
   @GwtIncompatible("not needed in emulated source")
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedObject(Object var1, @Nullable Object var2) {
      this.delegate = Preconditions.checkNotNull(var1);
      this.mutex = var2 == null?this:var2;
   }

   Object delegate() {
      return this.delegate;
   }

   public String toString() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate.toString();
      }
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         var1.defaultWriteObject();
      }
   }
}
