package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSortedSet extends AbstractMapBasedMultimap$WrappedCollection implements SortedSet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$WrappedSortedSet(AbstractMapBasedMultimap var1, @Nullable Object var2, SortedSet var3, @Nullable AbstractMapBasedMultimap$WrappedCollection var4) {
      super(var1, var2, var3, var4);
      this.this$0 = var1;
   }

   SortedSet getSortedSetDelegate() {
      return (SortedSet)this.getDelegate();
   }

   public Comparator comparator() {
      return this.getSortedSetDelegate().comparator();
   }

   public Object first() {
      this.refreshIfEmpty();
      return this.getSortedSetDelegate().first();
   }

   public Object last() {
      this.refreshIfEmpty();
      return this.getSortedSetDelegate().last();
   }

   public SortedSet headSet(Object var1) {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().headSet(var1), (AbstractMapBasedMultimap$WrappedCollection)(this.getAncestor() == null?this:this.getAncestor()));
   }

   public SortedSet subSet(Object var1, Object var2) {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().subSet(var1, var2), (AbstractMapBasedMultimap$WrappedCollection)(this.getAncestor() == null?this:this.getAncestor()));
   }

   public SortedSet tailSet(Object var1) {
      this.refreshIfEmpty();
      return new AbstractMapBasedMultimap$WrappedSortedSet(this.this$0, this.getKey(), this.getSortedSetDelegate().tailSet(var1), (AbstractMapBasedMultimap$WrappedCollection)(this.getAncestor() == null?this:this.getAncestor()));
   }
}
