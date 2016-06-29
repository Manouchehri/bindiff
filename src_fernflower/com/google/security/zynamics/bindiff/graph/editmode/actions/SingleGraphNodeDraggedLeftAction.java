package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.helpers.GraphElementMover;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeDraggedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeDraggedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import y.c.q;

public class SingleGraphNodeDraggedLeftAction implements IStateAction {
   protected void moveToFront(ZyGraphLayeredRenderer var1, q var2) {
      var1.bringNodeToFront(var2);
   }

   public void execute(CNodeDraggedLeftState var1, MouseEvent var2) {
      (new CDefaultNodeDraggedLeftAction()).execute(var1, var2);
      AbstractZyGraph var3 = var1.getGraph();
      ZyGraphNode var4 = var3.getNode(var1.getNode());
      ZyLabelContent var5 = var4.getRealizer().getNodeContent();
      if(!var3.getEditMode().getLabelEventHandler().isActiveLabel(var5)) {
         q var6 = var1.getNode();
         this.moveToFront((ZyGraphLayeredRenderer)var3.getView().getGraph2DRenderer(), var6);
         GraphElementMover.moveNodes(var3, var6, var1.getDistanceX(), var1.getDistanceY());
      }

   }
}
