package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater$InternalGraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.awt.Window;
import javax.swing.SwingUtilities;

public class GraphLayoutUpdater implements ICommand {
   private final BinDiffGraph referenceGraph;
   private final boolean showProgress;

   public GraphLayoutUpdater(BinDiffGraph var1, boolean var2) {
      this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(var1);
      this.showProgress = var2;
   }

   private static Window getParentWindow(BinDiffGraph var0) {
      return var0.getSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW?BinDiffGraph.getParentWindow(var0.getPrimaryGraph()):BinDiffGraph.getParentWindow(var0.getCombinedGraph());
   }

   public static void executeStatic(BinDiffGraph var0, boolean var1) {
      GraphLayoutCalculator var2 = new GraphLayoutCalculator(var0);
      Window var3 = getParentWindow(var0.getPrimaryGraph());

      try {
         if(var1) {
            CUnlimitedProgressDialog var4 = new CUnlimitedProgressDialog(var3, "BinDiff", "Calculating the new graph layout...", var2);
            var4.setVisible(true);
            if(var4.wasCanceled()) {
               return;
            }

            if(var4.getException() != null) {
               throw var4.getException();
            }
         } else {
            var2.execute();
         }
      } catch (Exception var5) {
         throw new GraphLayoutException(var5, "Couldn\'t calculate graph layout.");
      }

      if(var1) {
         SwingUtilities.invokeLater(new GraphLayoutUpdater$InternalGraphViewUpdater(var2, var3));
      } else {
         GraphViewUpdater var6 = new GraphViewUpdater(var2);
         var6.execute();
      }

   }

   public void execute() {
      executeStatic(this.referenceGraph, this.showProgress);
   }
}
