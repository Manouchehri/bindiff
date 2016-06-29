package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Iterator;

public class GraphAddressSearcher {
   public static CombinedDiffNode searchAddress(CombinedGraph var0, ESide var1, IAddress var2) {
      Iterator var3 = var0.getNodes().iterator();

      while(var3.hasNext()) {
         CombinedDiffNode var4 = (CombinedDiffNode)var3.next();
         CombinedViewNode var5 = var4.getRawNode();
         if(var5 instanceof RawCombinedBasicBlock) {
            RawBasicBlock var6 = ((RawCombinedBasicBlock)var5).getRawNode(var1);
            if(var6 != null && var6.getInstruction(var2) != null) {
               return var4;
            }
         } else {
            RawFunction var7 = ((RawCombinedFunction)var5).getRawNode(var1);
            if(var7 != null && var7.getAddress().equals(var2)) {
               return var4;
            }
         }
      }

      return null;
   }

   public static SingleDiffNode searchAddress(SingleGraph var0, IAddress var1) {
      Iterator var2 = var0.getNodes().iterator();

      while(var2.hasNext()) {
         SingleDiffNode var3 = (SingleDiffNode)var2.next();
         SingleViewNode var4 = var3.getRawNode();
         if(var4 instanceof RawBasicBlock) {
            if(((RawBasicBlock)var4).getInstruction(var1) != null) {
               return var3;
            }
         } else if(var3.getRawNode().getAddress().equals(var1)) {
            return var3;
         }
      }

      return null;
   }
}
