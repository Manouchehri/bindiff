/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.layout.LayoutMorpher;
import com.google.security.zynamics.bindiff.graph.layout.SuperLayoutMorpher;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutCalculator;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.types.common.ICommand;
import y.b.b;
import y.b.d;
import y.b.e;
import y.b.l;
import y.f.O;
import y.f.V;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.c;
import y.h.bu;
import y.h.ch;

public class GraphViewUpdater
implements ICommand {
    private final BinDiffGraph referenceGraph;
    private final GraphLayoutCalculator layoutCalculator;

    public GraphViewUpdater(GraphLayoutCalculator graphLayoutCalculator) {
        Preconditions.checkNotNull(graphLayoutCalculator);
        this.layoutCalculator = graphLayoutCalculator;
        this.referenceGraph = graphLayoutCalculator.getReferenceGraph();
    }

    public static void updateViews(BinDiffGraph binDiffGraph) {
        binDiffGraph.getPrimaryGraph().getGraph().T();
        binDiffGraph.getSecondaryGraph().getGraph().T();
        binDiffGraph.getCombinedGraph().getGraph().T();
        binDiffGraph.getSuperGraph().getGraph().T();
    }

    private void applyGraphLayout() {
        GraphSettings graphSettings = this.referenceGraph.getSettings();
        if (graphSettings.isSync()) {
            ae.a((X)this.referenceGraph.getPrimaryGraph().getGraph(), this.layoutCalculator.getPrimaryGraphLayout());
            ae.a((X)this.referenceGraph.getSecondaryGraph().getGraph(), this.layoutCalculator.getSecondaryGraphLayout());
            ae.a((X)this.referenceGraph.getCombinedGraph().getGraph(), this.layoutCalculator.getCombinedGraphLayout());
            this.referenceGraph.getCombinedGraph().getView().fitContent();
            return;
        }
        ae.a((X)this.referenceGraph.getGraph(), this.getReferenceGraphLayout());
        this.referenceGraph.getView().fitContent();
        this.referenceGraph.getView().setZoom(this.referenceGraph.getView().getZoom() * 0.95);
    }

    private O getReferenceGraphLayout() {
        O o2;
        if (!(this.referenceGraph instanceof SingleGraph)) return this.layoutCalculator.getCombinedGraphLayout();
        ESide eSide = ((SingleGraph)this.referenceGraph).getSide();
        if (eSide == ESide.PRIMARY) {
            o2 = this.layoutCalculator.getPrimaryGraphLayout();
            return o2;
        }
        o2 = this.layoutCalculator.getSecondaryGraphLayout();
        return o2;
    }

    private void morphGraphLayout() {
        try {
            GraphSettings graphSettings = this.referenceGraph.getSettings();
            if (!graphSettings.isSync()) {
                this.morphOneGraphLayout(this.referenceGraph, this.getReferenceGraphLayout());
                return;
            }
            if (graphSettings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                ae.a((X)this.referenceGraph.getCombinedGraph().getGraph(), this.layoutCalculator.getCombinedGraphLayout());
                this.referenceGraph.getCombinedGraph().getView().fitContent();
                double d2 = this.referenceGraph.getCombinedGraph().getView().getZoom() * 0.95;
                this.referenceGraph.getCombinedGraph().getView().setZoom(d2);
                this.morphTwoGraphLayouts();
                return;
            }
            ae.a((X)this.referenceGraph.getPrimaryGraph().getGraph(), this.layoutCalculator.getPrimaryGraphLayout());
            ae.a((X)this.referenceGraph.getSecondaryGraph().getGraph(), this.layoutCalculator.getSecondaryGraphLayout());
            this.morphOneGraphLayout(this.referenceGraph, this.layoutCalculator.getCombinedGraphLayout());
            return;
        }
        catch (Exception var1_2) {
            throw new GraphLayoutException(var1_2, "Graph layout failed. Could not morph graph layout.");
        }
    }

    private void morphOneGraphLayout(BinDiffGraph binDiffGraph, O o2) {
        GraphSettings graphSettings = binDiffGraph.getSettings();
        c c2 = graphSettings.getLayoutSettings().getCurrentLayouter();
        ch ch2 = binDiffGraph.getView();
        c2.c(new V());
        c2.c(true);
        int n2 = 100;
        int n3 = binDiffGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        e e2 = new e();
        e2.a(true);
        e2.a(ch2);
        LayoutMorpher layoutMorpher = new LayoutMorpher(ch2, o2);
        layoutMorpher.setKeepZoomFactor(false);
        layoutMorpher.setEasedExecution(true);
        layoutMorpher.setPreferredDuration(100 * n3);
        layoutMorpher.setSmoothViewTransform(true);
        l l2 = b.a();
        l2.a(layoutMorpher);
        e2.a(l2);
    }

    private void morphTwoGraphLayouts() {
        bu bu2 = this.referenceGraph.getSuperGraph().getGraph();
        O o2 = this.layoutCalculator.getPrimaryGraphLayout();
        O o3 = this.layoutCalculator.getSecondaryGraphLayout();
        ch ch2 = this.referenceGraph.getPrimaryGraph().getView();
        ch ch3 = this.referenceGraph.getSecondaryGraph().getView();
        e e2 = new e();
        e2.a(true);
        e2.a(ch2);
        e2.a(ch3);
        SuperLayoutMorpher superLayoutMorpher = new SuperLayoutMorpher(ch2, o2, bu2);
        SuperLayoutMorpher superLayoutMorpher2 = new SuperLayoutMorpher(ch3, o3, bu2);
        int n2 = this.referenceGraph.getSettings().getDisplaySettings().getAnimationSpeed();
        int n3 = 100;
        superLayoutMorpher.setSmoothViewTransform(true);
        superLayoutMorpher.setPreferredDuration(100 * n2);
        superLayoutMorpher.setEasedExecution(true);
        superLayoutMorpher2.setSmoothViewTransform(true);
        superLayoutMorpher2.setPreferredDuration(100 * n2);
        superLayoutMorpher2.setEasedExecution(true);
        l l2 = b.a();
        l2.a(superLayoutMorpher);
        l2.a(superLayoutMorpher2);
        e2.a(l2);
    }

    @Override
    public void execute() {
        try {
            GraphSettings graphSettings = this.referenceGraph.getSettings();
            GraphViewFitter.adoptSuperViewCanvasProperties(this.referenceGraph.getSuperGraph());
            GraphViewFitter.fitSingleViewToSuperViewContent(this.referenceGraph.getSuperGraph());
            if (graphSettings.getLayoutSettings().getAnimateLayout()) {
                this.morphGraphLayout();
            } else {
                this.applyGraphLayout();
            }
            GraphViewUpdater.updateViews(this.referenceGraph);
            return;
        }
        catch (GraphLayoutException var1_2) {
            throw var1_2;
        }
        catch (Exception var1_3) {
            Logger.logException(var1_3, var1_3.getMessage());
            throw new GraphLayoutException(var1_3, "Could update graph view.");
        }
    }
}

