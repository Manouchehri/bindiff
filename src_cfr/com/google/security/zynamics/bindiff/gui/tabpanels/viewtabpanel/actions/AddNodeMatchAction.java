/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class AddNodeMatchAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;
    private final BinDiffGraph graph;
    private final ZyGraphNode clickedNode;

    public AddNodeMatchAction(ViewTabPanelFunctions viewTabPanelFunctions) {
        this(viewTabPanelFunctions, null, null);
    }

    public AddNodeMatchAction(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        super("Add Basic Block Match");
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = binDiffGraph;
        this.clickedNode = zyGraphNode;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GraphsContainer graphsContainer = this.controller.getGraphs();
        if (this.graph != null && this.clickedNode != null) {
            Pair pair = BasicBlockMatchAdder.getAffectedCombinedNodes(this.graph, this.clickedNode);
            if (pair == null) return;
            this.controller.addNodeMatch((CombinedDiffNode)pair.first(), (CombinedDiffNode)pair.second());
            return;
        }
        EDiffViewMode eDiffViewMode = this.controller.getGraphSettings().getDiffViewMode();
        BinDiffGraph binDiffGraph = null;
        if (eDiffViewMode == EDiffViewMode.COMBINED_VIEW) {
            binDiffGraph = graphsContainer.getCombinedGraph();
        } else if (eDiffViewMode == EDiffViewMode.NORMAL_VIEW) {
            binDiffGraph = graphsContainer.getPrimaryGraph();
        }
        Pair pair = BasicBlockMatchAdder.getAffectedCombinedNodes(binDiffGraph);
        if (pair == null) return;
        this.controller.addNodeMatch((CombinedDiffNode)pair.first(), (CombinedDiffNode)pair.second());
    }
}

