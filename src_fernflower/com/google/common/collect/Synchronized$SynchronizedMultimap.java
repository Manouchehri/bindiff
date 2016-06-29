package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMap;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultimap extends Synchronized$SynchronizedObject implements Multimap {
   transient Set keySet;
   transient Collection valuesCollection;
   transient Collection entries;
   transient Map asMap;
   transient Multiset keys;
   private static final long serialVersionUID = 0L;

   Multimap delegate() {
      return (Multimap)super.delegate();
   }

   Synchronized$SynchronizedMultimap(Multimap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   public int size() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().size();
      }
   }

   public boolean isEmpty() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().isEmpty();
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

   public boolean containsEntry(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().containsEntry(var1, var2);
      }
   }

   public Collection get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$400(this.delegate().get(var1), this.mutex);
      }
   }

   public boolean put(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().put(var1, var2);
      }
   }

   public boolean putAll(Object var1, Iterable var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().putAll(var1, var2);
      }
   }

   public boolean putAll(Multimap var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().putAll(var1);
      }
   }

   public Collection replaceValues(Object var1, Iterable var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().replaceValues(var1, var2);
      }
   }

   public boolean remove(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove(var1, var2);
      }
   }

   public Collection removeAll(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeAll(var1);
      }
   }

   public void clear() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().clear();
      }
   }

   public Set keySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.keySet == null) {
            this.keySet = Synchronized.access$300(this.delegate().keySet(), this.mutex);
         }

         return this.keySet;
      }
   }

   public Collection values() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.valuesCollection == null) {
            this.valuesCollection = Synchronized.access$500(this.delegate().values(), this.mutex);
         }

         return this.valuesCollection;
      }
   }

   public Collection entries() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.entries == null) {
            this.entries = Synchronized.access$400(this.delegate().entries(), this.mutex);
         }

         return this.entries;
      }
   }

   public Map asMap() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.asMap == null) {
            this.asMap = new Synchronized$SynchronizedAsMap(this.delegate().asMap(), this.mutex);
         }

         return this.asMap;
      }
   }

   public Multiset keys() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.keys == null) {
            this.keys = Synchronized.multiset(this.delegate().keys(), this.mutex);
         }

         return this.keys;
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
