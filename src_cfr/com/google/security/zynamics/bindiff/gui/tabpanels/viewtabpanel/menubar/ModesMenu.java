/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToCombinedViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToNormalViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleAutomaticLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleGraphSynchronizationAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityBrowsingAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityFreezeModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$InternalSettingsListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class ModesMenu
extends JMenu {
    private JRadioButtonMenuItem normalViewMode;
    private JRadioButtonMenuItem combinedViewMode;
    private JCheckBoxMenuItem synchronizeGraphs;
    private JCheckBoxMenuItem automaticLayout;
    private JCheckBoxMenuItem proximityBrowsing;
    private JCheckBoxMenuItem proximityFreezeMode;
    private ModesMenu$InternalSettingsListener settingsListener;
    private ViewTabPanelFunctions controller;

    public ModesMenu(ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Mode");
        this.settingsListener = new ModesMenu$InternalSettingsListener(this, null);
        this.setMnemonic('M');
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.normalViewMode = GuiUtils.buildRadioButtonMenuItem("Normal View Mode", 'N', 49, n2, new SwitchToNormalViewModeAction(viewTabPanelFunctions));
        this.combinedViewMode = GuiUtils.buildRadioButtonMenuItem("Combined View Mode", 'C', 50, n2, new SwitchToCombinedViewModeAction(viewTabPanelFunctions));
        this.synchronizeGraphs = GuiUtils.buildCheckBoxMenuItem("Synchronize Graphs", 'S', 119, 0, new ToggleGraphSynchronizationAction(viewTabPanelFunctions));
        this.automaticLayout = GuiUtils.buildCheckBoxMenuItem("Automatic Layout", 'A', 116, 0, new ToggleAutomaticLayoutAction(viewTabPanelFunctions));
        this.proximityBrowsing = GuiUtils.buildCheckBoxMenuItem("Proximity Browsing", 'P', 117, 0, new ToggleProximityBrowsingAction(viewTabPanelFunctions));
        this.proximityFreezeMode = GuiUtils.buildCheckBoxMenuItem("Proximity Freeze-Mode", 'F', 118, 0, new ToggleProximityFreezeModeAction(viewTabPanelFunctions));
        ButtonGroup buttonGroup = new ButtonGroup();
        this.normalViewMode.setSelected(true);
        buttonGroup.add(this.normalViewMode);
        buttonGroup.add(this.combinedViewMode);
        this.add(this.normalViewMode);
        this.add(this.combinedViewMode);
        this.add(new JSeparator());
        this.add(this.automaticLayout);
        this.add(this.proximityBrowsing);
        this.add(this.proximityFreezeMode);
        this.add(new JSeparator());
        this.add(this.synchronizeGraphs);
        GraphSettings graphSettings = viewTabPanelFunctions.getGraphSettings();
        this.initStates(graphSettings);
        graphSettings.addListener(this.settingsListener);
    }

    private void initStates(GraphSettings graphSettings) {
        switch (ModesMenu$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[graphSettings.getDiffViewMode().ordinal()]) {
            case 1: {
                this.normalViewMode.setSelected(true);
                break;
            }
            case 2: {
                this.combinedViewMode.setSelected(true);
                break;
            }
        }
        this.automaticLayout.setSelected(graphSettings.getLayoutSettings().getAutomaticLayouting());
        this.proximityBrowsing.setSelected(graphSettings.getProximitySettings().getProximityBrowsing());
        this.proximityFreezeMode.setSelected(graphSettings.getProximitySettings().getProximityBrowsingFrozen());
        this.synchronizeGraphs.setSelected(graphSettings.getGraphSyncMode() == EGraphSynchronization.SYNC);
    }

    public void dispose() {
        this.controller.getGraphSettings().removeListener(this.settingsListener);
        this.settingsListener = null;
        this.controller = null;
        this.normalViewMode = null;
        this.combinedViewMode = null;
        this.synchronizeGraphs = null;
        this.automaticLayout = null;
        this.proximityBrowsing = null;
        this.proximityFreezeMode = null;
    }

    static /* synthetic */ JCheckBoxMenuItem access$100(ModesMenu modesMenu) {
        return modesMenu.automaticLayout;
    }

    static /* synthetic */ JRadioButtonMenuItem access$200(ModesMenu modesMenu) {
        return modesMenu.normalViewMode;
    }

    static /* synthetic */ JRadioButtonMenuItem access$300(ModesMenu modesMenu) {
        return modesMenu.combinedViewMode;
    }

    static /* synthetic */ JCheckBoxMenuItem access$400(ModesMenu modesMenu) {
        return modesMenu.synchronizeGraphs;
    }

    static /* synthetic */ JCheckBoxMenuItem access$500(ModesMenu modesMenu) {
        return modesMenu.proximityBrowsing;
    }

    static /* synthetic */ JCheckBoxMenuItem access$600(ModesMenu modesMenu) {
        return modesMenu.proximityFreezeMode;
    }
}

