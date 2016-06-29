/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenuBar;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

public class CWindowFunctions {
    private final TabPanelManager tabPanelManager;
    private final MainWindow window;

    public CWindowFunctions(MainWindow mainWindow, Workspace workspace) {
        Preconditions.checkNotNull(mainWindow);
        Preconditions.checkNotNull(workspace);
        this.tabPanelManager = new TabPanelManager(mainWindow, workspace);
        WorkspaceTabPanel workspaceTabPanel = new WorkspaceTabPanel(mainWindow, workspace);
        this.tabPanelManager.addTab(workspaceTabPanel);
        this.window = mainWindow;
    }

    private void saveConfigFile() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        Point point = this.window.getLocation();
        generalSettingsConfigItem.setWindowXPos((int)point.getX());
        generalSettingsConfigItem.setWindowYPos((int)point.getY());
        generalSettingsConfigItem.setWindowWidth(this.window.getWidth());
        generalSettingsConfigItem.setWindowHeight(this.window.getHeight());
        generalSettingsConfigItem.setWindowStateWasMaximized(this.window.getExtendedState() == 6);
        generalSettingsConfigItem.setWorkspaceTreeDividerPosition(this.tabPanelManager.getWorkspaceTabPanel().getDividerLocation());
        generalSettingsConfigItem.setScreenWidth(Toolkit.getDefaultToolkit().getScreenSize().width);
        generalSettingsConfigItem.setScreenHeight(Toolkit.getDefaultToolkit().getScreenSize().height);
        WorkspaceMenuBar workspaceMenuBar = (WorkspaceMenuBar)this.tabPanelManager.getWorkspaceTabPanel().getMenuBar();
        String[] arrstring = workspaceMenuBar.getRecentWorkspaces();
        generalSettingsConfigItem.setLastWorkspaceDirectory1(new File(arrstring[0]).exists() ? arrstring[0] : "");
        generalSettingsConfigItem.setLastWorkspaceDirectory2(new File(arrstring[1]).exists() ? arrstring[1] : "");
        generalSettingsConfigItem.setLastWorkspaceDirectory3(new File(arrstring[2]).exists() ? arrstring[2] : "");
        generalSettingsConfigItem.setLastWorkspaceDirectory4(new File(arrstring[3]).exists() ? arrstring[3] : "");
        try {
            BinDiffConfigFile.getInstance().write();
            return;
        }
        catch (IOException var6_6) {
            Logger.logException(var6_6, "Couldn't save configuration file.");
            CMessageBox.showError(this.window, "Couldn't save configuration file.");
        }
    }

    public void exitBinDiff() {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = this.tabPanelManager.getWorkspaceTabPanel().getController();
        if (this.tabPanelManager.getWorkspaceTabPanel().getController().closeWorkspace()) {
            workspaceTabPanelFunctions.closeDialogs();
            this.saveConfigFile();
            Logger.logInfo("BinDiff closed normally.", new Object[0]);
        }
        System.exit(0);
    }

    public JTabbedPane getTabbedPanel() {
        return this.tabPanelManager.getTabbedPane();
    }

    public TabPanelManager getTabPanelManager() {
        return this.tabPanelManager;
    }
}

