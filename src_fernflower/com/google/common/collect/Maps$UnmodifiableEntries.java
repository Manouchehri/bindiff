package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;

class Maps$UnmodifiableEntries extends ForwardingCollection {
   private final Collection entries;

   Maps$UnmodifiableEntries(Collection var1) {
      this.entries = var1;
   }

   protected Collection delegate() {
      return this.entries;
   }

   public Iterator iterator() {
      return Maps.unmodifiableEntryIterator(this.entries.iterator());
   }

   public Object[] toArray() {
      return this.standardToArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.standardToArray(var1);
   }
}
