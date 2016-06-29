package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtIncompatible("works but is needed only for NavigableMap")
class Synchronized$SynchronizedEntry extends Synchronized$SynchronizedObject implements Entry {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedEntry(Entry var1, @Nullable Object var2) {
      super(var1, var2);
   }

   Entry delegate() {
      return (Entry)super.delegate();
   }

   public boolean equals(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().equals(var1);
      }
   }

   public int hashCode() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().hashCode();
      }
   }

   public Object getKey() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().getKey();
      }
   }

   public Object getValue() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().getValue();
      }
   }

   public Object setValue(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().setValue(var1);
      }
   }
}
