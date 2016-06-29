package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$KeySet extends Maps$KeySet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$KeySet(AbstractMapBasedMultimap var1, Map var2) {
      super(var2);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      Iterator var1 = this.map().entrySet().iterator();
      return new AbstractMapBasedMultimap$KeySet$1(this, var1);
   }

   public boolean remove(Object var1) {
      int var2 = 0;
      Collection var3 = (Collection)this.map().remove(var1);
      if(var3 != null) {
         var2 = var3.size();
         var3.clear();
         AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - var2);
      }

      return var2 > 0;
   }

   public void clear() {
      Iterators.clear(this.iterator());
   }

   public boolean containsAll(Collection var1) {
      return this.map().keySet().containsAll(var1);
   }

   public boolean equals(@Nullable Object var1) {
      return this == var1 || this.map().keySet().equals(var1);
   }

   public int hashCode() {
      return this.map().keySet().hashCode();
   }
}
