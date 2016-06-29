package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Set;

class AbstractBiMap$ValueSet extends ForwardingSet {
   final Set valuesDelegate;
   // $FF: synthetic field
   final AbstractBiMap this$0;

   private AbstractBiMap$ValueSet(AbstractBiMap var1) {
      this.this$0 = var1;
      this.valuesDelegate = this.this$0.inverse.keySet();
   }

   protected Set delegate() {
      return this.valuesDelegate;
   }

   public Iterator iterator() {
      return Maps.valueIterator(this.this$0.entrySet().iterator());
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public String toString() {
      return this.standardToString();
   }

   // $FF: synthetic method
   AbstractBiMap$ValueSet(AbstractBiMap var1, AbstractBiMap$1 var2) {
      this(var1);
   }
}
