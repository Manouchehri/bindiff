package com.google.security.zynamics.bindiff.graph.layout;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;

public class LayoutCommandHelper {
   public static void activateAutoLayout(BinDiffGraph var0, boolean var1) {
      var0.getSettings().getLayoutSettings().setAutomaticLayouting(var1);
   }

   public static boolean deactiveAutoLayout(BinDiffGraph var0) {
      boolean var1 = isAutolayout(var0);
      var0.getSettings().getLayoutSettings().setAutomaticLayouting(false);
      return var1;
   }

   public static boolean hasSelectedNodes(BinDiffGraph var0) {
      GraphSettings var1 = var0.getSettings();
      return var1.isSync()?var0.getSuperGraph().getSelectedNodes().size() > 0:var0.getSelectedNodes().size() > 0;
   }

   public static boolean isAutolayout(BinDiffGraph var0) {
      return var0.getSettings().getLayoutSettings().getAutomaticLayouting();
   }

   public static boolean isProximityBrowsing(BinDiffGraph var0) {
      return var0.getSettings().getProximitySettings().getProximityBrowsing();
   }

   public static boolean isProximityBrowsingFrozen(BinDiffGraph var0) {
      return var0.getSettings().getProximitySettings().getProximityBrowsingFrozen();
   }

   public static boolean isSnychron(BinDiffGraph var0) {
      return var0.getSettings().isSync();
   }
}
