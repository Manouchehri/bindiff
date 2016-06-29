package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedCollection extends AbstractCollection {
   final Object key;
   Collection delegate;
   final AbstractMapBasedMultimap$WrappedCollection ancestor;
   final Collection ancestorDelegate;
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$WrappedCollection(AbstractMapBasedMultimap var1, @Nullable Object var2, Collection var3, @Nullable AbstractMapBasedMultimap$WrappedCollection var4) {
      this.this$0 = var1;
      this.key = var2;
      this.delegate = var3;
      this.ancestor = var4;
      this.ancestorDelegate = var4 == null?null:var4.getDelegate();
   }

   void refreshIfEmpty() {
      if(this.ancestor != null) {
         this.ancestor.refreshIfEmpty();
         if(this.ancestor.getDelegate() != this.ancestorDelegate) {
            throw new ConcurrentModificationException();
         }
      } else if(this.delegate.isEmpty()) {
         Collection var1 = (Collection)AbstractMapBasedMultimap.access$000(this.this$0).get(this.key);
         if(var1 != null) {
            this.delegate = var1;
         }
      }

   }

   void removeIfEmpty() {
      if(this.ancestor != null) {
         this.ancestor.removeIfEmpty();
      } else if(this.delegate.isEmpty()) {
         AbstractMapBasedMultimap.access$000(this.this$0).remove(this.key);
      }

   }

   Object getKey() {
      return this.key;
   }

   void addToMap() {
      if(this.ancestor != null) {
         this.ancestor.addToMap();
      } else {
         AbstractMapBasedMultimap.access$000(this.this$0).put(this.key, this.delegate);
      }

   }

   public int size() {
      this.refreshIfEmpty();
      return this.delegate.size();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else {
         this.refreshIfEmpty();
         return this.delegate.equals(var1);
      }
   }

   public int hashCode() {
      this.refreshIfEmpty();
      return this.delegate.hashCode();
   }

   public String toString() {
      this.refreshIfEmpty();
      return this.delegate.toString();
   }

   Collection getDelegate() {
      return this.delegate;
   }

   public Iterator iterator() {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this);
   }

   public boolean add(Object var1) {
      this.refreshIfEmpty();
      boolean var2 = this.delegate.isEmpty();
      boolean var3 = this.delegate.add(var1);
      if(var3) {
         AbstractMapBasedMultimap.access$208(this.this$0);
         if(var2) {
            this.addToMap();
         }
      }

      return var3;
   }

   AbstractMapBasedMultimap$WrappedCollection getAncestor() {
      return this.ancestor;
   }

   public boolean addAll(Collection var1) {
      if(var1.isEmpty()) {
         return false;
      } else {
         int var2 = this.size();
         boolean var3 = this.delegate.addAll(var1);
         if(var3) {
            int var4 = this.delegate.size();
            AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (var4 - var2));
            if(var2 == 0) {
               this.addToMap();
            }
         }

         return var3;
      }
   }

   public boolean contains(Object var1) {
      this.refreshIfEmpty();
      return this.delegate.contains(var1);
   }

   public boolean containsAll(Collection var1) {
      this.refreshIfEmpty();
      return this.delegate.containsAll(var1);
   }

   public void clear() {
      int var1 = this.size();
      if(var1 != 0) {
         this.delegate.clear();
         AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - var1);
         this.removeIfEmpty();
      }
   }

   public boolean remove(Object var1) {
      this.refreshIfEmpty();
      boolean var2 = this.delegate.remove(var1);
      if(var2) {
         AbstractMapBasedMultimap.access$210(this.this$0);
         this.removeIfEmpty();
      }

      return var2;
   }

   public boolean removeAll(Collection var1) {
      if(var1.isEmpty()) {
         return false;
      } else {
         int var2 = this.size();
         boolean var3 = this.delegate.removeAll(var1);
         if(var3) {
            int var4 = this.delegate.size();
            AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (var4 - var2));
            this.removeIfEmpty();
         }

         return var3;
      }
   }

   public boolean retainAll(Collection var1) {
      Preconditions.checkNotNull(var1);
      int var2 = this.size();
      boolean var3 = this.delegate.retainAll(var1);
      if(var3) {
         int var4 = this.delegate.size();
         AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (var4 - var2));
         this.removeIfEmpty();
      }

      return var3;
   }
}
