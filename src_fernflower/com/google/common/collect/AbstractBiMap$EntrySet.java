package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.AbstractBiMap$EntrySet$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet extends ForwardingSet {
   final Set esDelegate;
   // $FF: synthetic field
   final AbstractBiMap this$0;

   private AbstractBiMap$EntrySet(AbstractBiMap var1) {
      this.this$0 = var1;
      this.esDelegate = AbstractBiMap.access$200(this.this$0).entrySet();
   }

   protected Set delegate() {
      return this.esDelegate;
   }

   public void clear() {
      this.this$0.clear();
   }

   public boolean remove(Object var1) {
      if(!this.esDelegate.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         AbstractBiMap.access$200(this.this$0.inverse).remove(var2.getValue());
         this.esDelegate.remove(var2);
         return true;
      }
   }

   public Iterator iterator() {
      Iterator var1 = this.esDelegate.iterator();
      return new AbstractBiMap$EntrySet$1(this, var1);
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }

   public boolean contains(Object var1) {
      return Maps.containsEntryImpl(this.delegate(), var1);
   }

   public boolean containsAll(Collection var1) {
      return this.standardContainsAll(var1);
   }

   public boolean removeAll(Collection var1) {
      return this.standardRemoveAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.standardRetainAll(var1);
   }

   // $FF: synthetic method
   AbstractBiMap$EntrySet(AbstractBiMap var1, AbstractBiMap$1 var2) {
      this(var1);
   }
}
