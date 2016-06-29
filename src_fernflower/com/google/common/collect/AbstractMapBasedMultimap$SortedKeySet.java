package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedKeySet extends AbstractMapBasedMultimap$KeySet implements SortedSet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$SortedKeySet(AbstractMapBasedMultimap var1, SortedMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   SortedMap sortedMap() {
      return (SortedMap)super.map();
   }

   public Comparator comparator() {
      return this.sortedMap().comparator();
   }

   public Object first() {
      return this.sortedMap().firstKey();
   }

   public SortedSet headSet(Object var1) {
      return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().headMap(var1));
   }

   public Object last() {
      return this.sortedMap().lastKey();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().subMap(var1, var2));
   }

   public SortedSet tailSet(Object var1) {
      return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().tailMap(var1));
   }
}
