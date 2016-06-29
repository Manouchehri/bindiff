package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import y.f.*;
import y.b.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import y.h.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.bindiff.log.*;

public class GraphViewUpdater implements ICommand
{
    private final BinDiffGraph referenceGraph;
    private final GraphLayoutCalculator layoutCalculator;
    
    public GraphViewUpdater(final GraphLayoutCalculator layoutCalculator) {
        Preconditions.checkNotNull(layoutCalculator);
        this.layoutCalculator = layoutCalculator;
        this.referenceGraph = layoutCalculator.getReferenceGraph();
    }
    
    public static void updateViews(final BinDiffGraph binDiffGraph) {
        binDiffGraph.getPrimaryGraph().getGraph().T();
        binDiffGraph.getSecondaryGraph().getGraph().T();
        binDiffGraph.getCombinedGraph().getGraph().T();
        binDiffGraph.getSuperGraph().getGraph().T();
    }
    
    private void applyGraphLayout() {
        if (this.referenceGraph.getSettings().isSync()) {
            ae.a(this.referenceGraph.getPrimaryGraph().getGraph(), this.layoutCalculator.getPrimaryGraphLayout());
            ae.a(this.referenceGraph.getSecondaryGraph().getGraph(), this.layoutCalculator.getSecondaryGraphLayout());
            ae.a(this.referenceGraph.getCombinedGraph().getGraph(), this.layoutCalculator.getCombinedGraphLayout());
            this.referenceGraph.getCombinedGraph().getView().fitContent();
        }
        else {
            ae.a(this.referenceGraph.getGraph(), this.getReferenceGraphLayout());
            this.referenceGraph.getView().fitContent();
            this.referenceGraph.getView().setZoom(this.referenceGraph.getView().getZoom() * 0.95);
        }
    }
    
    private O getReferenceGraphLayout() {
        if (this.referenceGraph instanceof SingleGraph) {
            return (((SingleGraph)this.referenceGraph).getSide() == ESide.PRIMARY) ? this.layoutCalculator.getPrimaryGraphLayout() : this.layoutCalculator.getSecondaryGraphLayout();
        }
        return this.layoutCalculator.getCombinedGraphLayout();
    }
    
    private void morphGraphLayout() {
        try {
            final GraphSettings settings = this.referenceGraph.getSettings();
            if (settings.isSync()) {
                if (settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                    ae.a(this.referenceGraph.getCombinedGraph().getGraph(), this.layoutCalculator.getCombinedGraphLayout());
                    this.referenceGraph.getCombinedGraph().getView().fitContent();
                    this.referenceGraph.getCombinedGraph().getView().setZoom(this.referenceGraph.getCombinedGraph().getView().getZoom() * 0.95);
                    this.morphTwoGraphLayouts();
                }
                else {
                    ae.a(this.referenceGraph.getPrimaryGraph().getGraph(), this.layoutCalculator.getPrimaryGraphLayout());
                    ae.a(this.referenceGraph.getSecondaryGraph().getGraph(), this.layoutCalculator.getSecondaryGraphLayout());
                    this.morphOneGraphLayout(this.referenceGraph, this.layoutCalculator.getCombinedGraphLayout());
                }
            }
            else {
                this.morphOneGraphLayout(this.referenceGraph, this.getReferenceGraphLayout());
            }
        }
        catch (Exception ex) {
            throw new GraphLayoutException(ex, "Graph layout failed. Could not morph graph layout.");
        }
    }
    
    private void morphOneGraphLayout(final BinDiffGraph binDiffGraph, final O o) {
        final y.f.c currentLayouter = binDiffGraph.getSettings().getLayoutSettings().getCurrentLayouter();
        final ch view = binDiffGraph.getView();
        currentLayouter.c(new V());
        currentLayouter.c(true);
        final int animationSpeed = binDiffGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        final e e = new e();
        e.a(true);
        e.a(view);
        final LayoutMorpher layoutMorpher = new LayoutMorpher(view, o);
        layoutMorpher.setKeepZoomFactor(false);
        layoutMorpher.setEasedExecution(true);
        layoutMorpher.setPreferredDuration(100 * animationSpeed);
        layoutMorpher.setSmoothViewTransform(true);
        final l a = b.a();
        a.a(layoutMorpher);
        e.a(a);
    }
    
    private void morphTwoGraphLayouts() {
        final bu graph = this.referenceGraph.getSuperGraph().getGraph();
        final O primaryGraphLayout = this.layoutCalculator.getPrimaryGraphLayout();
        final O secondaryGraphLayout = this.layoutCalculator.getSecondaryGraphLayout();
        final ch view = this.referenceGraph.getPrimaryGraph().getView();
        final ch view2 = this.referenceGraph.getSecondaryGraph().getView();
        final e e = new e();
        e.a(true);
        e.a(view);
        e.a(view2);
        final SuperLayoutMorpher superLayoutMorpher = new SuperLayoutMorpher(view, primaryGraphLayout, graph);
        final SuperLayoutMorpher superLayoutMorpher2 = new SuperLayoutMorpher(view2, secondaryGraphLayout, graph);
        final int animationSpeed = this.referenceGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        superLayoutMorpher.setSmoothViewTransform(true);
        superLayoutMorpher.setPreferredDuration(100 * animationSpeed);
        superLayoutMorpher.setEasedExecution(true);
        superLayoutMorpher2.setSmoothViewTransform(true);
        superLayoutMorpher2.setPreferredDuration(100 * animationSpeed);
        superLayoutMorpher2.setEasedExecution(true);
        final l a = b.a();
        a.a(superLayoutMorpher);
        a.a(superLayoutMorpher2);
        e.a(a);
    }
    
    @Override
    public void execute() {
        try {
            final GraphSettings settings = this.referenceGraph.getSettings();
            GraphViewFitter.adoptSuperViewCanvasProperties(this.referenceGraph.getSuperGraph());
            GraphViewFitter.fitSingleViewToSuperViewContent(this.referenceGraph.getSuperGraph());
            if (settings.getLayoutSettings().getAnimateLayout()) {
                this.morphGraphLayout();
            }
            else {
                this.applyGraphLayout();
            }
            updateViews(this.referenceGraph);
        }
        catch (GraphLayoutException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            Logger.logException(ex2, ex2.getMessage());
            throw new GraphLayoutException(ex2, "Could update graph view.");
        }
    }
}
