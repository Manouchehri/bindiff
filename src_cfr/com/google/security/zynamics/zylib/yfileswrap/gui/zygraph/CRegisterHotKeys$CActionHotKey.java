/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.functions.NodeFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.MoveFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.ZoomFunctions;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import y.h.ch;

class CRegisterHotKeys$CActionHotKey
extends AbstractAction {
    private static final long serialVersionUID = 4029488848855226091L;
    private final String m_action;
    private final AbstractZyGraph m_graph;

    public CRegisterHotKeys$CActionHotKey(String string, AbstractZyGraph abstractZyGraph) {
        super(string);
        this.m_action = string;
        this.m_graph = abstractZyGraph;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (this.m_action.equals("UP")) {
            MoveFunctions.pan(this.m_graph, 0.0, -1.0);
            return;
        }
        if (this.m_action.equals("DOWN")) {
            MoveFunctions.pan(this.m_graph, 0.0, 1.0);
            return;
        }
        if (this.m_action.equals("LEFT")) {
            MoveFunctions.pan(this.m_graph, -1.0, 0.0);
            return;
        }
        if (this.m_action.equals("RIGHT")) {
            MoveFunctions.pan(this.m_graph, 1.0, 0.0);
            return;
        }
        if (this.m_action.equals("+")) {
            this.m_graph.zoomIn();
            return;
        }
        if (this.m_action.equals("-")) {
            this.m_graph.zoomOut();
            return;
        }
        if (this.m_action.equals("m")) {
            this.m_graph.getView().fitContent(true);
            return;
        }
        if (this.m_action.equals("s")) {
            ZoomFunctions.zoomToNodes(this.m_graph, SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes()));
            return;
        }
        if (this.m_action.equals("SELECT_VISIBLE_NODES")) {
            List list = NodeFunctions.getVisibleNodes(this.m_graph);
            this.m_graph.selectNodes((Collection)list, true);
            return;
        }
        if (!this.m_action.equals("COPY_CONTENT_FROM_SELECTED_NODES")) return;
        ClipboardHelpers.copyToClipboard(GraphHelpers.getSelectedContent(this.m_graph));
    }
}

