package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CGraphSelector;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.SwingUtilities;
import y.c.q;
import y.h.eR;
import y.h.a.p;

public class CDefaultNodeClickedLeftAction implements IStateAction {
   private void toggleGroup(ZyGraphNode var1) {
      IGroupNode var2 = (IGroupNode)var1.getRawNode();
      var2.setCollapsed(!var2.isCollapsed());
   }

   public void execute(CNodeClickedLeftState var1, MouseEvent var2) {
      CMouseCursorHelper.setDefaultCursor(var1.getGraph());
      AbstractZyGraph var3 = var1.getGraph();
      q var4 = var1.getNode();
      ZyGraphNode var5 = var3.getNode(var4);
      double var6 = var3.getEditMode().translateX(var2.getX());
      double var8 = var3.getEditMode().translateY(var2.getY());
      CStateFactory var10 = var1.getStateFactory();
      if(ProximityHelper.isProximityNode(var1.getGraph().getGraph(), var4)) {
         CEditNodeHelper.removeCaret(var3);
         ZyProximityNode var11 = ProximityHelper.getProximityNode(var3.getGraph(), var4);
         Iterator var12 = var10.getListeners().iterator();

         while(var12.hasNext()) {
            IZyEditModeListener var13 = (IZyEditModeListener)var12.next();

            try {
               var13.proximityBrowserNodeClicked(var11, var2, var6, var8);
            } catch (Exception var16) {
               ;
            }
         }
      } else if(var5 != null && var5.getRawNode() instanceof IGroupNode) {
         CEditNodeHelper.removeCaret(var3);
         p var19 = (p)var3.getGraph().t(var5.getNode());
         eR var22 = var19.getStateLabel();
         if(var22.getBox().a(var6, var8)) {
            this.toggleGroup(var5);
         } else if(SwingUtilities.isLeftMouseButton(var2)) {
            if(var2.getClickCount() == 2 && var2.isControlDown()) {
               this.toggleGroup(var5);
            } else if(var2.getClickCount() == 1) {
               CGraphSelector.selectNode(var3, var5, var2.isShiftDown());
            }
         }
      } else if(var5 != null) {
         if(var3.getEditMode().getLabelEventHandler().isActiveLabel(var5.getRealizer().getNodeContent())) {
            CEditNodeHelper.setCaretEnd(var3, var1.getNode(), var2);
         } else {
            if(var3.getEditMode().getLabelEventHandler().isActive()) {
               CEditNodeHelper.removeCaret(var3);
            }

            Set var17 = var3.getSelectedNodes();
            if(var2.isShiftDown() && var17.size() >= 1) {
               CGraphSelector.selectPath(var3, new ArrayList(var17), var5);
            } else if(var2.isControlDown()) {
               var3.selectNode(var5, !var5.isSelected());
            } else {
               ArrayList var20 = new ArrayList(var3.getNodes());
               var20.remove(var5);
               ArrayList var23 = new ArrayList();
               var23.add(var5);
               var3.selectNodes(var23, var20);
            }
         }

         Iterator var18 = var10.getListeners().iterator();

         while(var18.hasNext()) {
            IZyEditModeListener var21 = (IZyEditModeListener)var18.next();

            try {
               var21.nodeClicked(var5, var2, var6, var8);
            } catch (Exception var15) {
               ;
            }
         }
      }

   }
}
