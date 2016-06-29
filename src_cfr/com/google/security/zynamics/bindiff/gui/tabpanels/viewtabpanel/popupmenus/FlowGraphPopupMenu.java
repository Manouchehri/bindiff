/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.AddNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyBasicBlockAddressAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeleteNodeMatchAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToNodeAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Component;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FlowGraphPopupMenu
extends JPopupMenu {
    public FlowGraphPopupMenu(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        JMenuItem jMenuItem;
        if (binDiffGraph == null) {
            throw new IllegalArgumentException("Graph argument cannot be null");
        }
        if (zyGraphNode == null) {
            throw new IllegalArgumentException("Node argument cannot be null");
        }
        JMenuItem jMenuItem2 = new JMenuItem(new AddNodeMatchAction(viewTabPanelFunctions, binDiffGraph, zyGraphNode));
        JMenuItem jMenuItem3 = new JMenuItem(new DeleteNodeMatchAction(viewTabPanelFunctions, binDiffGraph, zyGraphNode));
        JMenuItem jMenuItem4 = new JMenuItem(new ZoomToNodeAction(binDiffGraph, zyGraphNode));
        jMenuItem2.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchAddable(binDiffGraph, zyGraphNode));
        jMenuItem3.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchDeleteable(binDiffGraph, zyGraphNode));
        this.add(jMenuItem2);
        this.add(jMenuItem3);
        this.add(new JSeparator());
        this.add(jMenuItem4);
        this.add(new JSeparator());
        if (!(zyGraphNode instanceof CombinedDiffNode)) {
            if (!(zyGraphNode instanceof SingleDiffNode)) return;
            JMenuItem jMenuItem5 = new JMenuItem(new CopyBasicBlockAddressAction((SingleDiffNode)zyGraphNode));
            this.add(jMenuItem5);
            return;
        }
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
        if (combinedDiffNode.getPrimaryDiffNode() != null) {
            jMenuItem = new JMenuItem(new CopyBasicBlockAddressAction(combinedDiffNode, ESide.PRIMARY));
            this.add(jMenuItem);
        }
        if (combinedDiffNode.getSecondaryDiffNode() == null) return;
        jMenuItem = new JMenuItem(new CopyBasicBlockAddressAction(combinedDiffNode, ESide.SECONDARY));
        this.add(jMenuItem);
    }
}

