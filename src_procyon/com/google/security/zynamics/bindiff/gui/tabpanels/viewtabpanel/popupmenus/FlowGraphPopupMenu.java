package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class FlowGraphPopupMenu extends JPopupMenu
{
    public FlowGraphPopupMenu(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        if (binDiffGraph == null) {
            throw new IllegalArgumentException("Graph argument cannot be null");
        }
        if (zyGraphNode == null) {
            throw new IllegalArgumentException("Node argument cannot be null");
        }
        final JMenuItem menuItem = new JMenuItem(new AddNodeMatchAction(viewTabPanelFunctions, binDiffGraph, zyGraphNode));
        final JMenuItem menuItem2 = new JMenuItem(new DeleteNodeMatchAction(viewTabPanelFunctions, binDiffGraph, zyGraphNode));
        final JMenuItem menuItem3 = new JMenuItem(new ZoomToNodeAction(binDiffGraph, zyGraphNode));
        menuItem.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchAddable(binDiffGraph, zyGraphNode));
        menuItem2.setEnabled(ViewTabPanelFunctions.isNodeSelectionMatchDeleteable(binDiffGraph, zyGraphNode));
        this.add(menuItem);
        this.add(menuItem2);
        this.add(new JSeparator());
        this.add(menuItem3);
        this.add(new JSeparator());
        if (zyGraphNode instanceof CombinedDiffNode) {
            final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
            if (combinedDiffNode.getPrimaryDiffNode() != null) {
                this.add(new JMenuItem(new CopyBasicBlockAddressAction(combinedDiffNode, ESide.PRIMARY)));
            }
            if (combinedDiffNode.getSecondaryDiffNode() != null) {
                this.add(new JMenuItem(new CopyBasicBlockAddressAction(combinedDiffNode, ESide.SECONDARY)));
            }
        }
        else if (zyGraphNode instanceof SingleDiffNode) {
            this.add(new JMenuItem(new CopyBasicBlockAddressAction((SingleDiffNode)zyGraphNode)));
        }
    }
}
