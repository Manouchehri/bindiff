package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.MoveFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.ZoomFunctions;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;

class CRegisterHotKeys$CActionHotKey extends AbstractAction {
   private static final long serialVersionUID = 4029488848855226091L;
   private final String m_action;
   private final AbstractZyGraph m_graph;

   public CRegisterHotKeys$CActionHotKey(String var1, AbstractZyGraph var2) {
      super(var1);
      this.m_action = var1;
      this.m_graph = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      if(this.m_action.equals("UP")) {
         MoveFunctions.pan(this.m_graph, 0.0D, -1.0D);
      } else if(this.m_action.equals("DOWN")) {
         MoveFunctions.pan(this.m_graph, 0.0D, 1.0D);
      } else if(this.m_action.equals("LEFT")) {
         MoveFunctions.pan(this.m_graph, -1.0D, 0.0D);
      } else if(this.m_action.equals("RIGHT")) {
         MoveFunctions.pan(this.m_graph, 1.0D, 0.0D);
      } else if(this.m_action.equals("+")) {
         this.m_graph.zoomIn();
      } else if(this.m_action.equals("-")) {
         this.m_graph.zoomOut();
      } else if(this.m_action.equals("m")) {
         this.m_graph.getView().fitContent(true);
      } else if(this.m_action.equals("s")) {
         ZoomFunctions.zoomToNodes(this.m_graph, SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes()));
      } else if(this.m_action.equals("SELECT_VISIBLE_NODES")) {
         List var2 = NodeFunctions.getVisibleNodes(this.m_graph);
         this.m_graph.selectNodes(var2, true);
      } else if(this.m_action.equals("COPY_CONTENT_FROM_SELECTED_NODES")) {
         ClipboardHelpers.copyToClipboard(GraphHelpers.getSelectedContent(this.m_graph));
      }

   }
}
