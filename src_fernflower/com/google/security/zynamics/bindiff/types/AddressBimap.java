package com.google.security.zynamics.bindiff.types;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AddressBimap {
   private long[] primarySortedValues;
   private long[] secondaryAssignedValues;
   private long[] secondarySortedValues;
   private long[] primaryAssignedValues;

   public AddressBimap(List var1) {
      Preconditions.checkNotNull(var1);
      int var2 = var1.size();
      this.primarySortedValues = new long[var2];
      this.secondaryAssignedValues = new long[var2];
      Collections.sort(var1, new com.google.security.zynamics.bindiff.project.matches.AddressPairComparator(ESide.PRIMARY));
      int var3 = 0;

      Iterator var4;
      IAddressPair var5;
      for(var4 = var1.iterator(); var4.hasNext(); ++var3) {
         var5 = (IAddressPair)var4.next();
         this.primarySortedValues[var3] = var5.getAddress(ESide.PRIMARY);
         this.secondaryAssignedValues[var3] = var5.getAddress(ESide.SECONDARY);
      }

      this.secondarySortedValues = new long[var2];
      this.primaryAssignedValues = new long[var2];
      Collections.sort(var1, new com.google.security.zynamics.bindiff.project.matches.AddressPairComparator(ESide.SECONDARY));
      var3 = 0;

      for(var4 = var1.iterator(); var4.hasNext(); ++var3) {
         var5 = (IAddressPair)var4.next();
         this.primaryAssignedValues[var3] = var5.getAddress(ESide.PRIMARY);
         this.secondarySortedValues[var3] = var5.getAddress(ESide.SECONDARY);
      }

   }

   private Long getPrimaryAddress(long var1) {
      int var3 = this.getIndex(var1, ESide.SECONDARY);
      return var3 >= 0?Long.valueOf(this.primaryAssignedValues[var3]):null;
   }

   private Long getSecondaryAddress(long var1) {
      int var3 = this.getIndex(var1, ESide.PRIMARY);
      return var3 >= 0?Long.valueOf(this.secondaryAssignedValues[var3]):null;
   }

   public boolean contains(IAddress var1, ESide var2) {
      return this.getIndex(var1.toLong(), var2) >= 0;
   }

   public boolean contains(IAddress var1, IAddress var2) {
      if(var1 != null && var2 != null) {
         int var3 = this.getIndex(var1, ESide.PRIMARY);
         return var3 < 0?false:this.primarySortedValues[var3] == var1.toLong() && this.secondaryAssignedValues[var3] == var2.toLong();
      } else {
         return false;
      }
   }

   public int getIndex(IAddress var1, ESide var2) {
      return var1 != null?this.getIndex(var1.toLong(), var2):-1;
   }

   public int getIndex(long var1, ESide var3) {
      return var3 == ESide.PRIMARY?Arrays.binarySearch(this.primarySortedValues, var1):Arrays.binarySearch(this.secondarySortedValues, var1);
   }

   public IAddress getPrimaryAddress(IAddress var1) {
      Long var2 = this.getPrimaryAddress(var1.toLong());
      return var2 != null?new CAddress(var2.longValue()):null;
   }

   public IAddress getSecondaryAddress(IAddress var1) {
      Long var2 = this.getSecondaryAddress(var1.toLong());
      return var2 != null?new CAddress(var2.longValue()):null;
   }

   public boolean remove(IAddress var1, IAddress var2) {
      int var3 = this.getIndex(var1, ESide.PRIMARY);
      int var4 = this.getIndex(var2, ESide.SECONDARY);
      if(var3 >= 0 && var4 >= 0) {
         int var5 = this.primarySortedValues.length;
         long[] var6 = new long[var5 - 1];
         long[] var7 = new long[var5 - 1];
         long[] var8 = new long[var5 - 1];
         long[] var9 = new long[var5 - 1];
         int var10 = 0;
         int var11 = 0;

         for(int var12 = 0; var12 < var5; ++var12) {
            if(var12 != var3) {
               var6[var10] = this.primarySortedValues[var12];
               var7[var10] = this.secondaryAssignedValues[var12];
               ++var10;
            }

            if(var12 != var4) {
               var8[var11] = this.secondarySortedValues[var12];
               var9[var11] = this.primaryAssignedValues[var12];
               ++var11;
            }
         }

         this.primarySortedValues = var6;
         this.secondaryAssignedValues = var7;
         this.secondarySortedValues = var8;
         this.primaryAssignedValues = var9;
         return true;
      } else {
         return false;
      }
   }
}
