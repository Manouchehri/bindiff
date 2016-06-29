package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapEntries extends Synchronized$SynchronizedSet {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedAsMapEntries(Set var1, @Nullable Object var2) {
      super(var1, var2);
   }

   public Iterator iterator() {
      return new Synchronized$SynchronizedAsMapEntries$1(this, super.iterator());
   }

   public Object[] toArray() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return ObjectArrays.toArrayImpl(this.delegate());
      }
   }

   public Object[] toArray(Object[] var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return ObjectArrays.toArrayImpl(this.delegate(), var1);
      }
   }

   public boolean contains(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Maps.containsEntryImpl(this.delegate(), var1);
      }
   }

   public boolean containsAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Collections2.containsAllImpl(this.delegate(), var1);
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else {
         Object var2 = this.mutex;
         synchronized(this.mutex) {
            return Sets.equalsImpl(this.delegate(), var1);
         }
      }
   }

   public boolean remove(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Maps.removeEntryImpl(this.delegate(), var1);
      }
   }

   public boolean removeAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Iterators.removeAll(this.delegate().iterator(), var1);
      }
   }

   public boolean retainAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Iterators.retainAll(this.delegate().iterator(), var1);
      }
   }
}
