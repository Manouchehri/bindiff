package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class CallGraphPopupMenu extends JPopupMenu
{
    public CallGraphPopupMenu(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkNotNull(zyGraphNode);
        final JMenuItem menuItem = new JMenuItem(new OpenFlowGraphsViewAction(viewTabPanelFunctions, zyGraphNode));
        final JMenuItem menuItem2 = new JMenuItem(new ZoomToNodeAction(binDiffGraph, zyGraphNode));
        this.add(menuItem);
        this.add(new JSeparator());
        this.add(menuItem2);
        this.add(new JSeparator());
        if (zyGraphNode instanceof CombinedDiffNode) {
            final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
            if (combinedDiffNode.getPrimaryDiffNode() != null) {
                final JMenuItem menuItem3 = new JMenuItem(new CopyFunctionAddressAction(combinedDiffNode, ESide.PRIMARY));
                final JMenuItem menuItem4 = new JMenuItem(new CopyFunctionNameAction(combinedDiffNode, ESide.PRIMARY));
                this.add(menuItem3);
                this.add(menuItem4);
            }
            if (combinedDiffNode.getSecondaryDiffNode() != null) {
                final JMenuItem menuItem5 = new JMenuItem(new CopyFunctionAddressAction(combinedDiffNode, ESide.SECONDARY));
                final JMenuItem menuItem6 = new JMenuItem(new CopyFunctionNameAction(combinedDiffNode, ESide.SECONDARY));
                this.add(menuItem5);
                this.add(menuItem6);
            }
        }
        else if (zyGraphNode instanceof SingleDiffNode) {
            final JMenuItem menuItem7 = new JMenuItem(new CopyFunctionAddressAction((SingleDiffNode)zyGraphNode));
            final JMenuItem menuItem8 = new JMenuItem(new CopyFunctionNameAction((SingleDiffNode)zyGraphNode));
            this.add(menuItem7);
            this.add(menuItem8);
        }
    }
}
