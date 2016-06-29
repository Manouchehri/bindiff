package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.*;
import com.google.security.zynamics.zylib.gui.zygraph.functions.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.general.*;

class CRegisterHotKeys$CActionHotKey extends AbstractAction
{
    private static final long serialVersionUID = 4029488848855226091L;
    private final String m_action;
    private final AbstractZyGraph m_graph;
    
    public CRegisterHotKeys$CActionHotKey(final String action, final AbstractZyGraph graph) {
        super(action);
        this.m_action = action;
        this.m_graph = graph;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.m_action.equals("UP")) {
            MoveFunctions.pan(this.m_graph, 0.0, -1.0);
        }
        else if (this.m_action.equals("DOWN")) {
            MoveFunctions.pan(this.m_graph, 0.0, 1.0);
        }
        else if (this.m_action.equals("LEFT")) {
            MoveFunctions.pan(this.m_graph, -1.0, 0.0);
        }
        else if (this.m_action.equals("RIGHT")) {
            MoveFunctions.pan(this.m_graph, 1.0, 0.0);
        }
        else if (this.m_action.equals("+")) {
            this.m_graph.zoomIn();
        }
        else if (this.m_action.equals("-")) {
            this.m_graph.zoomOut();
        }
        else if (this.m_action.equals("m")) {
            this.m_graph.getView().fitContent(true);
        }
        else if (this.m_action.equals("s")) {
            ZoomFunctions.zoomToNodes(this.m_graph, SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes()));
        }
        else if (this.m_action.equals("SELECT_VISIBLE_NODES")) {
            this.m_graph.selectNodes(NodeFunctions.getVisibleNodes(this.m_graph), true);
        }
        else if (this.m_action.equals("COPY_CONTENT_FROM_SELECTED_NODES")) {
            ClipboardHelpers.copyToClipboard(GraphHelpers.getSelectedContent(this.m_graph));
        }
    }
}
