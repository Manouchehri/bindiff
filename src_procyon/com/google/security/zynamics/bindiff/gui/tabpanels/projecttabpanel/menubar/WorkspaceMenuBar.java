package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;

public class WorkspaceMenuBar extends JMenuBar
{
    private final JMenu workspaceMenu;
    private final JMenu diffMenu;
    private final JMenu settingsMenu;
    private final JMenu aboutMenu;
    
    public WorkspaceMenuBar(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.workspaceMenu = new WorkspaceMenu(workspaceTabPanelFunctions);
        this.diffMenu = new DiffMenu(workspaceTabPanelFunctions);
        this.settingsMenu = new SettingsMenu(workspaceTabPanelFunctions);
        this.aboutMenu = new HelpMenu(workspaceTabPanelFunctions);
        this.add(this.workspaceMenu);
        this.add(this.diffMenu);
        this.add(this.settingsMenu);
        this.add(this.aboutMenu);
    }
    
    public String[] getRecentWorkspaces() {
        return ((WorkspaceMenu)this.workspaceMenu).getRecentWorkspaces();
    }
}
