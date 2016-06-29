package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
final class CollectPreconditions {
   static void checkEntryNotNull(Object var0, Object var1) {
      String var2;
      if(var0 == null) {
         var2 = String.valueOf(var1);
         throw new NullPointerException((new StringBuilder(24 + String.valueOf(var2).length())).append("null key in entry: null=").append(var2).toString());
      } else if(var1 == null) {
         var2 = String.valueOf(var0);
         throw new NullPointerException((new StringBuilder(26 + String.valueOf(var2).length())).append("null value in entry: ").append(var2).append("=null").toString());
      }
   }

   static int checkNonnegative(int var0, String var1) {
      if(var0 < 0) {
         throw new IllegalArgumentException((new StringBuilder(40 + String.valueOf(var1).length())).append(var1).append(" cannot be negative but was: ").append(var0).toString());
      } else {
         return var0;
      }
   }

   static void checkRemove(boolean var0) {
      Preconditions.checkState(var0, "no calls to next() since the last call to remove()");
   }
}
