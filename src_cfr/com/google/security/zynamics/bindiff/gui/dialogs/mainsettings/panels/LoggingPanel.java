/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel$InternalLogFileDirectoryListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LoggingPanel
extends JPanel {
    private static int LABEL_WIDTH = 275;
    private static int ROW_HEIGHT = 25;
    private static int NUMBER_OF_ROWS_PANEL_1 = 3;
    private static int NUMBER_OF_ROWS_PANEL_2 = 6;
    private final JComboBox consoleLogging = new JComboBox();
    private final JComboBox fileLogging = new JComboBox();
    private final JComboBox logVerbose = new JComboBox();
    private final JComboBox logInfo = new JComboBox();
    private final JComboBox logWarning = new JComboBox();
    private final JComboBox logSevere = new JComboBox();
    private final JComboBox logExceptions = new JComboBox();
    private final JComboBox logStacktrace = new JComboBox();
    private FileChooserPanel logFileLocationPanel;

    public LoggingPanel() {
        super(new BorderLayout());
        this.init();
    }

    private static String selectLogFileDirectory(Container container) {
        DirectoryChooser directoryChooser = new DirectoryChooser("Select Log Directory");
        if (directoryChooser.showOpenDialog(container) != 0) return null;
        return directoryChooser.getSelectedFile().getAbsolutePath();
    }

    private JPanel createLoggingDetailPanel() {
        this.logVerbose.addItem("On");
        this.logVerbose.addItem("Off");
        this.logInfo.addItem("On");
        this.logInfo.addItem("Off");
        this.logWarning.addItem("On");
        this.logWarning.addItem("Off");
        this.logSevere.addItem("On");
        this.logSevere.addItem("Off");
        this.logExceptions.addItem("On");
        this.logExceptions.addItem("Off");
        this.logStacktrace.addItem("On");
        this.logStacktrace.addItem("Off");
        JPanel jPanel = new JPanel(new GridLayout(NUMBER_OF_ROWS_PANEL_2, 1, 5, 5));
        jPanel.setBorder(new TitledBorder("Detail"));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Verbose logging:", LABEL_WIDTH, this.logVerbose, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log infos:", LABEL_WIDTH, this.logInfo, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log warnings:", LABEL_WIDTH, this.logWarning, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log severe warnings:", LABEL_WIDTH, this.logSevere, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log exceptions:", LABEL_WIDTH, this.logExceptions, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log stacktraces:", LABEL_WIDTH, this.logStacktrace, ROW_HEIGHT));
        return jPanel;
    }

    private JPanel createLoggingPanel() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        this.consoleLogging.addItem("On");
        this.consoleLogging.addItem("Off");
        this.fileLogging.addItem("On");
        this.fileLogging.addItem("Off");
        String string = generalSettingsConfigItem.getLogFileLocation();
        if ("".equals(string)) {
            string = Logger.getDefaultLoggingDirectoryPath();
        }
        this.logFileLocationPanel = new FileChooserPanel(string, new LoggingPanel$InternalLogFileDirectoryListener(this, null), "...", 0, ROW_HEIGHT, 0);
        JPanel jPanel = new JPanel(new GridLayout(NUMBER_OF_ROWS_PANEL_1, 1, 5, 5));
        jPanel.setBorder(new TitledBorder("Activation"));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Console logging:", LABEL_WIDTH, this.consoleLogging, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("File logging:", LABEL_WIDTH, this.fileLogging, ROW_HEIGHT));
        jPanel.add(GuiUtils.createHorizontalNamedComponentPanel("Log directory:", LABEL_WIDTH, this.logFileLocationPanel, ROW_HEIGHT));
        return jPanel;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 23;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = 2;
        jPanel2.add((Component)this.createLoggingPanel(), gridBagConstraints);
        gridBagConstraints.gridy = 1;
        jPanel2.add((Component)this.createLoggingDetailPanel(), gridBagConstraints);
        jPanel.add((Component)jPanel2, "North");
        this.add(new JScrollPane(jPanel));
        this.setCurrentValues();
    }

    public boolean getConsoleLogging() {
        if (this.consoleLogging.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getFileLogging() {
        if (this.fileLogging.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLogException() {
        if (this.logExceptions.getSelectedIndex() != 0) return false;
        return true;
    }

    public String getLogFileLocation() {
        return this.logFileLocationPanel.getText();
    }

    public boolean getLogInfo() {
        if (this.logInfo.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLogSevere() {
        if (this.logSevere.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLogStacktrace() {
        if (this.logStacktrace.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLogVerbose() {
        if (this.logVerbose.getSelectedIndex() != 0) return false;
        return true;
    }

    public boolean getLogWarning() {
        if (this.logWarning.getSelectedIndex() != 0) return false;
        return true;
    }

    public void setCurrentValues() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        this.consoleLogging.setSelectedIndex(generalSettingsConfigItem.getConsoleLogging() ? 0 : 1);
        this.fileLogging.setSelectedIndex(generalSettingsConfigItem.getFileLogging() ? 0 : 1);
        this.logVerbose.setSelectedIndex(generalSettingsConfigItem.getLogVerbose() ? 0 : 1);
        this.logInfo.setSelectedIndex(generalSettingsConfigItem.getLogInfo() ? 0 : 1);
        this.logWarning.setSelectedIndex(generalSettingsConfigItem.getLogWarning() ? 0 : 1);
        this.logSevere.setSelectedIndex(generalSettingsConfigItem.getLogSevere() ? 0 : 1);
        this.logExceptions.setSelectedIndex(generalSettingsConfigItem.getLogException() ? 0 : 1);
        this.logStacktrace.setSelectedIndex(generalSettingsConfigItem.getLogStacktrace() ? 0 : 1);
    }

    static /* synthetic */ String access$100(Container container) {
        return LoggingPanel.selectLogFileDirectory(container);
    }

    static /* synthetic */ FileChooserPanel access$200(LoggingPanel loggingPanel) {
        return loggingPanel.logFileLocationPanel;
    }
}

