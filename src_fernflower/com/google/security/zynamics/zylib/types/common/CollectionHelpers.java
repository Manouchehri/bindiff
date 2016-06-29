package com.google.security.zynamics.zylib.types.common;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers$1;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers$2;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.ICollectionMapper;
import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IItemCallback;
import com.google.security.zynamics.zylib.types.common.IIterableCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionHelpers {
   public static boolean all(Collection var0, ICollectionFilter var1) {
      Iterator var2 = var0.iterator();

      Object var3;
      do {
         if(!var2.hasNext()) {
            return true;
         }

         var3 = var2.next();
      } while(var1.qualifies(var3));

      return false;
   }

   public static boolean any(Collection var0, ICollectionFilter var1) {
      Iterator var2 = var0.iterator();

      Object var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = var2.next();
      } while(!var1.qualifies(var3));

      return true;
   }

   public static int count(Collection var0, Object var1) {
      int var2 = 0;
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(var4 == var1) {
            ++var2;
         }
      }

      return var2;
   }

   public static int countIf(Collection var0, ICollectionFilter var1) {
      int var2 = 0;
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(var1.qualifies(var4)) {
            ++var2;
         }
      }

      return var2;
   }

   public static List filter(Collection var0, ICollectionFilter var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(var1.qualifies(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public static Collection flatten(Collection var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Collection var3 = (Collection)var2.next();
         var1.addAll(var3);
      }

      return var1;
   }

   public static void iterate(IIterableCollection var0, ICollectionFilter var1, IItemCallback var2) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      Preconditions.checkNotNull(var2, "Error: Callback argument can\'t be null");
      Preconditions.checkNotNull(var1, "Error: Filter argument can\'t be null");
      var0.iterate(new CollectionHelpers$1(var1, var2));
   }

   public static void iterate(IIterableCollection var0, IFilteredItemCallback var1) {
      var0.iterate(new CollectionHelpers$2(var1));
   }

   public static List map(Collection var0, ICollectionMapper var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.add(var1.map(var4));
      }

      return var2;
   }

   public static Object nth(Collection var0, ICollectionFilter var1, int var2) {
      int var3 = 0;
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(var1.qualifies(var5)) {
            if(var3 == var2) {
               return var5;
            }

            ++var3;
         }
      }

      throw new IllegalStateException("Error: nth element does not exist");
   }

   public static Pair unzip(Collection var0) {
      ArrayList var1 = new ArrayList(var0.size());
      ArrayList var2 = new ArrayList(var0.size());
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         var1.add(var4.first());
         var2.add(var4.second());
      }

      return new Pair(var1, var2);
   }
}
