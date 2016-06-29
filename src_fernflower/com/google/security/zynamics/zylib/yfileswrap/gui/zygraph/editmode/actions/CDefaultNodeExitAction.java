package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.c.q;

public class CDefaultNodeExitAction implements IStateAction {
   protected void clearTooltip(AbstractZyGraph var1) {
      var1.getView().setToolTipText((String)null);
   }

   protected void unhighlightEdges(q var1) {
      CEdgeHighlighter.highlightEdgesOfNode(var1, false);
   }

   protected void unhighlightNode(q var1) {
      CNodeHighlighter.highlightNode(var1, false);
   }

   public void execute(CNodeExitState var1, MouseEvent var2) {
      this.clearTooltip(var1.getGraph());
      if(var1.getNode().e() != null) {
         this.unhighlightNode(var1.getNode());
         this.unhighlightEdges(var1.getNode());
      }

      ZyGraphNode var3 = var1.getGraph().getNode(var1.getNode());
      if(var3 != null) {
         Iterator var4 = var1.getStateFactory().getListeners().iterator();

         while(var4.hasNext()) {
            IZyEditModeListener var5 = (IZyEditModeListener)var4.next();

            try {
               var5.nodeLeft(var3);
            } catch (Exception var7) {
               ;
            }
         }
      }

      var1.getGraph().updateViews();
   }
}
