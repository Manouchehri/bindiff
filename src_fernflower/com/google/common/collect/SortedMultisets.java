package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset$Entry;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class SortedMultisets {
   private static Object getElementOrThrow(Multiset$Entry var0) {
      if(var0 == null) {
         throw new NoSuchElementException();
      } else {
         return var0.getElement();
      }
   }

   private static Object getElementOrNull(@Nullable Multiset$Entry var0) {
      return var0 == null?null:var0.getElement();
   }

   // $FF: synthetic method
   static Object access$000(Multiset$Entry var0) {
      return getElementOrThrow(var0);
   }

   // $FF: synthetic method
   static Object access$100(Multiset$Entry var0) {
      return getElementOrNull(var0);
   }
}
