package com.google.security.zynamics.zylib.gml;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.types.trees.ITree;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public final class GmlConverter {
   public static String toGml(IDirectedGraph var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      StringBuilder var1 = new StringBuilder();
      var1.append("graph\n");
      var1.append("[\n");
      int var2 = 0;
      HashMap var3 = new HashMap();

      Iterator var4;
      String var6;
      for(var4 = var0.getNodes().iterator(); var4.hasNext(); ++var2) {
         Object var5 = var4.next();
         var1.append("\tnode\n");
         var1.append("\t[\n");
         var1.append((new StringBuilder(16)).append("\tid ").append(var2).append("\n").toString());
         var6 = String.valueOf(var5);
         var1.append((new StringBuilder(10 + String.valueOf(var6).length())).append("\tlabel \"").append(var6).append("\"\n").toString());
         var1.append("\t]\n");
         var3.put(var5, Integer.valueOf(var2));
      }

      var4 = var0.getEdges().iterator();

      while(var4.hasNext()) {
         IGraphEdge var7 = (IGraphEdge)var4.next();
         var1.append("\tedge\n");
         var1.append("\t[\n");
         var6 = String.valueOf(var3.get(var7.getSource()));
         var1.append((new StringBuilder(9 + String.valueOf(var6).length())).append("\tsource ").append(var6).append("\n").toString());
         var6 = String.valueOf(var3.get(var7.getTarget()));
         var1.append((new StringBuilder(9 + String.valueOf(var6).length())).append("\ttarget ").append(var6).append("\n").toString());
         var1.append("\tgraphics\n");
         var1.append("\t[\n");
         var1.append("\t\tfill \"#000000\"\n");
         var1.append("\t\ttargetArrow \"standard\"\n");
         var1.append("\t]\n");
         var1.append("\t]\n");
      }

      var1.append("]\n");
      return var1.toString();
   }

   public static String toGml(ITree var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      StringBuilder var1 = new StringBuilder();
      var1.append("graph\n");
      var1.append("[\n");
      int var2 = 0;
      HashMap var3 = new HashMap();
      Stack var4 = new Stack();
      var4.push(var0.getRootNode());

      while(!var4.isEmpty()) {
         ITreeNode var5 = (ITreeNode)var4.pop();
         var1.append("\tnode\n");
         var1.append("\t[\n");
         var1.append((new StringBuilder(16)).append("\tid ").append(var2).append("\n").toString());
         String var6 = String.valueOf(var5);
         var1.append((new StringBuilder(10 + String.valueOf(var6).length())).append("\tlabel \"").append(var6).append("\"\n").toString());
         var1.append("\t]\n");
         var3.put(var5, Integer.valueOf(var2));
         ++var2;
         ITreeNode var9 = var5.getParent();
         if(var9 != null) {
            var1.append("\tedge\n");
            var1.append("\t[\n");
            String var7 = String.valueOf(var3.get(var9));
            var1.append((new StringBuilder(9 + String.valueOf(var7).length())).append("\tsource ").append(var7).append("\n").toString());
            var7 = String.valueOf(var3.get(var5));
            var1.append((new StringBuilder(9 + String.valueOf(var7).length())).append("\ttarget ").append(var7).append("\n").toString());
            var1.append("\tgraphics\n");
            var1.append("\t[\n");
            var1.append("\t\tfill \"#000000\"\n");
            var1.append("\t\ttargetArrow \"standard\"\n");
            var1.append("\t]\n");
            var1.append("\t]\n");
         }

         Iterator var10 = var5.getChildren().iterator();

         while(var10.hasNext()) {
            ITreeNode var8 = (ITreeNode)var10.next();
            var4.push(var8);
         }
      }

      var1.append("]\n");
      return var1.toString();
   }
}
