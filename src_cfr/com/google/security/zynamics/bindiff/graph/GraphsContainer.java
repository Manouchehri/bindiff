/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer$1;
import com.google.security.zynamics.bindiff.graph.GraphsContainer$2;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.util.Iterator;
import java.util.List;

public class GraphsContainer
extends AbstractGraphsContainer {
    private final List graphs;
    private Diff diff;

    public GraphsContainer(Diff diff, SuperGraph superGraph, CombinedGraph combinedGraph, SingleGraph singleGraph, SingleGraph singleGraph2) {
        Preconditions.checkNotNull(superGraph);
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(singleGraph);
        Preconditions.checkNotNull(singleGraph2);
        this.diff = diff;
        this.graphs = new GraphsContainer$1(this, 4, singleGraph, singleGraph2, combinedGraph, superGraph);
        Iterator iterator = this.graphs.iterator();
        do {
            if (!iterator.hasNext()) {
                combinedGraph.getSelectionHistory().registerMatchListener();
                singleGraph.getSelectionHistory().registerMatchListener();
                singleGraph2.getSelectionHistory().registerMatchListener();
                return;
            }
            BinDiffGraph binDiffGraph = (BinDiffGraph)iterator.next();
            binDiffGraph.setGraphs(this);
        } while (true);
    }

    @Override
    public void dispose() {
        Iterator iterator = this.graphs.iterator();
        do {
            if (!iterator.hasNext()) {
                this.graphs.clear();
                return;
            }
            BinDiffGraph binDiffGraph = (BinDiffGraph)iterator.next();
            if (binDiffGraph == null) continue;
            binDiffGraph.dispose();
        } while (true);
    }

    @Override
    public CombinedGraph getCombinedGraph() {
        return (CombinedGraph)this.graphs.get(EGraph.COMBINED_GRAPH.ordinal());
    }

    public Diff getDiff() {
        return this.diff;
    }

    @Override
    public BinDiffGraph getFocusedGraph() {
        switch (GraphsContainer$2.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.getSettings().getDiffViewMode().ordinal()]) {
            case 1: {
                if (this.getSettings().isSync()) {
                    return this.getSuperGraph();
                }
                if (this.getSettings().getFocus() != ESide.PRIMARY) return this.getSecondaryGraph();
                return this.getPrimaryGraph();
            }
            case 2: {
                return this.getCombinedGraph();
            }
            case 3: {
                return null;
            }
        }
        throw new IllegalStateException("Illegal view mode.");
    }

    @Override
    public SingleGraph getPrimaryGraph() {
        return (SingleGraph)this.graphs.get(EGraph.PRIMARY_GRAPH.ordinal());
    }

    @Override
    public SingleGraph getSecondaryGraph() {
        return (SingleGraph)this.graphs.get(EGraph.SECONDARY_GRAPH.ordinal());
    }

    @Override
    public GraphSettings getSettings() {
        return ((SuperGraph)this.graphs.get(EGraph.SUPER_GRAPH.ordinal())).getSettings();
    }

    @Override
    public SuperGraph getSuperGraph() {
        return (SuperGraph)this.graphs.get(EGraph.SUPER_GRAPH.ordinal());
    }

    public Iterator iterator() {
        return this.graphs.iterator();
    }

    public void setDiff(Diff diff) {
        this.diff = diff;
    }

    @Override
    public void updateViews() {
        Iterator iterator = this.graphs.iterator();
        while (iterator.hasNext()) {
            BinDiffGraph binDiffGraph = (BinDiffGraph)iterator.next();
            if (binDiffGraph == null) continue;
            binDiffGraph.updateViews();
        }
    }
}

