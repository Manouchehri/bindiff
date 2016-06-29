package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.sorters.SearchResultSorter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CombinedGraphSearcher extends GraphSearcher {
   public void search(List var1, List var2, String var3) {
      this.setLastSearchString(var3);
   }

   public void setObjectResults(CombinedGraph var1, List var2, List var3) {
      HashSet var4 = new HashSet();
      HashSet var5 = new HashSet();
      var5.addAll(var2);
      var5.addAll(var3);
      Iterator var6 = var1.getNodes().iterator();

      while(var6.hasNext()) {
         CombinedDiffNode var7 = (CombinedDiffNode)var6.next();
         SingleDiffNode var8 = var7.getPrimaryDiffNode();
         if(var5.contains(var8)) {
            var4.add(var7);
         } else {
            SingleDiffNode var9 = var7.getSecondaryDiffNode();
            if(var5.contains(var9)) {
               var4.add(var7);
            }
         }
      }

      var6 = var1.getEdges().iterator();

      while(var6.hasNext()) {
         CombinedDiffEdge var11 = (CombinedDiffEdge)var6.next();
         SingleDiffEdge var12 = var11.getPrimaryDiffEdge();
         if(var5.contains(var12)) {
            var4.add(var11);
         } else {
            SingleDiffEdge var13 = var11.getSecondaryDiffEdge();
            if(var5.contains(var13)) {
               var4.add(var11);
            }
         }
      }

      List var10 = SearchResultSorter.getSortedList(var4, ESide.PRIMARY);
      this.setObjectResult(var10);
   }
}
