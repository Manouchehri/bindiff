package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeMover;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeDraggedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Iterator;
import y.c.q;

public class CDefaultNodeDraggedLeftAction implements IStateAction {
   protected void moveToFront(ZyGraphLayeredRenderer var1, q var2) {
      var1.bringNodeToFront(var2);
   }

   public void execute(CNodeDraggedLeftState var1, MouseEvent var2) {
      CMouseCursorHelper.setHandCursor(var1.getGraph());
      this.moveToFront((ZyGraphLayeredRenderer)var1.getGraph().getView().getGraph2DRenderer(), var1.getNode());
      AbstractZyGraph var3 = var1.getGraph();
      HashSet var4 = new HashSet();
      ZyGraphNode var5 = var3.getNode(var1.getNode());
      ZyLabelContent var6 = var5.getRealizer().getNodeContent();
      if(var3.getEditMode().getLabelEventHandler().isActiveLabel(var6)) {
         CEditNodeHelper.setCaretEnd(var3, var1.getNode(), var2);
         CEditNodeHelper.select(var3, var1.getNode(), var2);
      } else if(var5.isSelected()) {
         Iterator var7 = var3.getSelectedNodes().iterator();

         while(var7.hasNext()) {
            ZyGraphNode var8 = (ZyGraphNode)var7.next();
            CNodeMover.moveNode(var3, var8, var1.getDistanceX(), var1.getDistanceY(), var4);
         }
      } else {
         CNodeMover.moveNode(var3, var5, var1.getDistanceX(), var1.getDistanceY(), var4);
      }

      var3.updateViews();
   }
}
