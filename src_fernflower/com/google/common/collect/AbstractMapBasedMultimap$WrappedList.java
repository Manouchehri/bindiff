package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList$WrappedListIterator;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedList extends AbstractMapBasedMultimap$WrappedCollection implements List {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$WrappedList(AbstractMapBasedMultimap var1, @Nullable Object var2, List var3, @Nullable AbstractMapBasedMultimap$WrappedCollection var4) {
      super(var1, var2, var3, var4);
      this.this$0 = var1;
   }

   List getListDelegate() {
      return (List)this.getDelegate();
   }

   public boolean addAll(int var1, Collection var2) {
      if(var2.isEmpty()) {
         return false;
      } else {
         int var3 = this.size();
         boolean var4 = this.getListDelegate().addAll(var1, var2);
         if(var4) {
            int var5 = this.getDelegate().size();
            AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (var5 - var3));
            if(var3 == 0) {
               this.addToMap();
            }
         }

         return var4;
      }
   }

   public Object get(int var1) {
      this.refreshIfEmpty();
      return this.getListDelegate().get(var1);
   }

   public Object set(int var1, Object var2) {
      this.refreshIfEmpty();
      return this.getListDelegate().set(var1, var2);
   }

   public void add(int var1, Object var2) {
      this.refreshIfEmpty();
      boolean var3 = this.getDelegate().isEmpty();
      this.getListDelegate().add(var1, var2);
      AbstractMapBasedMultimap.access$208(this.this$0);
      if(var3) {
         this.addToMap();
      }

   }

   public Object remove(int var1) {
      this.refreshIfEmpty();
      Object var2 = this.getListDelegate().remove(var1);
      AbstractMapBasedMultimap.access$210(this.this$0);
      this.removeIfEmpty();
      return var2;
   }

   public int indexOf(Object var1) {
      this.refreshIfEmpty();
      return this.getListDelegate().indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      this.refreshIfEmpty();
      return this.getListDelegate().lastIndexOf(var1);
   }

   public ListIterator listIterator() {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this);
   }

   public ListIterator listIterator(int var1) {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this, var1);
   }

   public List subList(int var1, int var2) {
      this.refreshIfEmpty();
      return AbstractMapBasedMultimap.access$300(this.this$0, this.getKey(), this.getListDelegate().subList(var1, var2), (AbstractMapBasedMultimap$WrappedCollection)(this.getAncestor() == null?this:this.getAncestor()));
   }
}
