package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class GraphColorizer {
   private static final LinkedHashSet recentColors = new LinkedHashSet();

   public static void colorizeInvisibleNodes(BinDiffGraph var0, Color var1) {
      Iterator var2 = var0.getNodes().iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(!var3.isVisible()) {
            var3.getRawNode().setColor(var1);
         }
      }

   }

   public static void colorizeSelectedNodes(BinDiffGraph var0, Color var1) {
      Iterator var2 = var0.getSelectedNodes().iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         var3.getRawNode().setColor(var1);
      }

   }

   public static void colorizeUnselectedNodes(BinDiffGraph var0, Color var1) {
      Iterator var2 = var0.getNodes().iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(!var3.isSelected()) {
            var3.getRawNode().setColor(var1);
         }
      }

   }

   public static List getRecentColors() {
      return new ArrayList(recentColors);
   }

   public static void setRecentColors(List var0) {
      recentColors.clear();
      recentColors.addAll(var0);
   }
}
