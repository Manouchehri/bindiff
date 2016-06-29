package com.google.security.zynamics.bindiff.gui.window;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;

public class MainWindow extends JFrame
{
    private final CWindowFunctions controller;
    private final MainWindow$InternalWorkspaceListener workspaceListener;
    private final MainWindow$InternalWindowListener windowListener;
    private String titlePath;
    
    public MainWindow(final Workspace workspace) {
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
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        final int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        final int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        mainSettings.setScreenWidth(width);
        mainSettings.setScreenHeight(height);
        return mainSettings.getScreenWidth() != width || mainSettings.getScreenHeight() != height;
    }
    
    private void initWindow() {
        this.setDefaultCloseOperation(0);
        GuiUtils.setWindowIcons(this, "data/appicons/bindiff-16x16-rgba.png", "data/appicons/bindiff-32x32-rgba.png", "data/appicons/bindiff-48x48-rgba.png");
        if (!BinDiffConfigFile.getInstance().getMainSettings().getWindowStateWasMaximized() && !this.hasChangedScreenResolution()) {
            final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
            final int windowXPos = mainSettings.getWindowXPos();
            final int windowYPos = mainSettings.getWindowYPos();
            final int windowWidth = mainSettings.getWindowWidth();
            final int windowHeight = mainSettings.getWindowHeight();
            this.setLocation(windowXPos, windowYPos);
            this.setSize(windowWidth, windowHeight);
            this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        }
        else {
            this.setLocation(100, 100);
            this.setSize(800, 600);
            this.setPreferredSize(new Dimension(800, 600));
            this.setExtendedState(6);
        }
        this.add(this.controller.getTabbedPanel(), "Center");
        this.pack();
    }
    
    private void updateEllipsis() {
        if (this.titlePath == null || this.getGraphics() == null) {
            return;
        }
        final FontMetrics fontMetrics = this.getGraphics().getFontMetrics();
        int length = this.titlePath.length();
        final Insets insets = this.getInsets();
        int n;
        String title;
        for (n = insets.right - insets.left + 100 + fontMetrics.stringWidth(" - BinDiff"), title = this.titlePath; length >= 12 && fontMetrics.stringWidth(title) > this.getWidth() - n; title = FileUtils.getPathEllipsis(this.titlePath, length), --length) {}
        this.setTitle(title);
    }
    
    public CWindowFunctions getController() {
        return this.controller;
    }
    
    @Override
    public void setTitle(final String s) {
        final String value = String.valueOf(s.isEmpty() ? "" : String.valueOf(s).concat(" - "));
        final String value2 = String.valueOf("BinDiff");
        super.setTitle((value2.length() != 0) ? value.concat(value2) : new String(value));
    }
    
    public void updateTitle(final Workspace workspace, final TabPanel tabPanel) {
        this.titlePath = null;
        if (tabPanel instanceof WorkspaceTabPanel) {
            if (workspace == null || !workspace.isLoaded()) {
                this.setTitle("");
            }
            else {
                this.setTitle(workspace.getWorkspaceFilePath());
                this.titlePath = workspace.getWorkspaceFilePath();
                this.updateEllipsis();
            }
        }
        else if (tabPanel instanceof FunctionDiffViewTabPanel) {
            this.setTitle(((FunctionDiffViewTabPanel)tabPanel).getTitle());
        }
        else if (tabPanel instanceof ViewTabPanel) {
            this.setTitle(String.format("%s - %s", ((ViewTabPanel)tabPanel).getTitle(), ((ViewTabPanel)tabPanel).getView().getGraphs().getDiff().getDiffName()));
        }
    }
}
