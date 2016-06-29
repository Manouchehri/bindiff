package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

class ModesMenu$InternalSettingsListener extends GraphSettingsChangedListenerAdapter
{
    final /* synthetic */ ModesMenu this$0;
    
    private ModesMenu$InternalSettingsListener(final ModesMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void autoLayoutChanged(final GraphLayoutSettings graphLayoutSettings) {
        this.this$0.automaticLayout.setSelected(graphLayoutSettings.getAutomaticLayouting());
    }
    
    @Override
    public void diffViewModeChanged(final GraphSettings graphSettings) {
        switch (ModesMenu$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[graphSettings.getDiffViewMode().ordinal()]) {
            case 1: {
                this.this$0.normalViewMode.setSelected(true);
                break;
            }
            case 2: {
                this.this$0.combinedViewMode.setSelected(true);
                break;
            }
        }
    }
    
    @Override
    public void graphSyncChanged(final GraphSettings graphSettings) {
        this.this$0.synchronizeGraphs.setSelected(graphSettings.getGraphSyncMode() == EGraphSynchronization.SYNC);
    }
    
    @Override
    public void proximityBrowsingChanged(final GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        this.this$0.proximityBrowsing.setSelected(graphProximityBrowsingSettings.getProximityBrowsing());
    }
    
    @Override
    public void proximityBrowsingFrozenChanged(final GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        this.this$0.proximityFreezeMode.setSelected(graphProximityBrowsingSettings.getProximityBrowsingFrozen());
    }
}
