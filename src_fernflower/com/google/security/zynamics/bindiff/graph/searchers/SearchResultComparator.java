package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class SearchResultComparator implements Comparator {
   public int compare(SearchResult var1, SearchResult var2) {
      Object var3 = var1.getObject();
      Object var4 = var2.getObject();
      if(var3 == var4) {
         return var1.getLine() > var2.getLine()?1:(var1.getLine() < var2.getLine()?-1:0);
      } else {
         IAddress var5 = null;
         IAddress var6 = null;
         SingleViewNode var7;
         SingleViewNode var8;
         SingleViewEdge var9;
         if(var3 instanceof SingleDiffNode) {
            var7 = ((SingleDiffNode)var3).getRawNode();
            var5 = var7.getAddress();
         } else if(var3 instanceof SingleDiffEdge) {
            var9 = (SingleViewEdge)((SingleDiffEdge)var3).getRawEdge();
            var8 = (SingleViewNode)var9.getSource();
            var5 = var8.getAddress();
         }

         if(var4 instanceof SingleDiffNode) {
            var7 = ((SingleDiffNode)var4).getRawNode();
            var6 = var7.getAddress();
         } else if(var4 instanceof SingleDiffEdge) {
            var9 = (SingleViewEdge)((SingleDiffEdge)var4).getRawEdge();
            var8 = (SingleViewNode)var9.getSource();
            var6 = var8.getAddress();
         }

         if(var5 != null && var6 != null) {
            return var5.compareTo(var6);
         } else {
            throw new IllegalStateException("Address cannot be null");
         }
      }
   }
}
