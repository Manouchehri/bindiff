package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

public class GraphsContainer extends AbstractGraphsContainer
{
    private final List graphs;
    private Diff diff;
    
    public GraphsContainer(final Diff diff, final SuperGraph superGraph, final CombinedGraph combinedGraph, final SingleGraph singleGraph, final SingleGraph singleGraph2) {
        Preconditions.checkNotNull(superGraph);
        Preconditions.checkNotNull(combinedGraph);
        Preconditions.checkNotNull(singleGraph);
        Preconditions.checkNotNull(singleGraph2);
        this.diff = diff;
        this.graphs = new GraphsContainer$1(this, 4, singleGraph, singleGraph2, combinedGraph, superGraph);
        final Iterator<BinDiffGraph> iterator = this.graphs.iterator();
        while (iterator.hasNext()) {
            iterator.next().setGraphs(this);
        }
        combinedGraph.getSelectionHistory().registerMatchListener();
        singleGraph.getSelectionHistory().registerMatchListener();
        singleGraph2.getSelectionHistory().registerMatchListener();
    }
    
    @Override
    public void dispose() {
        for (final BinDiffGraph binDiffGraph : this.graphs) {
            if (binDiffGraph == null) {
                continue;
            }
            binDiffGraph.dispose();
        }
        this.graphs.clear();
    }
    
    @Override
    public CombinedGraph getCombinedGraph() {
        return this.graphs.get(EGraph.COMBINED_GRAPH.ordinal());
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
                if (this.getSettings().getFocus() == ESide.PRIMARY) {
                    return this.getPrimaryGraph();
                }
                return this.getSecondaryGraph();
            }
            case 2: {
                return this.getCombinedGraph();
            }
            case 3: {
                return null;
            }
            default: {
                throw new IllegalStateException("Illegal view mode.");
            }
        }
    }
    
    @Override
    public SingleGraph getPrimaryGraph() {
        return this.graphs.get(EGraph.PRIMARY_GRAPH.ordinal());
    }
    
    @Override
    public SingleGraph getSecondaryGraph() {
        return this.graphs.get(EGraph.SECONDARY_GRAPH.ordinal());
    }
    
    @Override
    public GraphSettings getSettings() {
        return this.graphs.get(EGraph.SUPER_GRAPH.ordinal()).getSettings();
    }
    
    @Override
    public SuperGraph getSuperGraph() {
        return this.graphs.get(EGraph.SUPER_GRAPH.ordinal());
    }
    
    @Override
    public Iterator iterator() {
        return this.graphs.iterator();
    }
    
    public void setDiff(final Diff diff) {
        this.diff = diff;
    }
    
    @Override
    public void updateViews() {
        for (final BinDiffGraph binDiffGraph : this.graphs) {
            if (binDiffGraph != null) {
                binDiffGraph.updateViews();
            }
        }
    }
}
