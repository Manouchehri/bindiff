package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMap extends Synchronized$SynchronizedMap {
   transient Set asMapEntrySet;
   transient Collection asMapValues;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedAsMap(Map var1, @Nullable Object var2) {
      super(var1, var2);
   }

   public Collection get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         Collection var3 = (Collection)super.get(var1);
         return var3 == null?null:Synchronized.access$400(var3, this.mutex);
      }
   }

   public Set entrySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.asMapEntrySet == null) {
            this.asMapEntrySet = new Synchronized$SynchronizedAsMapEntries(this.delegate().entrySet(), this.mutex);
         }

         return this.asMapEntrySet;
      }
   }

   public Collection values() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.asMapValues == null) {
            this.asMapValues = new Synchronized$SynchronizedAsMapValues(this.delegate().values(), this.mutex);
         }

         return this.asMapValues;
      }
   }

   public boolean containsValue(Object var1) {
      return this.values().contains(var1);
   }
}
