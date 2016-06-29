package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;

class ViewToolbarPanel$InternalSettingsListener extends GraphSettingsChangedListenerAdapter
{
    final /* synthetic */ ViewToolbarPanel this$0;
    
    private ViewToolbarPanel$InternalSettingsListener(final ViewToolbarPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void autoLayoutChanged(final GraphLayoutSettings graphLayoutSettings) {
        final boolean automaticLayouting = graphLayoutSettings.getAutomaticLayouting();
        final JButton button = (JButton)this.this$0.groupModes.getComponentAtIndex(0);
        button.setIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_UP : ViewToolbarPanel.AUTOLAYOUT_OFF_UP);
        button.setRolloverIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_HOVER : ViewToolbarPanel.AUTOLAYOUT_OFF_HOVER);
        button.setPressedIcon(automaticLayouting ? ViewToolbarPanel.AUTOLAYOUT_ON_DOWN : ViewToolbarPanel.AUTOLAYOUT_OFF_DOWN);
        this.this$0.updateUI();
    }
    
    @Override
    public void graphSyncChanged(final GraphSettings graphSettings) {
        this.this$0.graphSyncButton.setIcon(graphSettings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_ON_UP : ViewToolbarPanel.SYNC_GRAPHS_OFF_UP);
        this.this$0.graphSyncButton.setRolloverIcon(graphSettings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_ON_HOVER : ViewToolbarPanel.SYNC_GRAPHS_OFF_HOVER);
        this.this$0.graphSyncButton.setPressedIcon(graphSettings.isSync() ? ViewToolbarPanel.SYNC_GRAPHS_ON_DOWN : ViewToolbarPanel.SYNC_GRAPHS_OFF_DOWN);
        this.this$0.updateUI();
    }
    
    @Override
    public void proximityBrowsingChanged(final GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        final boolean proximityBrowsing = graphProximityBrowsingSettings.getProximityBrowsing();
        this.proximityBrowsingFrozenChanged(graphProximityBrowsingSettings);
        final JButton button = (JButton)this.this$0.groupModes.getComponentAtIndex(1);
        button.setIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_UP : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_UP);
        button.setRolloverIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_HOVER : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_HOVER);
        button.setPressedIcon(proximityBrowsing ? ViewToolbarPanel.PROXIMITY_BROWSING_ON_DOWN : ViewToolbarPanel.PROXIMITY_BROWSING_OFF_DOWN);
        this.this$0.updateUI();
    }
    
    @Override
    public void proximityBrowsingFrozenChanged(final GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        final boolean proximityBrowsing = graphProximityBrowsingSettings.getProximityBrowsing();
        final boolean proximityBrowsingFrozen = graphProximityBrowsingSettings.getProximityBrowsingFrozen();
        if (proximityBrowsing) {
            final JButton button = (JButton)this.this$0.groupModes.getComponentAtIndex(2);
            button.setIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_UP : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_UP);
            button.setRolloverIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_HOVER : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_HOVER);
            button.setPressedIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_DOWN : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_DOWN);
        }
        else {
            final JButton button2 = (JButton)this.this$0.groupModes.getComponentAtIndex(2);
            button2.setIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_UP_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_UP_GRAY);
            button2.setRolloverIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_HOVER_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_HOVER_GRAY);
            button2.setPressedIcon(proximityBrowsingFrozen ? ViewToolbarPanel.PROXIMITY_FREEZE_ON_DOWN_GRAY : ViewToolbarPanel.PROXIMITY_FREEZE_OFF_DOWN_GRAY);
        }
        this.this$0.updateUI();
    }
}
