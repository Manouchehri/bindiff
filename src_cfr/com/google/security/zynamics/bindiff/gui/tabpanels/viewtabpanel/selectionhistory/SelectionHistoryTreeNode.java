/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class SelectionHistoryTreeNode
extends AbstractSelectionHistoryTreeNode {
    private static final ImageIcon ICON_SELECTED_GRAPHNODE = ImageUtils.getImageIcon("data/selectionicons/graphnode-selection.png");
    private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes.png");
    private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES_GRAY = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes-gray.png");
    private final ZyGraphNode node;

    public SelectionHistoryTreeNode(ZyGraphNode zyGraphNode) {
        super(SelectionHistoryTreeNode.getNodeName(zyGraphNode));
        this.node = zyGraphNode;
    }

    private static String getCombinedNodeName(CombinedDiffNode combinedDiffNode) {
        String string = "";
        CombinedViewNode combinedViewNode = combinedDiffNode.getRawNode();
        SingleViewNode singleViewNode = combinedViewNode.getRawNode(ESide.PRIMARY);
        if (singleViewNode == null) {
            string = String.valueOf(string).concat("Unmatched");
        } else {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(SelectionHistoryTreeNode.getSingleNodeName(singleViewNode));
            string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        }
        string = String.valueOf(string).concat(" \u2194 ");
        SingleViewNode singleViewNode2 = combinedViewNode.getRawNode(ESide.SECONDARY);
        if (singleViewNode2 == null) {
            return String.valueOf(string).concat("Unmatched");
        }
        String string4 = String.valueOf(string);
        String string5 = String.valueOf(SelectionHistoryTreeNode.getSingleNodeName(singleViewNode2));
        return string5.length() != 0 ? string4.concat(string5) : new String(string4);
    }

    private static String getNodeName(ZyGraphNode zyGraphNode) {
        String string = "";
        if (zyGraphNode instanceof SingleDiffNode) {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(SelectionHistoryTreeNode.getSingleNodeName((SingleViewNode)zyGraphNode.getRawNode()));
            return string3.length() != 0 ? string2.concat(string3) : new String(string2);
        }
        if (!(zyGraphNode instanceof CombinedDiffNode)) return string;
        String string4 = String.valueOf(string);
        String string5 = String.valueOf(SelectionHistoryTreeNode.getCombinedNodeName((CombinedDiffNode)zyGraphNode));
        return string5.length() != 0 ? string4.concat(string5) : new String(string4);
    }

    private static String getSingleNodeName(SingleViewNode singleViewNode) {
        String string = "";
        if (singleViewNode instanceof RawFunction) {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(singleViewNode.getAddress());
            String string4 = ((RawFunction)singleViewNode).getName();
            return new StringBuilder(1 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length()).append(string2).append(string3).append(" ").append(string4).toString();
        }
        if (!(singleViewNode instanceof RawBasicBlock)) return string;
        String string5 = String.valueOf(string);
        String string6 = String.valueOf(singleViewNode.getAddress());
        return new StringBuilder(0 + String.valueOf(string5).length() + String.valueOf(string6).length()).append(string5).append(string6).toString();
    }

    @Override
    public ImageIcon getIcon() {
        if (!this.node.isVisible()) {
            return ICON_NO_SELECTED_GRAPHNODES_GRAY;
        }
        if (!this.node.isSelected()) return ICON_NO_SELECTED_GRAPHNODES;
        return ICON_SELECTED_GRAPHNODE;
    }

    public ZyGraphNode getNode() {
        return this.node;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        SelectionHistoryRootNode selectionHistoryRootNode = this.getRootNode();
        BinDiffGraph binDiffGraph = selectionHistoryRootNode.getGraph();
        if (binDiffGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return new CallGraphPopupMenu(this.getRootNode().getController(), binDiffGraph, this.node);
        }
        if (binDiffGraph.getGraphType() != EGraphType.FLOWGRAPH) return null;
        return new FlowGraphPopupMenu(this.getRootNode().getController(), binDiffGraph, this.node);
    }
}

