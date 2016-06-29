package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ITextNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator$1;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewNodeAdapter;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class ProximityRangeCalculator {
   private static Set getGroupMembers(IGroupNode var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getElements().iterator();

      while(var2.hasNext()) {
         IViewNode var3 = (IViewNode)var2.next();
         var1.add(new ViewNodeAdapter(var3));
      }

      return var1;
   }

   private static Set getParentGroups(ZyGraphNode var0) {
      HashSet var1 = new HashSet();

      for(IGroupNode var2 = var0.getRawNode().getParentGroup(); var2 != null; var2 = var2.getParentGroup()) {
         var1.add(new ViewNodeAdapter(var2));
      }

      return var1;
   }

   private static List getPredecessors(Iterable var0, int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         ViewNodeAdapter var4 = (ViewNodeAdapter)var3.next();
         var2.addAll(getPredecessors(var4, var1));
      }

      return var2;
   }

   private static Set getPredecessors(ViewNodeAdapter var0, int var1) {
      HashSet var2 = new HashSet();
      getPredecessorsInternal(var0, var1, var2, new HashSet());
      return var2;
   }

   private static void getPredecessorsInternal(ViewNodeAdapter var0, int var1, Set var2, Set var3) {
      Iterator var4 = var0.getParents().iterator();

      while(true) {
         ViewNodeAdapter var5;
         do {
            if(!var4.hasNext()) {
               return;
            }

            var5 = (ViewNodeAdapter)var4.next();
         } while(var1 <= 0 && !(var5.getNode() instanceof ITextNode));

         if(var5.getNode().getParentGroup() != null) {
            IGroupNode var6 = var5.getNode().getParentGroup();

            while(var6 != null) {
               if(!visited(var3, var6)) {
                  ViewNodeAdapter var7 = new ViewNodeAdapter(var6);
                  var3.add(var7);
                  var2.add(var7);
                  var6 = var6.getParentGroup();
               } else {
                  var6 = null;
               }
            }
         }

         var3.add(var5);
         var2.add(var5);
         getSuccessorsInternal(var5, -1, var2, new HashSet());
         getPredecessorsInternal(var5, var1 - 1, var2, var3);
      }
   }

   private static int getRealDepth(int var0) {
      return var0 == -1?Integer.MAX_VALUE:var0;
   }

   private static List getSuccessors(Iterable var0, int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         ViewNodeAdapter var4 = (ViewNodeAdapter)var3.next();
         var2.addAll(getSuccessors(var4, var1));
      }

      return var2;
   }

   private static Set getSuccessors(ViewNodeAdapter var0, int var1) {
      HashSet var2 = new HashSet();
      getSuccessorsInternal(var0, var1, var2, new HashSet());
      return var2;
   }

   private static void getSuccessorsInternal(ViewNodeAdapter var0, int var1, Set var2, HashSet var3) {
      Iterator var4 = var0.getChildren().iterator();

      while(true) {
         ViewNodeAdapter var5;
         do {
            if(!var4.hasNext()) {
               return;
            }

            var5 = (ViewNodeAdapter)var4.next();
         } while(var1 <= 0 && !(var5.getNode() instanceof ITextNode));

         if(var5.getNode().getParentGroup() != null) {
            IGroupNode var6 = var5.getNode().getParentGroup();

            while(var6 != null) {
               if(!visited(var3, var6)) {
                  ViewNodeAdapter var7 = new ViewNodeAdapter(var6);
                  var3.add(var7);
                  var2.add(var7);
                  var6 = var6.getParentGroup();
               } else {
                  var6 = null;
               }
            }
         }

         if(NodeHelpers.getVisibleNode(var5.getNode()) == var5.getNode()) {
            var3.add(var5);
            var2.add(var5);
            getPredecessorsInternal(var5, -1, var2, new HashSet());
            getSuccessorsInternal(var5, var1 - 1, var2, var3);
         }
      }
   }

   private static boolean visited(Set var0, IGroupNode var1) {
      return CollectionHelpers.any(var0, new ProximityRangeCalculator$1(var1));
   }

   public static Set getNeighbors(AbstractZyGraph var0, Collection var1, int var2, int var3) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Nodes argument can not be null");
      LinkedHashSet var4 = new LinkedHashSet(var1);
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         ZyGraphNode var6 = (ZyGraphNode)var5.next();
         ArrayList var7 = new ArrayList();
         var7.add(var6);
         List var8 = GraphConverters.convert(var7);
         List var9 = ViewNodeAdapter.wrap(Lists.newArrayList((Iterable)var8));
         List var10 = getPredecessors((Iterable)var9, getRealDepth(var3));
         List var11 = getSuccessors((Iterable)var9, getRealDepth(var2));
         var4.addAll(ViewNodeAdapter.unwrap(var0, getParentGroups(var6)));
         if(var6.getRawNode() instanceof IGroupNode && var6.isSelected()) {
            var4.addAll(ViewNodeAdapter.unwrap(var0, getGroupMembers((IGroupNode)var6.getRawNode())));
         }

         var4.addAll(ViewNodeAdapter.unwrap(var0, var10));
         var4.addAll(ViewNodeAdapter.unwrap(var0, var11));
      }

      return var4;
   }
}
