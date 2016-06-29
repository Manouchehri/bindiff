package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.Interners$InternerFunction;
import com.google.common.collect.Interners$WeakInterner;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

@Beta
public final class Interners {
   public static Interner newStrongInterner() {
      ConcurrentMap var0 = (new MapMaker()).makeMap();
      return new Interners$1(var0);
   }

   @GwtIncompatible("java.lang.ref.WeakReference")
   public static Interner newWeakInterner() {
      return new Interners$WeakInterner((Interners$1)null);
   }

   public static Function asFunction(Interner var0) {
      return new Interners$InternerFunction((Interner)Preconditions.checkNotNull(var0));
   }
}
