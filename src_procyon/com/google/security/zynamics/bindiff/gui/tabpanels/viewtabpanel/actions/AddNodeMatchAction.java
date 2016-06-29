package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.general.*;

public class AddNodeMatchAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private final BinDiffGraph graph;
    private final ZyGraphNode clickedNode;
    
    public AddNodeMatchAction(final ViewTabPanelFunctions viewTabPanelFunctions) {
        this(viewTabPanelFunctions, null, null);
    }
    
    public AddNodeMatchAction(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph graph, final ZyGraphNode clickedNode) {
        super("Add Basic Block Match");
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
            final Pair affectedCombinedNodes = BasicBlockMatchAdder.getAffectedCombinedNodes(binDiffGraph);
            if (affectedCombinedNodes != null) {
                this.controller.addNodeMatch((CombinedDiffNode)affectedCombinedNodes.first(), (CombinedDiffNode)affectedCombinedNodes.second());
            }
        }
        else {
            final Pair affectedCombinedNodes2 = BasicBlockMatchAdder.getAffectedCombinedNodes(this.graph, this.clickedNode);
            if (affectedCombinedNodes2 != null) {
                this.controller.addNodeMatch((CombinedDiffNode)affectedCombinedNodes2.first(), (CombinedDiffNode)affectedCombinedNodes2.second());
            }
        }
    }
}
