package com.google.security.zynamics.bindiff.graph.sorters;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.sorters.AddressPairSorter;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultSorter {
   private static Map getAddrPairToObjectMap(Collection var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         IAddress var4 = null;
         IAddress var5 = null;
         SingleViewNode var6;
         SingleViewNode var7;
         if(var3 instanceof SuperDiffNode) {
            var6 = ((SuperDiffNode)var3).getPrimaryRawNode();
            if(var6 != null) {
               var4 = var6.getAddress();
            }

            var7 = ((SuperDiffNode)var3).getSecondaryRawNode();
            if(var7 != null) {
               var5 = var7.getAddress();
            }
         } else if(var3 instanceof CombinedDiffNode) {
            var6 = ((CombinedDiffNode)var3).getPrimaryRawNode();
            if(var6 != null) {
               var4 = var6.getAddress();
            }

            var7 = ((CombinedDiffNode)var3).getSecondaryRawNode();
            if(var7 != null) {
               var5 = var7.getAddress();
            }
         } else if(var3 instanceof SingleDiffNode) {
            SingleDiffNode var9 = (SingleDiffNode)var3;
            if(var9.getSide() == ESide.PRIMARY) {
               var4 = var9.getRawNode().getAddress();
            } else {
               var5 = var9.getRawNode().getAddress();
            }
         } else {
            SingleViewNode var8;
            if(var3 instanceof SuperDiffEdge) {
               SuperDiffEdge var10 = (SuperDiffEdge)var3;
               var7 = ((SuperDiffNode)var10.getSource()).getPrimaryRawNode();
               if(var7 != null) {
                  var4 = var7.getAddress();
               }

               var8 = ((SuperDiffNode)var10.getSource()).getSecondaryRawNode();
               if(var8 != null) {
                  var5 = var8.getAddress();
               }
            } else if(var3 instanceof CombinedDiffEdge) {
               CombinedDiffEdge var11 = (CombinedDiffEdge)var3;
               var7 = ((CombinedDiffNode)var11.getSource()).getPrimaryRawNode();
               if(var7 != null) {
                  var4 = var7.getAddress();
               }

               var8 = ((CombinedDiffNode)var11.getSource()).getSecondaryRawNode();
               if(var8 != null) {
                  var5 = var8.getAddress();
               }
            } else if(var3 instanceof SingleDiffEdge) {
               SingleDiffEdge var12 = (SingleDiffEdge)var3;
               if(var12.getSide() == ESide.PRIMARY) {
                  var4 = ((SingleDiffNode)var12.getSource()).getRawNode().getAddress();
               } else {
                  var5 = ((SingleDiffNode)var12.getSource()).getRawNode().getAddress();
               }
            }
         }

         Pair var13 = new Pair(var4, var5);
         var1.put(var13, var3);
      }

      return var1;
   }

   public static List getSortedList(Collection var0, ESide var1) {
      ArrayList var2 = new ArrayList();
      Map var3 = getAddrPairToObjectMap(var0);
      List var4 = AddressPairSorter.getSortedList(var3.keySet(), var1);
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         Pair var6 = (Pair)var5.next();
         Object var7 = var3.get(var6);
         var2.add(var7);
      }

      return var2;
   }
}
