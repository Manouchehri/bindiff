package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Synchronized;
import javax.annotation.Nullable;

@GwtCompatible
@GoogleInternal
public final class BackDoorsForLabs {
   public static Multimap synchronizedMultimap(Multimap var0, @Nullable Object var1) {
      return Synchronized.multimap(var0, var1);
   }

   public static SetMultimap synchronizedSetMultimap(SetMultimap var0, @Nullable Object var1) {
      return Synchronized.setMultimap(var0, var1);
   }
}
