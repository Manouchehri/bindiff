package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSet extends AbstractMapBasedMultimap$WrappedCollection implements Set {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$WrappedSet(AbstractMapBasedMultimap var1, @Nullable Object var2, Set var3) {
      super(var1, var2, var3, (AbstractMapBasedMultimap$WrappedCollection)null);
      this.this$0 = var1;
   }

   public boolean removeAll(Collection var1) {
      if(var1.isEmpty()) {
         return false;
      } else {
         int var2 = this.size();
         boolean var3 = Sets.removeAllImpl((Set)this.delegate, var1);
         if(var3) {
            int var4 = this.delegate.size();
            AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) + (var4 - var2));
            this.removeIfEmpty();
         }

         return var3;
      }
   }
}
