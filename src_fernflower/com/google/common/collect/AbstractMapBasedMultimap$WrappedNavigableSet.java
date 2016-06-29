package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedSortedSet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$WrappedNavigableSet extends AbstractMapBasedMultimap$WrappedSortedSet implements NavigableSet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$WrappedNavigableSet(AbstractMapBasedMultimap var1, @Nullable Object var2, NavigableSet var3, @Nullable AbstractMapBasedMultimap$WrappedCollection var4) {
      super(var1, var2, var3, var4);
      this.this$0 = var1;
   }

   NavigableSet getSortedSetDelegate() {
      return (NavigableSet)super.getSortedSetDelegate();
   }

   public Object lower(Object var1) {
      return this.getSortedSetDelegate().lower(var1);
   }

   public Object floor(Object var1) {
      return this.getSortedSetDelegate().floor(var1);
   }

   public Object ceiling(Object var1) {
      return this.getSortedSetDelegate().ceiling(var1);
   }

   public Object higher(Object var1) {
      return this.getSortedSetDelegate().higher(var1);
   }

   public Object pollFirst() {
      return Iterators.pollNext(this.iterator());
   }

   public Object pollLast() {
      return Iterators.pollNext(this.descendingIterator());
   }

   private NavigableSet wrap(NavigableSet var1) {
      return new AbstractMapBasedMultimap$WrappedNavigableSet(this.this$0, this.key, var1, (AbstractMapBasedMultimap$WrappedCollection)(this.getAncestor() == null?this:this.getAncestor()));
   }

   public NavigableSet descendingSet() {
      return this.wrap(this.getSortedSetDelegate().descendingSet());
   }

   public Iterator descendingIterator() {
      return new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this, this.getSortedSetDelegate().descendingIterator());
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return this.wrap(this.getSortedSetDelegate().subSet(var1, var2, var3, var4));
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return this.wrap(this.getSortedSetDelegate().headSet(var1, var2));
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return this.wrap(this.getSortedSetDelegate().tailSet(var1, var2));
   }
}
