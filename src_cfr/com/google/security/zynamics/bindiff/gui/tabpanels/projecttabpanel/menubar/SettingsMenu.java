/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.InitialCallGraphSettingsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.InitialFlowGraphSettingsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.MainSettingsAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SettingsMenu
extends JMenu {
    private final JMenuItem mainSettings;
    private final JMenuItem initialCallgraphSettings;
    private final JMenuItem initialFlowgraphSettings;

    public SettingsMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("Settings");
        this.setMnemonic('S');
        this.mainSettings = GuiUtils.buildMenuItem("Main Settings...", 77, 113, (AbstractAction)new MainSettingsAction(workspaceTabPanelFunctions));
        this.initialCallgraphSettings = GuiUtils.buildMenuItem("Initial Call Graph Settings...", 'C', 113, 64, new InitialCallGraphSettingsAction(workspaceTabPanelFunctions));
        this.initialFlowgraphSettings = GuiUtils.buildMenuItem("Initial Flow Graph Settings...", 'F', 113, 128, new InitialFlowGraphSettingsAction(workspaceTabPanelFunctions));
        this.add(this.mainSettings);
        this.add(new JSeparator());
        this.add(this.initialCallgraphSettings);
        this.add(this.initialFlowgraphSettings);
    }
}

