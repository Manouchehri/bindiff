package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.BiMap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedBiMap extends Synchronized$SynchronizedMap implements BiMap, Serializable {
   private transient Set valueSet;
   private transient BiMap inverse;
   private static final long serialVersionUID = 0L;

   private Synchronized$SynchronizedBiMap(BiMap var1, @Nullable Object var2, @Nullable BiMap var3) {
      super(var1, var2);
      this.inverse = var3;
   }

   BiMap delegate() {
      return (BiMap)super.delegate();
   }

   public Set values() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.valueSet == null) {
            this.valueSet = Synchronized.set(this.delegate().values(), this.mutex);
         }

         return this.valueSet;
      }
   }

   public Object forcePut(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().forcePut(var1, var2);
      }
   }

   public BiMap inverse() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.inverse == null) {
            this.inverse = new Synchronized$SynchronizedBiMap(this.delegate().inverse(), this.mutex, this);
         }

         return this.inverse;
      }
   }

   // $FF: synthetic method
   Synchronized$SynchronizedBiMap(BiMap var1, Object var2, BiMap var3, Synchronized$1 var4) {
      this(var1, var2, var3);
   }
}
