/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.SettingsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class WorkspaceMenuBar
extends JMenuBar {
    private final JMenu workspaceMenu;
    private final JMenu diffMenu;
    private final JMenu settingsMenu;
    private final JMenu aboutMenu;

    public WorkspaceMenuBar(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
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

