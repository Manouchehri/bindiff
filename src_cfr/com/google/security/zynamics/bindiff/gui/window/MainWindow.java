/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainWindow
extends JFrame {
    private final CWindowFunctions controller;
    private final MainWindow$InternalWorkspaceListener workspaceListener;
    private final MainWindow$InternalWindowListener windowListener;
    private String titlePath;

    public MainWindow(Workspace workspace) {
        this.workspaceListener = new MainWindow$InternalWorkspaceListener(this, null);
        this.windowListener = new MainWindow$InternalWindowListener(this, null);
        Preconditions.checkNotNull(workspace);
        workspace.addListener(this.workspaceListener);
        this.controller = new CWindowFunctions(this, workspace);
        this.initWindow();
        this.addWindowListener(this.windowListener);
        this.addComponentListener(new MainWindow$1(this));
    }

    private boolean hasChangedScreenResolution() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        int n2 = Toolkit.getDefaultToolkit().getScreenSize().width;
        int n3 = Toolkit.getDefaultToolkit().getScreenSize().height;
        generalSettingsConfigItem.setScreenWidth(n2);
        generalSettingsConfigItem.setScreenHeight(n3);
        if (generalSettingsConfigItem.getScreenWidth() != n2) return true;
        if (generalSettingsConfigItem.getScreenHeight() != n3) return true;
        return false;
    }

    private void initWindow() {
        this.setDefaultCloseOperation(0);
        GuiUtils.setWindowIcons(this, "data/appicons/bindiff-16x16-rgba.png", "data/appicons/bindiff-32x32-rgba.png", "data/appicons/bindiff-48x48-rgba.png");
        boolean bl2 = BinDiffConfigFile.getInstance().getMainSettings().getWindowStateWasMaximized();
        if (!bl2 && !this.hasChangedScreenResolution()) {
            GeneralSettingsConfigItem generalSettingsConfigItem = BinDiffConfigFile.getInstance().getMainSettings();
            int n2 = generalSettingsConfigItem.getWindowXPos();
            int n3 = generalSettingsConfigItem.getWindowYPos();
            int n4 = generalSettingsConfigItem.getWindowWidth();
            int n5 = generalSettingsConfigItem.getWindowHeight();
            this.setLocation(n2, n3);
            this.setSize(n4, n5);
            this.setPreferredSize(new Dimension(n4, n5));
        } else {
            this.setLocation(100, 100);
            this.setSize(800, 600);
            this.setPreferredSize(new Dimension(800, 600));
            this.setExtendedState(6);
        }
        this.add((Component)this.controller.getTabbedPanel(), "Center");
        this.pack();
    }

    private void updateEllipsis() {
        if (this.titlePath == null) return;
        if (this.getGraphics() == null) {
            return;
        }
        FontMetrics fontMetrics = this.getGraphics().getFontMetrics();
        Insets insets = this.getInsets();
        int n2 = insets.right - insets.left + 100 + fontMetrics.stringWidth(" - BinDiff");
        String string = this.titlePath;
        for (int i2 = this.titlePath.length(); i2 >= 12 && fontMetrics.stringWidth(string) > this.getWidth() - n2; --i2) {
            string = FileUtils.getPathEllipsis(this.titlePath, i2);
        }
        this.setTitle(string);
    }

    public CWindowFunctions getController() {
        return this.controller;
    }

    @Override
    public void setTitle(String string) {
        String string2 = String.valueOf(!string.isEmpty() ? String.valueOf(string).concat(" - ") : "");
        String string3 = String.valueOf("BinDiff");
        super.setTitle(string3.length() != 0 ? string2.concat(string3) : new String(string2));
    }

    public void updateTitle(Workspace workspace, TabPanel tabPanel) {
        this.titlePath = null;
        if (tabPanel instanceof WorkspaceTabPanel) {
            if (workspace != null && workspace.isLoaded()) {
                this.setTitle(workspace.getWorkspaceFilePath());
                this.titlePath = workspace.getWorkspaceFilePath();
                this.updateEllipsis();
                return;
            }
            this.setTitle("");
            return;
        }
        if (tabPanel instanceof FunctionDiffViewTabPanel) {
            String string = ((FunctionDiffViewTabPanel)tabPanel).getTitle();
            this.setTitle(string);
            return;
        }
        if (!(tabPanel instanceof ViewTabPanel)) return;
        String string = String.format("%s - %s", ((ViewTabPanel)tabPanel).getTitle(), ((ViewTabPanel)tabPanel).getView().getGraphs().getDiff().getDiffName());
        this.setTitle(string);
    }

    static /* synthetic */ void access$200(MainWindow mainWindow) {
        mainWindow.updateEllipsis();
    }

    static /* synthetic */ MainWindow$InternalWindowListener access$300(MainWindow mainWindow) {
        return mainWindow.windowListener;
    }

    static /* synthetic */ CWindowFunctions access$400(MainWindow mainWindow) {
        return mainWindow.controller;
    }

    static /* synthetic */ String access$502(MainWindow mainWindow, String string) {
        mainWindow.titlePath = string;
        return mainWindow.titlePath;
    }
}

