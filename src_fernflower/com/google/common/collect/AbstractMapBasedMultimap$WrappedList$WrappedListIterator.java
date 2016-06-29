package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.ListIterator;

class AbstractMapBasedMultimap$WrappedList$WrappedListIterator extends AbstractMapBasedMultimap$WrappedCollection$WrappedIterator implements ListIterator {
   // $FF: synthetic field
   final AbstractMapBasedMultimap$WrappedList this$1;

   AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList var1) {
      super(var1);
      this.this$1 = var1;
   }

   public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList var1, int var2) {
      super(var1, var1.getListDelegate().listIterator(var2));
      this.this$1 = var1;
   }

   private ListIterator getDelegateListIterator() {
      return (ListIterator)this.getDelegateIterator();
   }

   public boolean hasPrevious() {
      return this.getDelegateListIterator().hasPrevious();
   }

   public Object previous() {
      return this.getDelegateListIterator().previous();
   }

   public int nextIndex() {
      return this.getDelegateListIterator().nextIndex();
   }

   public int previousIndex() {
      return this.getDelegateListIterator().previousIndex();
   }

   public void set(Object var1) {
      this.getDelegateListIterator().set(var1);
   }

   public void add(Object var1) {
      boolean var2 = this.this$1.isEmpty();
      this.getDelegateListIterator().add(var1);
      AbstractMapBasedMultimap.access$208(this.this$1.this$0);
      if(var2) {
         this.this$1.addToMap();
      }

   }
}
