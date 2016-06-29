package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;

public class DerivedLabelEventHandler extends CDefaultLabelEventHandler
{
    public DerivedLabelEventHandler(final AbstractZyGraph abstractZyGraph) {
        super(abstractZyGraph);
    }
    
    @Override
    public void activateLabelContent(final ZyLabelContent zyLabelContent, final IZyRegenerateableRealizer zyRegenerateableRealizer) {
        final SingleGraph primaryGraph = ((BinDiffGraph)this.getGraph()).getPrimaryGraph();
        final SingleGraph secondaryGraph = ((BinDiffGraph)this.getGraph()).getSecondaryGraph();
        final CombinedGraph combinedGraph = ((BinDiffGraph)this.getGraph()).getCombinedGraph();
        final ZyEditMode editMode = primaryGraph.getEditMode();
        final ZyEditMode editMode2 = secondaryGraph.getEditMode();
        final ZyEditMode editMode3 = combinedGraph.getEditMode();
        final CDefaultLabelEventHandler labelEventHandler = editMode.getLabelEventHandler();
        final CDefaultLabelEventHandler labelEventHandler2 = editMode2.getLabelEventHandler();
        final CDefaultLabelEventHandler labelEventHandler3 = editMode3.getLabelEventHandler();
        if (!labelEventHandler.isActiveLabel(zyLabelContent)) {
            labelEventHandler.deactivateLabelContent();
        }
        if (!labelEventHandler2.isActiveLabel(zyLabelContent)) {
            labelEventHandler2.deactivateLabelContent();
        }
        if (!labelEventHandler3.isActiveLabel(zyLabelContent)) {
            labelEventHandler3.deactivateLabelContent();
        }
        super.activateLabelContent(zyLabelContent, zyRegenerateableRealizer);
        primaryGraph.updateViews();
        secondaryGraph.updateViews();
        ((BinDiffGraph)this.getGraph()).getCombinedGraph().updateViews();
    }
}
