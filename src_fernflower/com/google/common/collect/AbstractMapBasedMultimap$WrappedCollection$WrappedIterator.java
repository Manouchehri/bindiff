package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class AbstractMapBasedMultimap$WrappedCollection$WrappedIterator implements Iterator {
   final Iterator delegateIterator;
   final Collection originalDelegate;
   // $FF: synthetic field
   final AbstractMapBasedMultimap$WrappedCollection this$1;

   AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection var1) {
      this.this$1 = var1;
      this.originalDelegate = this.this$1.delegate;
      this.delegateIterator = AbstractMapBasedMultimap.access$100(var1.this$0, var1.delegate);
   }

   AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection var1, Iterator var2) {
      this.this$1 = var1;
      this.originalDelegate = this.this$1.delegate;
      this.delegateIterator = var2;
   }

   void validateIterator() {
      this.this$1.refreshIfEmpty();
      if(this.this$1.delegate != this.originalDelegate) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      this.validateIterator();
      return this.delegateIterator.hasNext();
   }

   public Object next() {
      this.validateIterator();
      return this.delegateIterator.next();
   }

   public void remove() {
      this.delegateIterator.remove();
      AbstractMapBasedMultimap.access$210(this.this$1.this$0);
      this.this$1.removeIfEmpty();
   }

   Iterator getDelegateIterator() {
      this.validateIterator();
      return this.delegateIterator;
   }
}
