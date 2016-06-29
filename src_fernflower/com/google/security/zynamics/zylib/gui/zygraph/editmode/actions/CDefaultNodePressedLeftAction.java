package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodePressedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;

public class CDefaultNodePressedLeftAction implements IStateAction {
   public void execute(CNodePressedLeftState var1, MouseEvent var2) {
      AbstractZyGraph var3 = var1.getGraph();
      ZyGraphNode var4 = var3.getNode(var1.getNode());
      if(var4 != null) {
         ZyLabelContent var5 = var4.getRealizer().getNodeContent();
         if(var3.getEditMode().getLabelEventHandler().isActiveLabel(var5)) {
            CEditNodeHelper.setCaretStart(var3, var1.getNode(), var2);
            CEditNodeHelper.setCaretEnd(var3, var1.getNode(), var2);
         } else {
            CEditNodeHelper.removeCaret(var3);
         }
      } else {
         CEditNodeHelper.removeCaret(var3);
      }

   }
}
