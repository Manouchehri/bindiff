package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import com.google.security.zynamics.bindiff.graph.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SelectionHistoryTreeNode extends AbstractSelectionHistoryTreeNode
{
    private static final ImageIcon ICON_SELECTED_GRAPHNODE;
    private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES;
    private static final ImageIcon ICON_NO_SELECTED_GRAPHNODES_GRAY;
    private final ZyGraphNode node;
    
    public SelectionHistoryTreeNode(final ZyGraphNode node) {
        super(getNodeName(node));
        this.node = node;
    }
    
    private static String getCombinedNodeName(final CombinedDiffNode combinedDiffNode) {
        final String s = "";
        final CombinedViewNode rawNode = combinedDiffNode.getRawNode();
        final SingleViewNode rawNode2 = rawNode.getRawNode(ESide.PRIMARY);
        String concat;
        if (rawNode2 == null) {
            concat = String.valueOf(s).concat("Unmatched");
        }
        else {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(getSingleNodeName(rawNode2));
            concat = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        final String concat2 = String.valueOf(concat).concat(" \u2194 ");
        final SingleViewNode rawNode3 = rawNode.getRawNode(ESide.SECONDARY);
        String concat3;
        if (rawNode3 == null) {
            concat3 = String.valueOf(concat2).concat("Unmatched");
        }
        else {
            final String value3 = String.valueOf(concat2);
            final String value4 = String.valueOf(getSingleNodeName(rawNode3));
            concat3 = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
        }
        return concat3;
    }
    
    private static String getNodeName(final ZyGraphNode zyGraphNode) {
        String s = "";
        if (zyGraphNode instanceof SingleDiffNode) {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(getSingleNodeName((SingleViewNode)zyGraphNode.getRawNode()));
            s = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        else if (zyGraphNode instanceof CombinedDiffNode) {
            final String value3 = String.valueOf(s);
            final String value4 = String.valueOf(getCombinedNodeName((CombinedDiffNode)zyGraphNode));
            s = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
        }
        return s;
    }
    
    private static String getSingleNodeName(final SingleViewNode singleViewNode) {
        String s = "";
        if (singleViewNode instanceof RawFunction) {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(singleViewNode.getAddress());
            final String name = ((RawFunction)singleViewNode).getName();
            s = new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(name).length()).append(value).append(value2).append(" ").append(name).toString();
        }
        else if (singleViewNode instanceof RawBasicBlock) {
            final String value3 = String.valueOf(s);
            final String value4 = String.valueOf(singleViewNode.getAddress());
            s = new StringBuilder(0 + String.valueOf(value3).length() + String.valueOf(value4).length()).append(value3).append(value4).toString();
        }
        return s;
    }
    
    @Override
    public ImageIcon getIcon() {
        if (!this.node.isVisible()) {
            return SelectionHistoryTreeNode.ICON_NO_SELECTED_GRAPHNODES_GRAY;
        }
        if (this.node.isSelected()) {
            return SelectionHistoryTreeNode.ICON_SELECTED_GRAPHNODE;
        }
        return SelectionHistoryTreeNode.ICON_NO_SELECTED_GRAPHNODES;
    }
    
    public ZyGraphNode getNode() {
        return this.node;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final BinDiffGraph graph = this.getRootNode().getGraph();
        if (graph.getGraphType() == EGraphType.CALLGRAPH) {
            return new CallGraphPopupMenu(this.getRootNode().getController(), graph, this.node);
        }
        if (graph.getGraphType() == EGraphType.FLOWGRAPH) {
            return new FlowGraphPopupMenu(this.getRootNode().getController(), graph, this.node);
        }
        return null;
    }
    
    static {
        ICON_SELECTED_GRAPHNODE = ImageUtils.getImageIcon("data/selectionicons/graphnode-selection.png");
        ICON_NO_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes.png");
        ICON_NO_SELECTED_GRAPHNODES_GRAY = ImageUtils.getImageIcon("data/selectionicons/no-selected-graphnodes-gray.png");
    }
}
