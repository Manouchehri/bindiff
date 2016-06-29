package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints$ConstrainedCollection;
import com.google.common.collect.Constraints$ConstrainedList;
import com.google.common.collect.Constraints$ConstrainedListIterator;
import com.google.common.collect.Constraints$ConstrainedRandomAccessList;
import com.google.common.collect.Constraints$ConstrainedSet;
import com.google.common.collect.Constraints$ConstrainedSortedSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class Constraints {
   public static Collection constrainedCollection(Collection var0, Constraint var1) {
      return new Constraints$ConstrainedCollection(var0, var1);
   }

   public static Set constrainedSet(Set var0, Constraint var1) {
      return new Constraints$ConstrainedSet(var0, var1);
   }

   public static SortedSet constrainedSortedSet(SortedSet var0, Constraint var1) {
      return new Constraints$ConstrainedSortedSet(var0, var1);
   }

   public static List constrainedList(List var0, Constraint var1) {
      return (List)(var0 instanceof RandomAccess?new Constraints$ConstrainedRandomAccessList(var0, var1):new Constraints$ConstrainedList(var0, var1));
   }

   private static ListIterator constrainedListIterator(ListIterator var0, Constraint var1) {
      return new Constraints$ConstrainedListIterator(var0, var1);
   }

   static Collection constrainedTypePreservingCollection(Collection var0, Constraint var1) {
      return (Collection)(var0 instanceof SortedSet?constrainedSortedSet((SortedSet)var0, var1):(var0 instanceof Set?constrainedSet((Set)var0, var1):(var0 instanceof List?constrainedList((List)var0, var1):constrainedCollection(var0, var1))));
   }

   private static Collection checkElements(Collection var0, Constraint var1) {
      ArrayList var2 = Lists.newArrayList((Iterable)var0);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var1.checkElement(var4);
      }

      return var2;
   }

   // $FF: synthetic method
   static Collection access$000(Collection var0, Constraint var1) {
      return checkElements(var0, var1);
   }

   // $FF: synthetic method
   static ListIterator access$100(ListIterator var0, Constraint var1) {
      return constrainedListIterator(var0, var1);
   }
}
