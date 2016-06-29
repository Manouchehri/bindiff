package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$Itr;
import com.google.common.collect.Maps;
import java.util.Map.Entry;

class ImmutableMultimap$1 extends ImmutableMultimap$Itr {
   // $FF: synthetic field
   final ImmutableMultimap this$0;

   ImmutableMultimap$1(ImmutableMultimap var1) {
      super(var1, (ImmutableMultimap$1)null);
      this.this$0 = var1;
   }

   Entry output(Object var1, Object var2) {
      return Maps.immutableEntry(var1, var2);
   }
}
