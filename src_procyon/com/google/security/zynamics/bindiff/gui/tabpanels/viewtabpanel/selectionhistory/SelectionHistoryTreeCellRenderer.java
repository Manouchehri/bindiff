package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import javax.swing.tree.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.*;
import java.util.*;

public class SelectionHistoryTreeCellRenderer extends DefaultTreeCellRenderer
{
    private static final Color NORMAL_FONT_COLOR;
    private static final Color INVISIBLE_FONT_COLOR;
    private static final Color SELECTED_FONT_COLOR;
    private static final Color MIXED_STATE_GROUP_NODE_COLOR;
    private final AbstractZyGraph graph;
    
    public SelectionHistoryTreeCellRenderer(final AbstractZyGraph abstractZyGraph) {
        this.graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph);
    }
    
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.WHITE);
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        final Icon icon = ((AbstractSelectionHistoryTreeNode)o).getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        final List filterNodes = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
        final List filterNodes2 = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.INVISIBLE);
        this.setForeground(SelectionHistoryTreeCellRenderer.NORMAL_FONT_COLOR);
        if (o instanceof SelectionHistoryTreeGroupNode) {
            final SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)o;
            if (!selectionHistoryTreeGroupNode.isRoot()) {
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                for (final ZyGraphNode zyGraphNode : selectionHistoryTreeGroupNode.getSnapshot().getSelection()) {
                    ++n2;
                    if (zyGraphNode.isVisible()) {
                        if (zyGraphNode.isSelected()) {
                            ++n3;
                        }
                        else {
                            ++n4;
                        }
                    }
                    else {
                        ++n5;
                    }
                }
                if (n2 == n3) {
                    this.setForeground(SelectionHistoryTreeCellRenderer.SELECTED_FONT_COLOR);
                }
                else if (n2 == n4) {
                    this.setForeground(SelectionHistoryTreeCellRenderer.NORMAL_FONT_COLOR);
                }
                else if (n2 == n5) {
                    this.setForeground(SelectionHistoryTreeCellRenderer.INVISIBLE_FONT_COLOR);
                }
                else {
                    this.setForeground(SelectionHistoryTreeCellRenderer.MIXED_STATE_GROUP_NODE_COLOR);
                }
            }
        }
        else if (o instanceof SelectionHistoryTreeNode) {
            final ZyGraphNode node = ((SelectionHistoryTreeNode)o).getNode();
            if (filterNodes.contains(node)) {
                this.setForeground(SelectionHistoryTreeCellRenderer.SELECTED_FONT_COLOR);
            }
            else if (filterNodes2.contains(node)) {
                this.setForeground(SelectionHistoryTreeCellRenderer.INVISIBLE_FONT_COLOR);
            }
        }
        return this;
    }
    
    static {
        NORMAL_FONT_COLOR = new Color(0, 0, 0);
        INVISIBLE_FONT_COLOR = new Color(128, 128, 128);
        SELECTED_FONT_COLOR = new Color(160, 0, 0);
        MIXED_STATE_GROUP_NODE_COLOR = new Color(160, 120, 120);
    }
}
