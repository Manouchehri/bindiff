package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.types.AddressPairComparator;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddressPairSorter {
   public static List getSortedList(Collection var0, ESide var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      if(var1 == ESide.PRIMARY) {
         var3.addAll(var0);
      } else {
         Iterator var4 = var0.iterator();

         while(var4.hasNext()) {
            Pair var5 = (Pair)var4.next();
            var3.add(new Pair(var5.second(), var5.first()));
         }
      }

      ArrayList var14 = new ArrayList();
      ArrayList var15 = new ArrayList();
      Iterator var6 = var0.iterator();

      while(var6.hasNext()) {
         Pair var7 = (Pair)var6.next();
         if(var7.first() == null) {
            var15.add(var7);
         } else if(var7.second() == null) {
            var14.add(var7);
         } else {
            var14.add(var7);
            var15.add(var7);
         }
      }

      Collections.sort(var14, new AddressPairComparator(ESide.PRIMARY));
      Collections.sort(var15, new AddressPairComparator(ESide.SECONDARY));
      if(var14.size() == var0.size()) {
         var2.addAll(var14);
      } else if(var15.size() == var0.size()) {
         var2.addAll(var15);
      } else {
         int var16 = 0;
         HashMap var17 = new HashMap();

         Pair var9;
         for(Iterator var8 = var15.iterator(); var8.hasNext(); ++var16) {
            var9 = (Pair)var8.next();
            if(var9.first() != null && var9.second() != null) {
               var17.put(var9.second(), Integer.valueOf(var16));
            }
         }

         int var20 = 0;
         Iterator var22 = var14.iterator();

         while(true) {
            while(var22.hasNext()) {
               Pair var10 = (Pair)var22.next();
               if(var10.second() == null) {
                  var2.add(var10);
               } else {
                  IAddress var11 = (IAddress)var10.second();
                  int var12 = ((Integer)var17.get(var11)).intValue();

                  for(var16 = var20; var16 < var12; ++var16) {
                     Pair var13 = (Pair)var15.get(var16);
                     var2.add(var13);
                  }

                  var2.add(var10);
                  var20 = var12 + 1;
               }
            }

            for(var16 = var20; var16 < var15.size(); ++var16) {
               var9 = (Pair)var15.get(var16);
               var2.add(var9);
            }
            break;
         }
      }

      if(var1 != ESide.SECONDARY) {
         return var2;
      } else {
         ArrayList var19 = new ArrayList();
         Iterator var18 = var2.iterator();

         while(var18.hasNext()) {
            Pair var21 = (Pair)var18.next();
            var19.add(new Pair(var21.second(), var21.second()));
         }

         return var19;
      }
   }
}
