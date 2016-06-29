package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ZoomToNodeAction extends AbstractAction {
   private final BinDiffGraph graph;
   private final ZyGraphNode node;

   public ZoomToNodeAction(BinDiffGraph var1, ZyGraphNode var2) {
      super(getTitel(var2));
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var1);
      this.node = (ZyGraphNode)Preconditions.checkNotNull(var2);
   }

   private static String getTitel(ZyGraphNode var0) {
      if(var0 != null) {
         if(var0.getRawNode() instanceof RawBasicBlock || var0.getRawNode() instanceof RawCombinedBasicBlock) {
            return "Zoom to Basicblock";
         }

         if(var0.getRawNode() instanceof RawFunction || var0.getRawNode() instanceof RawCombinedFunction) {
            return "Zoom to Function";
         }
      }

      return "Zoom to Node";
   }

   public void actionPerformed(ActionEvent var1) {
      GraphZoomer.zoomToNode(this.graph, this.node);
   }
}
