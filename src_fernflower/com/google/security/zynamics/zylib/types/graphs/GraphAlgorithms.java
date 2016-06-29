package com.google.security.zynamics.zylib.types.graphs;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.graphs.algorithms.LengauerTarjan;
import com.google.security.zynamics.zylib.types.trees.Tree;
import com.google.security.zynamics.zylib.types.trees.TreeAlgorithms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphAlgorithms {
   private static void getPredecessors(IGraphNode var0, Set var1, Set var2) {
      Iterator var3 = var0.getParents().iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         if(!var2.contains(var4)) {
            var2.add(var4);
            var1.add(var4);
            getPredecessors(var4, var1, var2);
         }
      }

   }

   private static void getPredecessorsInternal(IGraphNode var0, int var1, List var2, Set var3) {
      if(var1 > 0) {
         Iterator var4 = var0.getParents().iterator();

         while(var4.hasNext()) {
            IGraphNode var5 = (IGraphNode)var4.next();
            if(!var3.contains(var5)) {
               var3.add(var5);
               var2.add(var5);
               getPredecessorsInternal(var5, var1 - 1, var2, var3);
            }
         }

      }
   }

   private static void getSuccessors(IGraphNode var0, Set var1, Set var2) {
      Iterator var3 = var0.getChildren().iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         if(!var2.contains(var4)) {
            var2.add(var4);
            var1.add(var4);
            getSuccessors(var4, var1, var2);
         }
      }

   }

   private static void getSuccessorsInternal(IGraphNode var0, int var1, List var2, HashSet var3) {
      if(var1 > 0) {
         Iterator var4 = var0.getChildren().iterator();

         while(var4.hasNext()) {
            IGraphNode var5 = (IGraphNode)var4.next();
            if(!var3.contains(var5)) {
               var3.add(var5);
               var2.add(var5);
               getSuccessorsInternal(var5, var1 - 1, var2, var3);
            }
         }

      }
   }

   public static Collection collectChildren(IGraphNode var0, INodeFilter var1) {
      Preconditions.checkNotNull(var0, "Error: Node argument can\'t be null");
      return collectNodes(var0.getChildren(), var1);
   }

   public static Collection collectNodes(Collection var0, INodeFilter var1) {
      Preconditions.checkNotNull(var0, "Error: Nodes argument can\'t be null");
      Preconditions.checkNotNull(var1, "Error: Filter argument can\'t be null");
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

   public static Collection collectParents(IGraphNode var0, INodeFilter var1) {
      Preconditions.checkNotNull(var0, "Error: Node argument can\'t be null");
      return collectNodes(var0.getParents(), var1);
   }

   public static HashMap getBackEdges(IDirectedGraph var0, IGraphNode var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Root Node argument can not be null");
      HashMap var2 = new HashMap();
      Pair var3 = LengauerTarjan.calculate(var0, var1);
      HashMap var4 = (HashMap)var3.second();
      HashMap var5 = TreeAlgorithms.getDominateRelation(((Tree)var3.first()).getRootNode());

      IGraphNode var7;
      ArrayList var8;
      for(Iterator var6 = var0.getNodes().iterator(); var6.hasNext(); var2.put(var7, var8)) {
         var7 = (IGraphNode)var6.next();
         var8 = new ArrayList();
         Set var9 = (Set)var5.get(var4.get(var7));
         if(var9 != null) {
            Iterator var10 = var7.getChildren().iterator();

            while(var10.hasNext()) {
               IGraphNode var11 = (IGraphNode)var10.next();
               if(var9.contains(var4.get(var11))) {
                  var8.add(var11);
               }
            }
         }
      }

      return var2;
   }

   public static ArrayList getGraphLoops(IDirectedGraph var0) {
      IGraphNode var1 = null;
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.getNodes().iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         if(var4.getParents().size() == 0) {
            var1 = var4;
            break;
         }
      }

      if(var1 == null) {
         return null;
      } else {
         HashMap var9 = getBackEdges(var0, var1);
         Iterator var10 = var0.getNodes().iterator();

         while(var10.hasNext()) {
            IGraphNode var5 = (IGraphNode)var10.next();
            ArrayList var6 = (ArrayList)var9.get(var5);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
               IGraphNode var8 = (IGraphNode)var7.next();
               var2.add(getLoopNodes(var5, var8));
            }
         }

         return var2;
      }
   }

   public static Set getLoopNodes(IGraphNode var0, IGraphNode var1) {
      ArrayList var2;
      if(var0 == var1) {
         var2 = new ArrayList();
         var2.add(var0);
         return new HashSet(var2);
      } else {
         var2 = new ArrayList();
         var2.add(var1);
         HashSet var3 = new HashSet(var2);
         Stack var4 = new Stack();
         var4.push(var0);

         while(!var4.empty()) {
            IGraphNode var5 = (IGraphNode)var4.pop();
            var3.add(var5);
            Iterator var6 = var5.getParents().iterator();

            while(var6.hasNext()) {
               IGraphNode var7 = (IGraphNode)var6.next();
               if(!var3.contains(var7)) {
                  var3.add(var7);
                  var4.push(var7);
               }
            }
         }

         ArrayList var11 = new ArrayList();
         HashSet var12 = new HashSet(var11);
         Stack var13 = new Stack();
         var13.push(var1);

         while(!var13.empty()) {
            IGraphNode var8 = (IGraphNode)var13.pop();
            var12.add(var8);
            Iterator var9 = var8.getChildren().iterator();

            while(var9.hasNext()) {
               IGraphNode var10 = (IGraphNode)var9.next();
               if(!var12.contains(var10)) {
                  var12.add(var10);
                  var13.push(var10);
               }
            }
         }

         var3.retainAll(var12);
         return var3;
      }
   }

   public static Collection getPredecessors(Collection var0) {
      Preconditions.checkNotNull(var0, "Error: Nodes argument can\'t be null");
      HashSet var1 = new HashSet();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         IGraphNode var3 = (IGraphNode)var2.next();
         var1.addAll(getPredecessors(var3));
      }

      return var1;
   }

   public static Set getPredecessors(IGraphNode var0) {
      Preconditions.checkNotNull(var0, "Error: Start node can\'t be null");
      HashSet var1 = new HashSet();
      HashSet var2 = new HashSet();
      getPredecessors(var0, var1, var2);
      return var1;
   }

   public static Set getPredecessorsUpToNode(IGraphNode var0, IGraphNode var1) {
      Preconditions.checkNotNull(var0, "Error: endNode argument can not be null");
      Preconditions.checkNotNull(var1, "Error: startNode argument can not be null");
      HashSet var2 = Sets.newHashSet();
      HashSet var3 = Sets.newHashSet();
      var3.add(var1);
      getPredecessors(var0, var2, var3);
      return var2;
   }

   public static List getPredecessors(Iterable var0, int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         var2.addAll(getPredecessors(var4, var1));
      }

      return var2;
   }

   public static List getPredecessors(IGraphNode var0, int var1) {
      ArrayList var2 = new ArrayList();
      getPredecessorsInternal(var0, var1, var2, new HashSet());
      return var2;
   }

   public static Collection getSuccessors(Collection var0) {
      Preconditions.checkNotNull(var0, "Error: Nodes argument can\'t be null");
      HashSet var1 = new HashSet();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         IGraphNode var3 = (IGraphNode)var2.next();
         var1.addAll(getSuccessors(var3));
      }

      return var1;
   }

   public static Set getSuccessors(IGraphNode var0) {
      Preconditions.checkNotNull(var0, "Error: Start node can\'t be null");
      HashSet var1 = new HashSet();
      HashSet var2 = new HashSet();
      getSuccessors(var0, var1, var2);
      return var1;
   }

   public static Set getSuccessorsDownToNode(IGraphNode var0, IGraphNode var1) {
      Preconditions.checkNotNull(var0, "Error: parent node can\'t be null");
      Preconditions.checkNotNull(var1, "Error: maximumChildNode argument can not be null");
      HashSet var2 = new HashSet();
      HashSet var3 = new HashSet();
      getSuccessors(var0, var2, var3);
      return var2;
   }

   public static List getSuccessors(Iterable var0, int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         IGraphNode var4 = (IGraphNode)var3.next();
         var2.addAll(getSuccessors(var4, var1));
      }

      return var2;
   }

   public static List getSuccessors(IGraphNode var0, int var1) {
      ArrayList var2 = new ArrayList();
      getSuccessorsInternal(var0, var1, var2, new HashSet());
      return var2;
   }

   public static boolean isRootNode(IGraphNode var0) {
      return var0.getParents().size() == 0;
   }
}
