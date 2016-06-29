/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class SelectionHistoryTreeCellRenderer
extends DefaultTreeCellRenderer {
    private static final Color NORMAL_FONT_COLOR = new Color(0, 0, 0);
    private static final Color INVISIBLE_FONT_COLOR = new Color(128, 128, 128);
    private static final Color SELECTED_FONT_COLOR = new Color(160, 0, 0);
    private static final Color MIXED_STATE_GROUP_NODE_COLOR = new Color(160, 120, 120);
    private final AbstractZyGraph graph;

    public SelectionHistoryTreeCellRenderer(AbstractZyGraph abstractZyGraph) {
        this.graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl2, boolean bl3, boolean bl4, int n2, boolean bl5) {
        Iterator iterator;
        int n3;
        int n4;
        int n5;
        int n6;
        this.setBackgroundSelectionColor(Color.WHITE);
        this.setBorderSelectionColor(Color.WHITE);
        super.getTreeCellRendererComponent(jTree, object, bl2, bl3, bl4, n2, bl5);
        Icon icon = ((AbstractSelectionHistoryTreeNode)object).getIcon();
        if (icon != null) {
            this.setIcon(icon);
        }
        List list = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
        List list2 = GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.INVISIBLE);
        this.setForeground(NORMAL_FONT_COLOR);
        if (object instanceof SelectionHistoryTreeGroupNode) {
            SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)object;
            if (selectionHistoryTreeGroupNode.isRoot()) return this;
            n6 = 0;
            n4 = 0;
            n5 = 0;
            n3 = 0;
            Collection collection = selectionHistoryTreeGroupNode.getSnapshot().getSelection();
            iterator = collection.iterator();
        } else {
            if (!(object instanceof SelectionHistoryTreeNode)) return this;
            SelectionHistoryTreeNode selectionHistoryTreeNode = (SelectionHistoryTreeNode)object;
            ZyGraphNode zyGraphNode = selectionHistoryTreeNode.getNode();
            if (list.contains(zyGraphNode)) {
                this.setForeground(SELECTED_FONT_COLOR);
                return this;
            }
            if (!list2.contains(zyGraphNode)) return this;
            this.setForeground(INVISIBLE_FONT_COLOR);
            return this;
        }
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            ++n6;
            if (zyGraphNode.isVisible()) {
                if (zyGraphNode.isSelected()) {
                    ++n4;
                    continue;
                }
                ++n5;
                continue;
            }
            ++n3;
        }
        if (n6 == n4) {
            this.setForeground(SELECTED_FONT_COLOR);
            return this;
        }
        if (n6 == n5) {
            this.setForeground(NORMAL_FONT_COLOR);
            return this;
        }
        if (n6 == n3) {
            this.setForeground(INVISIBLE_FONT_COLOR);
            return this;
        }
        this.setForeground(MIXED_STATE_GROUP_NODE_COLOR);
        return this;
    }
}

