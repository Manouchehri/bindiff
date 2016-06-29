package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Window;

final class GraphLayoutUpdater$InternalGraphViewUpdater implements Runnable {
   private final GraphLayoutCalculator layoutCalculator;
   private final Window window;

   public GraphLayoutUpdater$InternalGraphViewUpdater(GraphLayoutCalculator var1, Window var2) {
      this.layoutCalculator = var1;
      this.window = var2;
   }

   public void run() {
      try {
         GraphViewUpdater var1 = new GraphViewUpdater(this.layoutCalculator);
         var1.execute();
      } catch (GraphLayoutException var2) {
         CMessageBox.showWarning(this.window, "Couldn\'t update graph layout.");
         Logger.logException(var2, "Couldn\'t update graph layout.");
      }

   }
}
