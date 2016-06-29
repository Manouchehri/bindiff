/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;

public class DerivedLabelEventHandler
extends CDefaultLabelEventHandler {
    public DerivedLabelEventHandler(AbstractZyGraph abstractZyGraph) {
        super(abstractZyGraph);
    }

    @Override
    public void activateLabelContent(ZyLabelContent zyLabelContent, IZyRegenerateableRealizer iZyRegenerateableRealizer) {
        SingleGraph singleGraph = ((BinDiffGraph)this.getGraph()).getPrimaryGraph();
        SingleGraph singleGraph2 = ((BinDiffGraph)this.getGraph()).getSecondaryGraph();
        CombinedGraph combinedGraph = ((BinDiffGraph)this.getGraph()).getCombinedGraph();
        ZyEditMode zyEditMode = singleGraph.getEditMode();
        ZyEditMode zyEditMode2 = singleGraph2.getEditMode();
        ZyEditMode zyEditMode3 = combinedGraph.getEditMode();
        CDefaultLabelEventHandler cDefaultLabelEventHandler = zyEditMode.getLabelEventHandler();
        CDefaultLabelEventHandler cDefaultLabelEventHandler2 = zyEditMode2.getLabelEventHandler();
        CDefaultLabelEventHandler cDefaultLabelEventHandler3 = zyEditMode3.getLabelEventHandler();
        if (!cDefaultLabelEventHandler.isActiveLabel(zyLabelContent)) {
            cDefaultLabelEventHandler.deactivateLabelContent();
        }
        if (!cDefaultLabelEventHandler2.isActiveLabel(zyLabelContent)) {
            cDefaultLabelEventHandler2.deactivateLabelContent();
        }
        if (!cDefaultLabelEventHandler3.isActiveLabel(zyLabelContent)) {
            cDefaultLabelEventHandler3.deactivateLabelContent();
        }
        super.activateLabelContent(zyLabelContent, iZyRegenerateableRealizer);
        singleGraph.updateViews();
        singleGraph2.updateViews();
        ((BinDiffGraph)this.getGraph()).getCombinedGraph().updateViews();
    }
}

