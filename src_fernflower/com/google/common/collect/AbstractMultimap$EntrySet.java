package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$1;
import com.google.common.collect.AbstractMultimap$Entries;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$EntrySet extends AbstractMultimap$Entries implements Set {
   // $FF: synthetic field
   final AbstractMultimap this$0;

   private AbstractMultimap$EntrySet(AbstractMultimap var1) {
      super(var1, (AbstractMultimap$1)null);
      this.this$0 = var1;
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this);
   }

   public boolean equals(@Nullable Object var1) {
      return Sets.equalsImpl(this, var1);
   }

   // $FF: synthetic method
   AbstractMultimap$EntrySet(AbstractMultimap var1, AbstractMultimap$1 var2) {
      this(var1);
   }
}
