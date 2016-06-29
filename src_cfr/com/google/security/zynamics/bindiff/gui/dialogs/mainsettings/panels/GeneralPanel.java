/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.GeneralPanel$InternalDirectoryListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.bindiff.utils.SystemUtils;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GeneralPanel
extends JPanel {
    private static int LABEL_WIDTH = 275;
    private static int ROW_HEIGHT = 25;
    private static int NUMBER_OF_ROWS = 2;
    private FileChooserPanel idaDirectoryPanel;
    private FileChooserPanel workspaceDirectoryPanel;

    public GeneralPanel() {
        super(new BorderLayout());
        this.init();
    }

    private void init() {
        this.setBorder(new LineBorder(Color.GRAY));
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        this.idaDirectoryPanel = new FileChooserPanel(generalSettingsConfigItem.getIdaDirectory(), new GeneralPanel$InternalDirectoryListener(this, this.idaDirectoryPanel, "Choose IDA Installation Directory"), "...", 0, ROW_HEIGHT, 0);
        String string = generalSettingsConfigItem.getWorkspaceDirectory();
        if ("".equals(string)) {
            string = SystemUtils.getCurrentUserPersonalFolder();
        }
        this.workspaceDirectoryPanel = new FileChooserPanel(string, new GeneralPanel$InternalDirectoryListener(this, this.workspaceDirectoryPanel, "Choose Workspace Directory"), "...", 0, ROW_HEIGHT, 0);
        JPanel jPanel = new JPanel(new GridLayout(NUMBER_OF_ROWS, 1, 5, 5));
        jPanel.setBorder(new TitledBorder("General settings"));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("IDA directory:", LABEL_WIDTH, this.idaDirectoryPanel, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Workspaces directory:", LABEL_WIDTH, this.workspaceDirectoryPanel, ROW_HEIGHT));
        this.add((Component)jPanel, "North");
    }

    public String getIDADirectory() {
        return this.idaDirectoryPanel.getText();
    }

    public String getWorkspaceDirectory() {
        return this.workspaceDirectoryPanel.getText();
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        this.idaDirectoryPanel.setText(generalSettingsConfigItem.getIdaDirectory());
        String string = generalSettingsConfigItem.getWorkspaceDirectory();
        if ("".equals(string)) {
            string = SystemUtils.getCurrentUserPersonalFolder();
        }
        this.workspaceDirectoryPanel.setText(string);
    }
}

