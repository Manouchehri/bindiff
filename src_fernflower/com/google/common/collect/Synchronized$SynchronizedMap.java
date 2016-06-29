package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMap extends Synchronized$SynchronizedObject implements Map {
   transient Set keySet;
   transient Collection values;
   transient Set entrySet;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedMap(Map var1, @Nullable Object var2) {
      super(var1, var2);
   }

   Map delegate() {
      return (Map)super.delegate();
   }

   public void clear() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().clear();
      }
   }

   public boolean containsKey(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().containsKey(var1);
      }
   }

   public boolean containsValue(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().containsValue(var1);
      }
   }

   public Set entrySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.entrySet == null) {
            this.entrySet = Synchronized.set(this.delegate().entrySet(), this.mutex);
         }

         return this.entrySet;
      }
   }

   public Object get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().get(var1);
      }
   }

   public boolean isEmpty() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().isEmpty();
      }
   }

   public Set keySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.keySet == null) {
            this.keySet = Synchronized.set(this.delegate().keySet(), this.mutex);
         }

         return this.keySet;
      }
   }

   public Object put(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().put(var1, var2);
      }
   }

   public void putAll(Map var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().putAll(var1);
      }
   }

   public Object remove(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove(var1);
      }
   }

   public int size() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().size();
      }
   }

   public Collection values() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.values == null) {
            this.values = Synchronized.access$500(this.delegate().values(), this.mutex);
         }

         return this.values;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else {
         Object var2 = this.mutex;
         synchronized(this.mutex) {
            return this.delegate().equals(var1);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().hashCode();
      }
   }
}
