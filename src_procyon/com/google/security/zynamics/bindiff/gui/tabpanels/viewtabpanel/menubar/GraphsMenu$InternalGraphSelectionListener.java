package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

class GraphsMenu$InternalGraphSelectionListener implements IZyGraphSelectionListener
{
    final /* synthetic */ GraphsMenu this$0;
    
    private GraphsMenu$InternalGraphSelectionListener(final GraphsMenu this$0) {
        this.this$0 = this$0;
    }
    
    private int countSelectedMatchedNodes(final CombinedGraph combinedGraph) {
        int n = 0;
        final Iterator<CombinedDiffNode> iterator = (Iterator<CombinedDiffNode>)combinedGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getRawNode().getMatchState() == EMatchState.MATCHED) {
                ++n;
            }
        }
        return n;
    }
    
    private int countSelectedNodes(final SingleGraph singleGraph, final boolean b) {
        int n = 0;
        for (final SingleDiffNode singleDiffNode : singleGraph.getSelectedNodes()) {
            if (b && singleDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                ++n;
            }
            else {
                if (b || singleDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                    continue;
                }
                ++n;
            }
        }
        return n;
    }
    
    private int countSelectedUnmatchedNodes(final CombinedGraph combinedGraph, final ESide eSide) {
        int n = 0;
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getSelectedNodes()) {
            if (eSide == ESide.PRIMARY && combinedDiffNode.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                ++n;
            }
            else {
                if (eSide != ESide.SECONDARY || combinedDiffNode.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
                    continue;
                }
                ++n;
            }
        }
        return n;
    }
    
    @Override
    public void selectionChanged() {
        final GraphsContainer graphs = this.this$0.controller.getGraphs();
        boolean enabled = false;
        boolean enabled2 = false;
        if (graphs.getPrimaryGraph().getNodes().size() != 0 && graphs.getSecondaryGraph().getNodes().size() != 0) {
            if (this.this$0.controller.getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                enabled = (this.countSelectedNodes(graphs.getPrimaryGraph(), false) == 1 && this.countSelectedNodes(graphs.getSecondaryGraph(), false) == 1);
                enabled2 = (this.countSelectedNodes(graphs.getPrimaryGraph(), true) > 0 || this.countSelectedNodes(graphs.getSecondaryGraph(), true) > 0);
            }
            else if (this.this$0.controller.getGraphSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
                final CombinedGraph combinedGraph = graphs.getCombinedGraph();
                enabled = (this.countSelectedUnmatchedNodes(combinedGraph, ESide.PRIMARY) == 1 && this.countSelectedUnmatchedNodes(combinedGraph, ESide.SECONDARY) == 1);
                enabled2 = (this.countSelectedMatchedNodes(combinedGraph) > 0);
            }
        }
        this.this$0.addMatch.setEnabled(enabled);
        this.this$0.deleteMatch.setEnabled(enabled2);
    }
}
