package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$RandomAccessWrappedList extends AbstractMapBasedMultimap$WrappedList implements RandomAccess {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$RandomAccessWrappedList(AbstractMapBasedMultimap var1, @Nullable Object var2, List var3, @Nullable AbstractMapBasedMultimap$WrappedCollection var4) {
      super(var1, var2, var3, var4);
      this.this$0 = var1;
   }
}
