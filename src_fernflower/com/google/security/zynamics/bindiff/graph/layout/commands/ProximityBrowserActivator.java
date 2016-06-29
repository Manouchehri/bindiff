package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.zylib.types.common.ICommand;

public class ProximityBrowserActivator implements ICommand {
   private final BinDiffGraph graph;

   public ProximityBrowserActivator(BinDiffGraph var1) {
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var1);
   }

   public static void executeStatic(BinDiffGraph var0) {
      var0.getCombinedGraph().getProximityBrowser().freeProximitySettingsListener();
      var0.getSuperGraph().getProximityBrowser().freeProximitySettingsListener();

      try {
         var0.getSettings().getProximitySettings().setProximityBrowsing(true);
      } finally {
         var0.getSuperGraph().getProximityBrowser().blockProximitySettingsListener();
         var0.getCombinedGraph().getProximityBrowser().blockProximitySettingsListener();
      }

      if(!LayoutCommandHelper.isProximityBrowsingFrozen(var0)) {
         if(LayoutCommandHelper.hasSelectedNodes(var0)) {
            ProximityBrowserUpdater.executeStatic(var0);
            if(var0.getSettings().getLayoutSettings().getAutomaticLayouting() && !var0.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
               GraphLayoutUpdater.executeStatic(var0, true);
            }
         }

         GraphViewUpdater.updateViews(var0);
      }

   }

   public void execute() {
      executeStatic(this.graph);
   }
}
