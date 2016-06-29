package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class AbstractBiMap$KeySet extends ForwardingSet {
   // $FF: synthetic field
   final AbstractBiMap this$0;

   private AbstractBiMap$KeySet(AbstractBiMap var1) {
      this.this$0 = var1;
   }

   protected Set delegate() {
      return AbstractBiMap.access$200(this.this$0).keySet();
   }

   public void clear() {
      this.this$0.clear();
   }

   public boolean remove(Object var1) {
      if(!this.contains(var1)) {
         return false;
      } else {
         AbstractBiMap.access$300(this.this$0, var1);
         return true;
      }
   }

   public boolean removeAll(Collection var1) {
      return this.standardRemoveAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.standardRetainAll(var1);
   }

   public Iterator iterator() {
      return Maps.keyIterator(this.this$0.entrySet().iterator());
   }

   // $FF: synthetic method
   AbstractBiMap$KeySet(AbstractBiMap var1, AbstractBiMap$1 var2) {
      this(var1);
   }
}
