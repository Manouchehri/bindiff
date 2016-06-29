package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;

class GraphPanel$InternalSettingsChangedListener extends GraphSettingsChangedListenerAdapter
{
    final /* synthetic */ GraphPanel this$0;
    
    private GraphPanel$InternalSettingsChangedListener(final GraphPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void focusSideChanged(final GraphSettings graphSettings) {
        this.this$0.setFocusBorder(graphSettings);
        this.this$0.updateUI();
    }
    
    @Override
    public void graphSyncChanged(final GraphSettings graphSettings) {
        this.this$0.setFocusBorder(graphSettings);
        this.this$0.updateUI();
    }
    
    @Override
    public void showScrollbarsChanged(final GraphSettings graphSettings) {
        if (graphSettings.getShowScrollbars()) {
            this.this$0.graph.getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(true);
            this.this$0.graph.getView().setHorizontalScrollBarPolicy(32);
            this.this$0.graph.getView().setVerticalScrollBarPolicy(22);
        }
        else {
            this.this$0.graph.getEditMode().setAdjustScrollBarPolicy(false);
            this.this$0.graph.getView().setHorizontalScrollBarPolicy(31);
            this.this$0.graph.getView().setVerticalScrollBarPolicy(21);
        }
        this.this$0.graph.getView().updateView();
    }
}
