package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.c.q;

public class CDefaultNodeEnterAction implements IStateAction {
   protected void highlightEdges(q var1) {
      CEdgeHighlighter.highlightEdgesOfNode(var1, true);
   }

   protected void highlightNode(q var1) {
      CNodeHighlighter.highlightNode(var1, true);
   }

   protected void updateTooltip(AbstractZyGraph var1, q var2) {
      CTooltipUpdater.updateNodeTooltip(var1, var2);
   }

   public void execute(CNodeEnterState var1, MouseEvent var2) {
      this.highlightNode(var1.getNode());
      this.highlightEdges(var1.getNode());
      this.updateTooltip(var1.getGraph(), var1.getNode());
      AbstractZyGraph var3 = var1.getGraph();
      ZyGraphNode var4 = var3.getNode(var1.getNode());
      Iterator var5 = var1.getStateFactory().getListeners().iterator();

      while(var5.hasNext()) {
         IZyEditModeListener var6 = (IZyEditModeListener)var5.next();

         try {
            var6.nodeEntered(var4, var2);
         } catch (Exception var8) {
            ;
         }
      }

      var3.updateViews();
   }
}
