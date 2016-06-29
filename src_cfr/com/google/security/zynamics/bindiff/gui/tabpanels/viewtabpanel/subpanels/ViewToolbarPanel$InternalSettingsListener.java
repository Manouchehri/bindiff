/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel$1;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JButton;

class ViewToolbarPanel$InternalSettingsListener
extends GraphSettingsChangedListenerAdapter {
    final /* synthetic */ ViewToolbarPanel this$0;

    private ViewToolbarPanel$InternalSettingsListener(ViewToolbarPanel viewToolbarPanel) {
        this.this$0 = viewToolbarPanel;
    }

    @Override
    public void autoLayoutChanged(GraphLayoutSettings graphLayoutSettings) {
        boolean bl2 = graphLayoutSettings.getAutomaticLayouting();
        JButton jButton = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(0);
        jButton.setIcon(bl2 ? ViewToolbarPanel.access$200() : ViewToolbarPanel.access$300());
        jButton.setRolloverIcon(bl2 ? ViewToolbarPanel.access$400() : ViewToolbarPanel.access$500());
        jButton.setPressedIcon(bl2 ? ViewToolbarPanel.access$600() : ViewToolbarPanel.access$700());
        this.this$0.updateUI();
    }

    @Override
    public void graphSyncChanged(GraphSettings graphSettings) {
        ViewToolbarPanel.access$1000(this.this$0).setIcon(graphSettings.isSync() ? ViewToolbarPanel.access$800() : ViewToolbarPanel.access$900());
        ViewToolbarPanel.access$1000(this.this$0).setRolloverIcon(graphSettings.isSync() ? ViewToolbarPanel.access$1100() : ViewToolbarPanel.access$1200());
        ViewToolbarPanel.access$1000(this.this$0).setPressedIcon(graphSettings.isSync() ? ViewToolbarPanel.access$1300() : ViewToolbarPanel.access$1400());
        this.this$0.updateUI();
    }

    @Override
    public void proximityBrowsingChanged(GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        boolean bl2 = graphProximityBrowsingSettings.getProximityBrowsing();
        this.proximityBrowsingFrozenChanged(graphProximityBrowsingSettings);
        JButton jButton = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(1);
        jButton.setIcon(bl2 ? ViewToolbarPanel.access$1500() : ViewToolbarPanel.access$1600());
        jButton.setRolloverIcon(bl2 ? ViewToolbarPanel.access$1700() : ViewToolbarPanel.access$1800());
        jButton.setPressedIcon(bl2 ? ViewToolbarPanel.access$1900() : ViewToolbarPanel.access$2000());
        this.this$0.updateUI();
    }

    @Override
    public void proximityBrowsingFrozenChanged(GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        boolean bl2 = graphProximityBrowsingSettings.getProximityBrowsing();
        boolean bl3 = graphProximityBrowsingSettings.getProximityBrowsingFrozen();
        if (bl2) {
            JButton jButton = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(2);
            jButton.setIcon(bl3 ? ViewToolbarPanel.access$2100() : ViewToolbarPanel.access$2200());
            jButton.setRolloverIcon(bl3 ? ViewToolbarPanel.access$2300() : ViewToolbarPanel.access$2400());
            jButton.setPressedIcon(bl3 ? ViewToolbarPanel.access$2500() : ViewToolbarPanel.access$2600());
        } else {
            JButton jButton = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(2);
            jButton.setIcon(bl3 ? ViewToolbarPanel.access$2700() : ViewToolbarPanel.access$2800());
            jButton.setRolloverIcon(bl3 ? ViewToolbarPanel.access$2900() : ViewToolbarPanel.access$3000());
            jButton.setPressedIcon(bl3 ? ViewToolbarPanel.access$3100() : ViewToolbarPanel.access$3200());
        }
        this.this$0.updateUI();
    }

    /* synthetic */ ViewToolbarPanel$InternalSettingsListener(ViewToolbarPanel viewToolbarPanel, ViewToolbarPanel$1 viewToolbarPanel$1) {
        this(viewToolbarPanel);
    }
}

