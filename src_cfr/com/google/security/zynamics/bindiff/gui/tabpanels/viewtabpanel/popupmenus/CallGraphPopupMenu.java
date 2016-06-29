/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenFlowGraphsViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyFunctionAddressAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CopyFunctionNameAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ZoomToNodeAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Component;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class CallGraphPopupMenu
extends JPopupMenu {
    public CallGraphPopupMenu(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        JMenuItem jMenuItem;
        JMenuItem jMenuItem2;
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkNotNull(zyGraphNode);
        JMenuItem jMenuItem3 = new JMenuItem(new OpenFlowGraphsViewAction(viewTabPanelFunctions, zyGraphNode));
        JMenuItem jMenuItem4 = new JMenuItem(new ZoomToNodeAction(binDiffGraph, zyGraphNode));
        this.add(jMenuItem3);
        this.add(new JSeparator());
        this.add(jMenuItem4);
        this.add(new JSeparator());
        if (!(zyGraphNode instanceof CombinedDiffNode)) {
            if (!(zyGraphNode instanceof SingleDiffNode)) return;
            JMenuItem jMenuItem5 = new JMenuItem(new CopyFunctionAddressAction((SingleDiffNode)zyGraphNode));
            JMenuItem jMenuItem6 = new JMenuItem(new CopyFunctionNameAction((SingleDiffNode)zyGraphNode));
            this.add(jMenuItem5);
            this.add(jMenuItem6);
            return;
        }
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
        if (combinedDiffNode.getPrimaryDiffNode() != null) {
            jMenuItem2 = new JMenuItem(new CopyFunctionAddressAction(combinedDiffNode, ESide.PRIMARY));
            jMenuItem = new JMenuItem(new CopyFunctionNameAction(combinedDiffNode, ESide.PRIMARY));
            this.add(jMenuItem2);
            this.add(jMenuItem);
        }
        if (combinedDiffNode.getSecondaryDiffNode() == null) return;
        jMenuItem2 = new JMenuItem(new CopyFunctionAddressAction(combinedDiffNode, ESide.SECONDARY));
        jMenuItem = new JMenuItem(new CopyFunctionNameAction(combinedDiffNode, ESide.SECONDARY));
        this.add(jMenuItem2);
        this.add(jMenuItem);
    }
}

