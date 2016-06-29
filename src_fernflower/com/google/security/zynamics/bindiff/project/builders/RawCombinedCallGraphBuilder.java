package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RawCombinedCallGraphBuilder {
   private static List buildCombinedCalls(RawCallGraph var0, RawCallGraph var1, Map var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var0.getEdges().iterator();

      RawCall var5;
      RawFunction var6;
      RawFunction var7;
      RawFunction var8;
      RawFunction var9;
      IAddress var10;
      IAddress var11;
      IAddress var12;
      IAddress var13;
      RawCombinedFunction var15;
      while(var4.hasNext()) {
         var5 = (RawCall)var4.next();
         var6 = (RawFunction)var5.getSource();
         var7 = (RawFunction)var5.getTarget();
         var8 = var6.getMatchedFunction();
         var9 = var7.getMatchedFunction();
         var10 = var6.getAddress();
         var11 = var7.getAddress();
         var12 = var8 == null?null:var8.getAddress();
         var13 = var9 == null?null:var9.getAddress();
         RawCall var14 = var5.getMatchedCall();
         if(var14 != null && var14.isChanged()) {
            var14 = null;
         }

         var15 = (RawCombinedFunction)var2.get(new Pair(var10, var12));
         RawCombinedFunction var16 = (RawCombinedFunction)var2.get(new Pair(var11, var13));
         RawCombinedCall var17 = new RawCombinedCall(var15, var16, var5, var14);
         var3.add(var17);
      }

      var4 = var1.getEdges().iterator();

      while(true) {
         do {
            if(!var4.hasNext()) {
               return var3;
            }

            var5 = (RawCall)var4.next();
         } while(var5.getMatchedCall() != null && !var5.getMatchedCall().isChanged());

         var6 = (RawFunction)var5.getSource();
         var7 = (RawFunction)var5.getTarget();
         var8 = var6.getMatchedFunction();
         var9 = var7.getMatchedFunction();
         var10 = var6.getAddress();
         var11 = var7.getAddress();
         var12 = var8 == null?null:var8.getAddress();
         var13 = var9 == null?null:var9.getAddress();
         RawCombinedFunction var18 = (RawCombinedFunction)var2.get(new Pair(var12, var10));
         var15 = (RawCombinedFunction)var2.get(new Pair(var13, var11));
         RawCombinedCall var19 = new RawCombinedCall(var18, var15, (RawCall)null, var5);
         var3.add(var19);
      }
   }

   private static List buildCombinedFunctions(MatchData var0, RawCallGraph var1, RawCallGraph var2, Map var3) {
      ArrayList var4 = new ArrayList();
      Iterator var5 = var1.getNodes().iterator();

      RawFunction var6;
      IAddress var7;
      IAddress var8;
      while(var5.hasNext()) {
         var6 = (RawFunction)var5.next();
         var7 = var6.getAddress();
         var8 = var0.getSecondaryFunctionAddr(var7);
         RawFunction var9 = null;
         if(var8 != null) {
            var9 = var2.getFunction(var8);
         }

         RawCombinedFunction var10 = new RawCombinedFunction(var6, var9);
         var3.put(new Pair(var7, var8), var10);
         var4.add(var10);
      }

      var5 = var2.getNodes().iterator();

      while(var5.hasNext()) {
         var6 = (RawFunction)var5.next();
         var7 = var6.getAddress();
         var8 = var0.getPrimaryFunctionAddr(var7);
         if(var8 == null) {
            RawCombinedFunction var11 = new RawCombinedFunction((RawFunction)null, var6);
            var3.put(new Pair((Object)null, var7), var11);
            var4.add(var11);
         }
      }

      return var4;
   }

   public static RawCombinedCallGraph buildCombinedCallgraph(MatchData var0, RawCallGraph var1, RawCallGraph var2) {
      // $FF: Couldn't be decompiled
   }
}
