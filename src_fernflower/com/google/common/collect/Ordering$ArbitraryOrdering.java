package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;
import com.google.common.collect.Ordering$ArbitraryOrdering$1;
import com.google.common.collect.Platform;
import java.util.Map;

@VisibleForTesting
class Ordering$ArbitraryOrdering extends Ordering {
   private Map uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Ordering$ArbitraryOrdering$1(this));

   public int compare(Object var1, Object var2) {
      if(var1 == var2) {
         return 0;
      } else if(var1 == null) {
         return -1;
      } else if(var2 == null) {
         return 1;
      } else {
         int var3 = this.identityHashCode(var1);
         int var4 = this.identityHashCode(var2);
         if(var3 != var4) {
            return var3 < var4?-1:1;
         } else {
            int var5 = ((Integer)this.uids.get(var1)).compareTo((Integer)this.uids.get(var2));
            if(var5 == 0) {
               throw new AssertionError();
            } else {
               return var5;
            }
         }
      }
   }

   public String toString() {
      return "Ordering.arbitrary()";
   }

   int identityHashCode(Object var1) {
      return System.identityHashCode(var1);
   }
}
