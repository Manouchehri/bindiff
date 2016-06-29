package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.config.*;

public class GeneralPanel extends JPanel
{
    private static int LABEL_WIDTH;
    private static int ROW_HEIGHT;
    private static int NUMBER_OF_ROWS;
    private FileChooserPanel idaDirectoryPanel;
    private FileChooserPanel workspaceDirectoryPanel;
    
    public GeneralPanel() {
        super(new BorderLayout());
        this.init();
    }
    
    private void init() {
        this.setBorder(new LineBorder(Color.GRAY));
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        this.idaDirectoryPanel = new FileChooserPanel(mainSettings.getIdaDirectory(), new GeneralPanel$InternalDirectoryListener(this, this.idaDirectoryPanel, "Choose IDA Installation Directory"), "...", 0, GeneralPanel.ROW_HEIGHT, 0);
        String s = mainSettings.getWorkspaceDirectory();
        if ("".equals(s)) {
            s = SystemUtils.getCurrentUserPersonalFolder();
        }
        this.workspaceDirectoryPanel = new FileChooserPanel(s, new GeneralPanel$InternalDirectoryListener(this, this.workspaceDirectoryPanel, "Choose Workspace Directory"), "...", 0, GeneralPanel.ROW_HEIGHT, 0);
        final JPanel panel = new JPanel(new GridLayout(GeneralPanel.NUMBER_OF_ROWS, 1, 5, 5));
        panel.setBorder(new TitledBorder("General settings"));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("IDA directory:", GeneralPanel.LABEL_WIDTH, this.idaDirectoryPanel, GeneralPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Workspaces directory:", GeneralPanel.LABEL_WIDTH, this.workspaceDirectoryPanel, GeneralPanel.ROW_HEIGHT));
        this.add(panel, "North");
    }
    
    public String getIDADirectory() {
        return this.idaDirectoryPanel.getText();
    }
    
    public String getWorkspaceDirectory() {
        return this.workspaceDirectoryPanel.getText();
    }
    
    public void setCurrentValues() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        this.idaDirectoryPanel.setText(mainSettings.getIdaDirectory());
        String text = mainSettings.getWorkspaceDirectory();
        if ("".equals(text)) {
            text = SystemUtils.getCurrentUserPersonalFolder();
        }
        this.workspaceDirectoryPanel.setText(text);
    }
    
    static {
        GeneralPanel.LABEL_WIDTH = 275;
        GeneralPanel.ROW_HEIGHT = 25;
        GeneralPanel.NUMBER_OF_ROWS = 2;
    }
}
