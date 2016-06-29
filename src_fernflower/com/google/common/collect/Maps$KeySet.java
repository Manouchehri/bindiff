package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;

class Maps$KeySet extends Sets$ImprovedAbstractSet {
   @Weak
   final Map map;

   Maps$KeySet(Map var1) {
      this.map = (Map)Preconditions.checkNotNull(var1);
   }

   Map map() {
      return this.map;
   }

   public Iterator iterator() {
      return Maps.keyIterator(this.map().entrySet().iterator());
   }

   public int size() {
      return this.map().size();
   }

   public boolean isEmpty() {
      return this.map().isEmpty();
   }

   public boolean contains(Object var1) {
      return this.map().containsKey(var1);
   }

   public boolean remove(Object var1) {
      if(this.contains(var1)) {
         this.map().remove(var1);
         return true;
      } else {
         return false;
      }
   }

   public void clear() {
      this.map().clear();
   }
}
