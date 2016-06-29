package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

public class SettingsMenu extends JMenu
{
    private final JMenuItem mainSettings;
    private final JMenuItem initialCallgraphSettings;
    private final JMenuItem initialFlowgraphSettings;
    
    public SettingsMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("Settings");
        this.setMnemonic('S');
        this.mainSettings = GuiUtils.buildMenuItem("Main Settings...", 77, 113, new MainSettingsAction(workspaceTabPanelFunctions));
        this.initialCallgraphSettings = GuiUtils.buildMenuItem("Initial Call Graph Settings...", 'C', 113, 64, new InitialCallGraphSettingsAction(workspaceTabPanelFunctions));
        this.initialFlowgraphSettings = GuiUtils.buildMenuItem("Initial Flow Graph Settings...", 'F', 113, 128, new InitialFlowGraphSettingsAction(workspaceTabPanelFunctions));
        this.add(this.mainSettings);
        this.add(new JSeparator());
        this.add(this.initialCallgraphSettings);
        this.add(this.initialFlowgraphSettings);
    }
}
