package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public final class SortedLists {
   public static int binarySearch(List var0, Comparable var1, SortedLists$KeyPresentBehavior var2, SortedLists$KeyAbsentBehavior var3) {
      Preconditions.checkNotNull(var1);
      return binarySearch(var0, (Object)var1, (Comparator)Ordering.natural(), var2, var3);
   }

   public static int binarySearch(List var0, Function var1, @Nullable Comparable var2, SortedLists$KeyPresentBehavior var3, SortedLists$KeyAbsentBehavior var4) {
      return binarySearch(var0, var1, var2, Ordering.natural(), var3, var4);
   }

   public static int binarySearch(List var0, Function var1, @Nullable Object var2, Comparator var3, SortedLists$KeyPresentBehavior var4, SortedLists$KeyAbsentBehavior var5) {
      return binarySearch(Lists.transform(var0, var1), var2, var3, var4, var5);
   }

   public static int binarySearch(List var0, @Nullable Object var1, Comparator var2, SortedLists$KeyPresentBehavior var3, SortedLists$KeyAbsentBehavior var4) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var3);
      Preconditions.checkNotNull(var4);
      if(!(var0 instanceof RandomAccess)) {
         var0 = Lists.newArrayList((Iterable)var0);
      }

      int var5 = 0;
      int var6 = ((List)var0).size() - 1;

      while(var5 <= var6) {
         int var7 = var5 + var6 >>> 1;
         int var8 = var2.compare(var1, ((List)var0).get(var7));
         if(var8 < 0) {
            var6 = var7 - 1;
         } else {
            if(var8 <= 0) {
               return var5 + var3.resultIndex(var2, var1, ((List)var0).subList(var5, var6 + 1), var7 - var5);
            }

            var5 = var7 + 1;
         }
      }

      return var4.resultIndex(var5);
   }
}
