package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$Itr;
import com.google.common.collect.Maps;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$2 extends AbstractMapBasedMultimap$Itr {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$2(AbstractMapBasedMultimap var1) {
      super(var1);
      this.this$0 = var1;
   }

   Entry output(Object var1, Object var2) {
      return Maps.immutableEntry(var1, var2);
   }
}
