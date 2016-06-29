/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class GraphsMenu$InternalGraphSelectionListener
implements IZyGraphSelectionListener {
    final /* synthetic */ GraphsMenu this$0;

    private GraphsMenu$InternalGraphSelectionListener(GraphsMenu graphsMenu) {
        this.this$0 = graphsMenu;
    }

    private int countSelectedMatchedNodes(CombinedGraph combinedGraph) {
        int n2 = 0;
        Iterator iterator = combinedGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            if (combinedDiffNode.getRawNode().getMatchState() != EMatchState.MATCHED) continue;
            ++n2;
        }
        return n2;
    }

    private int countSelectedNodes(SingleGraph singleGraph, boolean bl2) {
        int n2 = 0;
        Iterator iterator = singleGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            if (bl2 && singleDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                ++n2;
                continue;
            }
            if (bl2 || singleDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) continue;
            ++n2;
        }
        return n2;
    }

    private int countSelectedUnmatchedNodes(CombinedGraph combinedGraph, ESide eSide) {
        int n2 = 0;
        Iterator iterator = combinedGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            if (eSide == ESide.PRIMARY && combinedDiffNode.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                ++n2;
                continue;
            }
            if (eSide != ESide.SECONDARY || combinedDiffNode.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) continue;
            ++n2;
        }
        return n2;
    }

    @Override
    public void selectionChanged() {
        GraphsContainer graphsContainer = GraphsMenu.access$100(this.this$0).getGraphs();
        boolean bl2 = false;
        boolean bl3 = false;
        if (graphsContainer.getPrimaryGraph().getNodes().size() != 0 && graphsContainer.getSecondaryGraph().getNodes().size() != 0) {
            if (GraphsMenu.access$100(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                bl2 = this.countSelectedNodes(graphsContainer.getPrimaryGraph(), false) == 1 && this.countSelectedNodes(graphsContainer.getSecondaryGraph(), false) == 1;
                bl3 = this.countSelectedNodes(graphsContainer.getPrimaryGraph(), true) > 0 || this.countSelectedNodes(graphsContainer.getSecondaryGraph(), true) > 0;
            } else if (GraphsMenu.access$100(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
                CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
                bl2 = this.countSelectedUnmatchedNodes(combinedGraph, ESide.PRIMARY) == 1 && this.countSelectedUnmatchedNodes(combinedGraph, ESide.SECONDARY) == 1;
                bl3 = this.countSelectedMatchedNodes(combinedGraph) > 0;
            }
        }
        GraphsMenu.access$200(this.this$0).setEnabled(bl2);
        GraphsMenu.access$300(this.this$0).setEnabled(bl3);
    }

    /* synthetic */ GraphsMenu$InternalGraphSelectionListener(GraphsMenu graphsMenu, GraphsMenu$1 graphsMenu$1) {
        this(graphsMenu);
    }
}

