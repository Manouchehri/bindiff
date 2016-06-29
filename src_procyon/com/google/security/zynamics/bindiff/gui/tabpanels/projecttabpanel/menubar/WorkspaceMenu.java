package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import com.google.security.zynamics.bindiff.config.*;

public final class WorkspaceMenu extends JMenu
{
    public static final int MAX_RECENT = 4;
    private final List recentWorkspaces;
    private final WorkspaceTabPanelFunctions controller;
    private final WorkspaceMenu$InternalWorkspaceListener workspaceModelListener;
    private JMenuItem newWorkspace;
    private JMenuItem loadWorkspace;
    private JMenuItem closeWorkspace;
    private JMenuItem exit;
    
    public WorkspaceMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("File");
        this.recentWorkspaces = new ArrayList(4);
        this.workspaceModelListener = new WorkspaceMenu$InternalWorkspaceListener(this, null);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.setMnemonic('F');
        this.loadRecentWorkspacesFromConfig();
        this.initItems();
        workspaceTabPanelFunctions.getWorkspace().addListener(this.workspaceModelListener);
        this.enableSubmenus(false);
    }
    
    private void addRecentWorkspaces() {
        int n = 1;
        for (final String s : this.recentWorkspaces) {
            if (s.isEmpty()) {
                continue;
            }
            if (n != 0) {
                this.add(new JSeparator());
                n = 0;
            }
            this.add(GuiUtils.buildMenuItem(this.minimizeWorkspacePath(s), new WorkspaceMenu$1(this, s)));
        }
    }
    
    private void addSubmenuEntries() {
        this.add(this.newWorkspace);
        this.add(this.loadWorkspace);
        this.add(this.closeWorkspace);
        this.addRecentWorkspaces();
        this.add(new JSeparator());
        this.add(this.exit);
    }
    
    private void initItems() {
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.newWorkspace = GuiUtils.buildMenuItem("New Workspace...", 'N', 78, menuShortcutKeyMask | 0x1, new WorkspaceMenu$2(this));
        this.loadWorkspace = GuiUtils.buildMenuItem("Open Workspace...", 'O', 79, menuShortcutKeyMask, new WorkspaceMenu$3(this));
        this.closeWorkspace = GuiUtils.buildMenuItem("Close Workspace", 'W', 87, menuShortcutKeyMask, new WorkspaceMenu$4(this));
        this.exit = GuiUtils.buildMenuItem("Exit", 'Q', 81, menuShortcutKeyMask, new WorkspaceMenu$5(this));
        this.addSubmenuEntries();
    }
    
    private void loadRecentWorkspacesFromConfig() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        this.recentWorkspaces.add(new File(mainSettings.getLastWorkspaceDirectory1()).exists() ? mainSettings.getLastWorkspaceDirectory1() : "");
        this.recentWorkspaces.add(new File(mainSettings.getLastWorkspaceDirectory2()).exists() ? mainSettings.getLastWorkspaceDirectory2() : "");
        this.recentWorkspaces.add(new File(mainSettings.getLastWorkspaceDirectory3()).exists() ? mainSettings.getLastWorkspaceDirectory3() : "");
        this.recentWorkspaces.add(new File(mainSettings.getLastWorkspaceDirectory4()).exists() ? mainSettings.getLastWorkspaceDirectory4() : "");
    }
    
    private String minimizeWorkspacePath(final String s) {
        final File file = new File(s);
        final String parent = file.getParent();
        String path = file.getPath();
        if (parent.length() > 25) {
            final String value = String.valueOf(String.valueOf(parent.substring(0, 3)).concat("..."));
            final String value2 = String.valueOf(parent.substring(parent.length() - 20));
            final String value3 = String.valueOf((value2.length() != 0) ? value.concat(value2) : new String(value));
            final String value4 = String.valueOf(File.separator);
            final String value5 = String.valueOf((value4.length() != 0) ? value3.concat(value4) : new String(value3));
            final String value6 = String.valueOf(file.getName());
            path = ((value6.length() != 0) ? value5.concat(value6) : new String(value5));
        }
        return path;
    }
    
    private void updateworkspaceMenu() {
        this.removeAll();
        this.addSubmenuEntries();
    }
    
    public void dispose() {
        this.controller.getWorkspace().removeListener(this.workspaceModelListener);
    }
    
    public void enableSubmenus(final boolean enabled) {
        this.closeWorkspace.setEnabled(enabled);
    }
    
    public String[] getRecentWorkspaces() {
        return this.recentWorkspaces.toArray(new String[0]);
    }
}
