package com.google.common.collect;

import com.google.common.collect.Maps$KeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedKeySet extends Maps$KeySet implements SortedSet {
   Maps$SortedKeySet(SortedMap var1) {
      super(var1);
   }

   SortedMap map() {
      return (SortedMap)super.map();
   }

   public Comparator comparator() {
      return this.map().comparator();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return new Maps$SortedKeySet(this.map().subMap(var1, var2));
   }

   public SortedSet headSet(Object var1) {
      return new Maps$SortedKeySet(this.map().headMap(var1));
   }

   public SortedSet tailSet(Object var1) {
      return new Maps$SortedKeySet(this.map().tailMap(var1));
   }

   public Object first() {
      return this.map().firstKey();
   }

   public Object last() {
      return this.map().lastKey();
   }
}
