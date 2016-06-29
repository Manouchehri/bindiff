package com.google.security.zynamics.zylib.types.graphs.algorithms;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.graphs.algorithms.MalformedGraphException;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import com.google.security.zynamics.zylib.types.trees.Tree;
import com.google.security.zynamics.zylib.types.trees.TreeNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

public final class LengauerTarjan {
   private static int depthFirstSearch(IGraphNode var0, IGraphNode var1, HashMap var2, HashMap var3, HashMap var4, int var5) {
      var4.put(var1, var0);
      var3.put(Integer.valueOf(var5), var1);
      var2.put(var1, Integer.valueOf(var5));
      ++var5;
      Stack var6 = new Stack();
      Iterator var7 = Lists.reverse(var1.getChildren()).iterator();

      IGraphNode var8;
      while(var7.hasNext()) {
         var8 = (IGraphNode)var7.next();
         var6.push(new Pair(var8, var1));
      }

      while(true) {
         IGraphNode var9;
         do {
            if(var6.empty()) {
               return var5 - 1;
            }

            Pair var12 = (Pair)var6.pop();
            var8 = (IGraphNode)var12.first();
            var9 = (IGraphNode)var12.second();
         } while(((Integer)var2.get(var8)).intValue() != -1);

         var2.put(var8, Integer.valueOf(var5));
         var3.put(Integer.valueOf(var5), var8);
         var4.put(var8, var9);
         ++var5;
         Iterator var10 = Lists.reverse(var8.getChildren()).iterator();

         while(var10.hasNext()) {
            IGraphNode var11 = (IGraphNode)var10.next();
            var6.push(new Pair(var11, var8));
         }
      }
   }

   private static IGraphNode getAncestorWithLowestSemi(IGraphNode var0, HashMap var1, HashMap var2, HashMap var3, HashMap var4) {
      IGraphNode var5 = (IGraphNode)var3.get(var0);
      if(var3.get(var5) != null) {
         IGraphNode var6 = getAncestorWithLowestSemi(var5, var1, var2, var3, var4);
         var3.put(var0, var3.get(var5));
         if(((Integer)var1.get(var2.get(var6))).intValue() < ((Integer)var1.get(var2.get(var4.get(var0)))).intValue()) {
            var4.put(var0, var6);
         }
      }

      return (IGraphNode)var4.get(var0);
   }

   private static void link(IGraphNode var0, IGraphNode var1, HashMap var2, HashMap var3) {
      var2.put(var1, var0);
      var3.put(var1, var1);
   }

   public static Pair calculate(Collection var0, IGraphNode var1) {
      Preconditions.checkNotNull(var0, "Error: Nodes argument can not be null");
      if(var0.size() == 0) {
         return new Pair((Object)null, (Object)null);
      } else {
         Preconditions.checkNotNull(var1, "Error: Root node argument can not be null");
         Preconditions.checkArgument(var0.contains(var1), "Error: Root node is not part of the graph");
         int var2 = 0;
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            IGraphNode var4 = (IGraphNode)var3.next();
            if(var4.getParents().size() == 0) {
               ++var2;
            }
         }

         if(var2 > 1) {
            throw new MalformedGraphException("Error: Can not calculate dominator trees for graphs with more than one entry node");
         } else {
            HashMap var20 = new HashMap();
            HashMap var21 = new HashMap();
            HashMap var5 = new HashMap();
            HashMap var6 = new HashMap();
            HashMap var7 = new HashMap();
            HashMap var8 = new HashMap();
            HashMap var9 = new HashMap();
            HashMap var10 = new HashMap();
            HashMap var11 = new HashMap();
            Iterator var12 = var0.iterator();

            while(var12.hasNext()) {
               IGraphNode var13 = (IGraphNode)var12.next();
               var20.put(var13, new HashSet());
               var11.put(var13, Integer.valueOf(-1));
               var6.put(var13, (Object)null);
               var7.put(var13, (Object)null);
               var21.put(var13, (Object)null);
               var8.put(var13, (Object)null);
            }

            int var22 = depthFirstSearch((IGraphNode)null, var1, var11, var9, var10, 0);

            IGraphNode var14;
            IGraphNode var18;
            int var23;
            for(var23 = var22; var23 >= 1; --var23) {
               var14 = (IGraphNode)var9.get(Integer.valueOf(var23));
               IGraphNode var15 = (IGraphNode)var10.get(var14);
               IGraphNode var16 = var15;
               Iterator var17 = var14.getParents().iterator();

               IGraphNode var19;
               while(var17.hasNext()) {
                  var18 = (IGraphNode)var17.next();
                  var19 = null;
                  if(((Integer)var11.get(var18)).intValue() <= ((Integer)var11.get(var14)).intValue()) {
                     var19 = var18;
                  } else {
                     var19 = (IGraphNode)var6.get(getAncestorWithLowestSemi(var18, var11, var6, var7, var5));
                  }

                  if(((Integer)var11.get(var19)).intValue() < ((Integer)var11.get(var16)).intValue()) {
                     var16 = var19;
                  }
               }

               var6.put(var14, var16);
               ((Set)var20.get(var16)).add(var14);
               link(var15, var14, var7, var5);
               var17 = ((Set)var20.get(var15)).iterator();

               while(var17.hasNext()) {
                  var18 = (IGraphNode)var17.next();
                  var19 = getAncestorWithLowestSemi(var18, var11, var6, var7, var5);
                  if(var6.get(var19) == var6.get(var18)) {
                     var21.put(var18, var15);
                  } else {
                     var8.put(var18, var19);
                  }
               }

               ((Set)var20.get(var15)).clear();
            }

            for(var23 = 1; var23 <= var22; ++var23) {
               var14 = (IGraphNode)var9.get(Integer.valueOf(var23));
               if(var8.get(var14) != null) {
                  var21.put(var14, var21.get(var8.get(var14)));
               }
            }

            TreeNode var24 = null;
            HashMap var25 = new HashMap();
            Iterator var26 = var21.entrySet().iterator();

            Entry var27;
            while(var26.hasNext()) {
               var27 = (Entry)var26.next();
               TreeNode var28 = new TreeNode(var27.getKey());
               var25.put(var27.getKey(), var28);
               if(var27.getValue() == null) {
                  var24 = var28;
               }
            }

            var26 = var21.entrySet().iterator();

            while(var26.hasNext()) {
               var27 = (Entry)var26.next();
               IGraphNode var29 = (IGraphNode)var27.getKey();
               var18 = (IGraphNode)var27.getValue();
               if(var18 != null) {
                  ((ITreeNode)var25.get(var18)).addChild((ITreeNode)var25.get(var29));
                  ((ITreeNode)var25.get(var29)).setParent((ITreeNode)var25.get(var18));
               }
            }

            return new Pair(new Tree(var24), var25);
         }
      }
   }

   public static Pair calculate(IDirectedGraph var0, IGraphNode var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Root node argument can not be null");
      return var0.nodeCount() == 0?new Pair((Object)null, (Object)null):calculate((Collection)var0.getNodes(), var1);
   }
}
