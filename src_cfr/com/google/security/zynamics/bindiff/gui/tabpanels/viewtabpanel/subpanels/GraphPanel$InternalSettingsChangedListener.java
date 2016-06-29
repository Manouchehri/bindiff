/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import y.h.ch;

class GraphPanel$InternalSettingsChangedListener
extends GraphSettingsChangedListenerAdapter {
    final /* synthetic */ GraphPanel this$0;

    private GraphPanel$InternalSettingsChangedListener(GraphPanel graphPanel) {
        this.this$0 = graphPanel;
    }

    @Override
    public void focusSideChanged(GraphSettings graphSettings) {
        GraphPanel.access$100(this.this$0, graphSettings);
        this.this$0.updateUI();
    }

    @Override
    public void graphSyncChanged(GraphSettings graphSettings) {
        GraphPanel.access$100(this.this$0, graphSettings);
        this.this$0.updateUI();
    }

    @Override
    public void showScrollbarsChanged(GraphSettings graphSettings) {
        if (graphSettings.getShowScrollbars()) {
            GraphPanel.access$200(this.this$0).getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(true);
            GraphPanel.access$200(this.this$0).getView().setHorizontalScrollBarPolicy(32);
            GraphPanel.access$200(this.this$0).getView().setVerticalScrollBarPolicy(22);
        } else {
            GraphPanel.access$200(this.this$0).getEditMode().setAdjustScrollBarPolicy(false);
            GraphPanel.access$200(this.this$0).getView().setHorizontalScrollBarPolicy(31);
            GraphPanel.access$200(this.this$0).getView().setVerticalScrollBarPolicy(21);
        }
        GraphPanel.access$200(this.this$0).getView().updateView();
    }

    /* synthetic */ GraphPanel$InternalSettingsChangedListener(GraphPanel graphPanel, GraphPanel$1 graphPanel$1) {
        this(graphPanel);
    }
}

