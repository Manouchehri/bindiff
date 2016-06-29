/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$1;

class ModesMenu$InternalSettingsListener
extends GraphSettingsChangedListenerAdapter {
    final /* synthetic */ ModesMenu this$0;

    private ModesMenu$InternalSettingsListener(ModesMenu modesMenu) {
        this.this$0 = modesMenu;
    }

    @Override
    public void autoLayoutChanged(GraphLayoutSettings graphLayoutSettings) {
        ModesMenu.access$100(this.this$0).setSelected(graphLayoutSettings.getAutomaticLayouting());
    }

    @Override
    public void diffViewModeChanged(GraphSettings graphSettings) {
        switch (ModesMenu$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[graphSettings.getDiffViewMode().ordinal()]) {
            case 1: {
                ModesMenu.access$200(this.this$0).setSelected(true);
                return;
            }
            case 2: {
                ModesMenu.access$300(this.this$0).setSelected(true);
                break;
            }
        }
    }

    @Override
    public void graphSyncChanged(GraphSettings graphSettings) {
        ModesMenu.access$400(this.this$0).setSelected(graphSettings.getGraphSyncMode() == EGraphSynchronization.SYNC);
    }

    @Override
    public void proximityBrowsingChanged(GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        ModesMenu.access$500(this.this$0).setSelected(graphProximityBrowsingSettings.getProximityBrowsing());
    }

    @Override
    public void proximityBrowsingFrozenChanged(GraphProximityBrowsingSettings graphProximityBrowsingSettings) {
        ModesMenu.access$600(this.this$0).setSelected(graphProximityBrowsingSettings.getProximityBrowsingFrozen());
    }

    /* synthetic */ ModesMenu$InternalSettingsListener(ModesMenu modesMenu, ModesMenu$1 modesMenu$1) {
        this(modesMenu);
    }
}

