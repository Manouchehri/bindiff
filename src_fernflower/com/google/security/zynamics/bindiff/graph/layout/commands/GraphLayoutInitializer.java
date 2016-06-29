package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserInitializer;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.zylib.types.common.ICommand;

public class GraphLayoutInitializer implements ICommand {
   private final BinDiffGraph graph;

   public GraphLayoutInitializer(BinDiffGraph var1) {
      Preconditions.checkNotNull(var1);
      this.graph = var1;
   }

   public static void executeStatic(BinDiffGraph var0) {
      GraphLayoutSettings var1 = var0.getSettings().getLayoutSettings();
      boolean var2 = var1.getAnimateLayout();
      var1.setAnimateLayout(false);

      try {
         ProximityBrowserInitializer.executeStatic(var0);
         if(LayoutCommandHelper.isAutolayout(var0)) {
            GraphLayoutUpdater.executeStatic(var0, false);
         }
      } finally {
         var1.setAnimateLayout(var2);
      }

   }

   public void execute() {
      executeStatic(this.graph);
   }
}
