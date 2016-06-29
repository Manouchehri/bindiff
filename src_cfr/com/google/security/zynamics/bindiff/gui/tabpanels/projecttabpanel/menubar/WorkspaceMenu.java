/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public final class WorkspaceMenu
extends JMenu {
    public static final int MAX_RECENT = 4;
    private final List recentWorkspaces = new ArrayList(4);
    private final WorkspaceTabPanelFunctions controller;
    private final WorkspaceMenu$InternalWorkspaceListener workspaceModelListener;
    private JMenuItem newWorkspace;
    private JMenuItem loadWorkspace;
    private JMenuItem closeWorkspace;
    private JMenuItem exit;

    public WorkspaceMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("File");
        this.workspaceModelListener = new WorkspaceMenu$InternalWorkspaceListener(this, null);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.setMnemonic('F');
        this.loadRecentWorkspacesFromConfig();
        this.initItems();
        workspaceTabPanelFunctions.getWorkspace().addListener(this.workspaceModelListener);
        this.enableSubmenus(false);
    }

    private void addRecentWorkspaces() {
        boolean bl2 = true;
        Iterator iterator = this.recentWorkspaces.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (string.isEmpty()) continue;
            if (bl2) {
                this.add(new JSeparator());
                bl2 = false;
            }
            JMenuItem jMenuItem = GuiUtils.buildMenuItem(this.minimizeWorkspacePath(string), new WorkspaceMenu$1(this, string));
            this.add(jMenuItem);
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
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.newWorkspace = GuiUtils.buildMenuItem("New Workspace...", 'N', 78, n2 | 1, new WorkspaceMenu$2(this));
        this.loadWorkspace = GuiUtils.buildMenuItem("Open Workspace...", 'O', 79, n2, new WorkspaceMenu$3(this));
        this.closeWorkspace = GuiUtils.buildMenuItem("Close Workspace", 'W', 87, n2, new WorkspaceMenu$4(this));
        this.exit = GuiUtils.buildMenuItem("Exit", 'Q', 81, n2, new WorkspaceMenu$5(this));
        this.addSubmenuEntries();
    }

    private void loadRecentWorkspacesFromConfig() {
        GeneralSettingsConfigItem generalSettingsConfigItem = BinDiffConfigFile.getInstance().getMainSettings();
        this.recentWorkspaces.add(new File(generalSettingsConfigItem.getLastWorkspaceDirectory1()).exists() ? generalSettingsConfigItem.getLastWorkspaceDirectory1() : "");
        this.recentWorkspaces.add(new File(generalSettingsConfigItem.getLastWorkspaceDirectory2()).exists() ? generalSettingsConfigItem.getLastWorkspaceDirectory2() : "");
        this.recentWorkspaces.add(new File(generalSettingsConfigItem.getLastWorkspaceDirectory3()).exists() ? generalSettingsConfigItem.getLastWorkspaceDirectory3() : "");
        this.recentWorkspaces.add(new File(generalSettingsConfigItem.getLastWorkspaceDirectory4()).exists() ? generalSettingsConfigItem.getLastWorkspaceDirectory4() : "");
    }

    private String minimizeWorkspacePath(String string) {
        File file = new File(string);
        String string2 = file.getParent();
        String string3 = file.getPath();
        if (string2.length() <= 25) return string3;
        string3 = string2.substring(0, 3);
        string3 = String.valueOf(string3).concat("...");
        String string4 = String.valueOf(string3);
        String string5 = String.valueOf(string2.substring(string2.length() - 20));
        string3 = string5.length() != 0 ? string4.concat(string5) : new String(string4);
        String string6 = String.valueOf(string3);
        String string7 = String.valueOf(File.separator);
        string3 = string7.length() != 0 ? string6.concat(string7) : new String(string6);
        String string8 = String.valueOf(string3);
        String string9 = String.valueOf(file.getName());
        return string9.length() != 0 ? string8.concat(string9) : new String(string8);
    }

    private void updateworkspaceMenu() {
        this.removeAll();
        this.addSubmenuEntries();
    }

    public void dispose() {
        this.controller.getWorkspace().removeListener(this.workspaceModelListener);
    }

    public void enableSubmenus(boolean bl2) {
        this.closeWorkspace.setEnabled(bl2);
    }

    public String[] getRecentWorkspaces() {
        return this.recentWorkspaces.toArray(new String[0]);
    }

    static /* synthetic */ WorkspaceTabPanelFunctions access$100(WorkspaceMenu workspaceMenu) {
        return workspaceMenu.controller;
    }

    static /* synthetic */ List access$200(WorkspaceMenu workspaceMenu) {
        return workspaceMenu.recentWorkspaces;
    }

    static /* synthetic */ void access$300(WorkspaceMenu workspaceMenu) {
        workspaceMenu.updateworkspaceMenu();
    }
}

