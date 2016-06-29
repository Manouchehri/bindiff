package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;

public class ModesMenu extends JMenu
{
    private JRadioButtonMenuItem normalViewMode;
    private JRadioButtonMenuItem combinedViewMode;
    private JCheckBoxMenuItem synchronizeGraphs;
    private JCheckBoxMenuItem automaticLayout;
    private JCheckBoxMenuItem proximityBrowsing;
    private JCheckBoxMenuItem proximityFreezeMode;
    private ModesMenu$InternalSettingsListener settingsListener;
    private ViewTabPanelFunctions controller;
    
    public ModesMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Mode");
        this.settingsListener = new ModesMenu$InternalSettingsListener(this, null);
        this.setMnemonic('M');
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.normalViewMode = GuiUtils.buildRadioButtonMenuItem("Normal View Mode", 'N', 49, menuShortcutKeyMask, new SwitchToNormalViewModeAction(viewTabPanelFunctions));
        this.combinedViewMode = GuiUtils.buildRadioButtonMenuItem("Combined View Mode", 'C', 50, menuShortcutKeyMask, new SwitchToCombinedViewModeAction(viewTabPanelFunctions));
        this.synchronizeGraphs = GuiUtils.buildCheckBoxMenuItem("Synchronize Graphs", 'S', 119, 0, new ToggleGraphSynchronizationAction(viewTabPanelFunctions));
        this.automaticLayout = GuiUtils.buildCheckBoxMenuItem("Automatic Layout", 'A', 116, 0, new ToggleAutomaticLayoutAction(viewTabPanelFunctions));
        this.proximityBrowsing = GuiUtils.buildCheckBoxMenuItem("Proximity Browsing", 'P', 117, 0, new ToggleProximityBrowsingAction(viewTabPanelFunctions));
        this.proximityFreezeMode = GuiUtils.buildCheckBoxMenuItem("Proximity Freeze-Mode", 'F', 118, 0, new ToggleProximityFreezeModeAction(viewTabPanelFunctions));
        final ButtonGroup buttonGroup = new ButtonGroup();
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
        final GraphSettings graphSettings = viewTabPanelFunctions.getGraphSettings();
        this.initStates(graphSettings);
        graphSettings.addListener(this.settingsListener);
    }
    
    private void initStates(final GraphSettings graphSettings) {
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
}
