package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;

public class DeleteNodeMatchAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private final BinDiffGraph graph;
    private final ZyGraphNode clickedNode;
    
    public DeleteNodeMatchAction(final ViewTabPanelFunctions viewTabPanelFunctions) {
        this(viewTabPanelFunctions, null, null);
    }
    
    public DeleteNodeMatchAction(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph graph, final ZyGraphNode clickedNode) {
        super("Delete Basic Block Matches");
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = graph;
        this.clickedNode = clickedNode;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final GraphsContainer graphs = this.controller.getGraphs();
        if (this.graph == null || this.clickedNode == null) {
            final EDiffViewMode diffViewMode = this.controller.getGraphSettings().getDiffViewMode();
            BinDiffGraph binDiffGraph = null;
            if (diffViewMode == EDiffViewMode.COMBINED_VIEW) {
                binDiffGraph = graphs.getCombinedGraph();
            }
            else if (diffViewMode == EDiffViewMode.NORMAL_VIEW) {
                binDiffGraph = graphs.getPrimaryGraph();
            }
            final List affectedCombinedNodes = BasicBlockMatchRemover.getAffectedCombinedNodes(binDiffGraph);
            if (affectedCombinedNodes != null) {
                this.controller.removeNodeMatch(affectedCombinedNodes);
            }
        }
        else {
            final List affectedCombinedNodes2 = BasicBlockMatchRemover.getAffectedCombinedNodes(this.graph, this.clickedNode);
            if (affectedCombinedNodes2 != null) {
                this.controller.removeNodeMatch(affectedCombinedNodes2);
            }
        }
    }
}
