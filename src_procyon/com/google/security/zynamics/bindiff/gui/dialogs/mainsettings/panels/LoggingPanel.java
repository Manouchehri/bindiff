package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.security.zynamics.zylib.io.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.log.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import java.awt.*;
import javax.swing.*;

public class LoggingPanel extends JPanel
{
    private static int LABEL_WIDTH;
    private static int ROW_HEIGHT;
    private static int NUMBER_OF_ROWS_PANEL_1;
    private static int NUMBER_OF_ROWS_PANEL_2;
    private final JComboBox consoleLogging;
    private final JComboBox fileLogging;
    private final JComboBox logVerbose;
    private final JComboBox logInfo;
    private final JComboBox logWarning;
    private final JComboBox logSevere;
    private final JComboBox logExceptions;
    private final JComboBox logStacktrace;
    private FileChooserPanel logFileLocationPanel;
    
    public LoggingPanel() {
        super(new BorderLayout());
        this.consoleLogging = new JComboBox();
        this.fileLogging = new JComboBox();
        this.logVerbose = new JComboBox();
        this.logInfo = new JComboBox();
        this.logWarning = new JComboBox();
        this.logSevere = new JComboBox();
        this.logExceptions = new JComboBox();
        this.logStacktrace = new JComboBox();
        this.init();
    }
    
    private static String selectLogFileDirectory(final Container container) {
        final DirectoryChooser directoryChooser = new DirectoryChooser("Select Log Directory");
        if (directoryChooser.showOpenDialog(container) == 0) {
            return directoryChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
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
        final JPanel panel = new JPanel(new GridLayout(LoggingPanel.NUMBER_OF_ROWS_PANEL_2, 1, 5, 5));
        panel.setBorder(new TitledBorder("Detail"));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Verbose logging:", LoggingPanel.LABEL_WIDTH, this.logVerbose, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log infos:", LoggingPanel.LABEL_WIDTH, this.logInfo, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log warnings:", LoggingPanel.LABEL_WIDTH, this.logWarning, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log severe warnings:", LoggingPanel.LABEL_WIDTH, this.logSevere, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log exceptions:", LoggingPanel.LABEL_WIDTH, this.logExceptions, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log stacktraces:", LoggingPanel.LABEL_WIDTH, this.logStacktrace, LoggingPanel.ROW_HEIGHT));
        return panel;
    }
    
    private JPanel createLoggingPanel() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        this.consoleLogging.addItem("On");
        this.consoleLogging.addItem("Off");
        this.fileLogging.addItem("On");
        this.fileLogging.addItem("Off");
        String s = mainSettings.getLogFileLocation();
        if ("".equals(s)) {
            s = Logger.getDefaultLoggingDirectoryPath();
        }
        this.logFileLocationPanel = new FileChooserPanel(s, new LoggingPanel$InternalLogFileDirectoryListener(this, null), "...", 0, LoggingPanel.ROW_HEIGHT, 0);
        final JPanel panel = new JPanel(new GridLayout(LoggingPanel.NUMBER_OF_ROWS_PANEL_1, 1, 5, 5));
        panel.setBorder(new TitledBorder("Activation"));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Console logging:", LoggingPanel.LABEL_WIDTH, this.consoleLogging, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("File logging:", LoggingPanel.LABEL_WIDTH, this.fileLogging, LoggingPanel.ROW_HEIGHT));
        panel.add(GuiUtils.createHorizontalNamedComponentPanel("Log directory:", LoggingPanel.LABEL_WIDTH, this.logFileLocationPanel, LoggingPanel.ROW_HEIGHT));
        return panel;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 23;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = 2;
        panel2.add(this.createLoggingPanel(), gridBagConstraints);
        gridBagConstraints.gridy = 1;
        panel2.add(this.createLoggingDetailPanel(), gridBagConstraints);
        panel.add(panel2, "North");
        this.add(new JScrollPane(panel));
        this.setCurrentValues();
    }
    
    public boolean getConsoleLogging() {
        return this.consoleLogging.getSelectedIndex() == 0;
    }
    
    public boolean getFileLogging() {
        return this.fileLogging.getSelectedIndex() == 0;
    }
    
    public boolean getLogException() {
        return this.logExceptions.getSelectedIndex() == 0;
    }
    
    public String getLogFileLocation() {
        return this.logFileLocationPanel.getText();
    }
    
    public boolean getLogInfo() {
        return this.logInfo.getSelectedIndex() == 0;
    }
    
    public boolean getLogSevere() {
        return this.logSevere.getSelectedIndex() == 0;
    }
    
    public boolean getLogStacktrace() {
        return this.logStacktrace.getSelectedIndex() == 0;
    }
    
    public boolean getLogVerbose() {
        return this.logVerbose.getSelectedIndex() == 0;
    }
    
    public boolean getLogWarning() {
        return this.logWarning.getSelectedIndex() == 0;
    }
    
    public void setCurrentValues() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        this.consoleLogging.setSelectedIndex(mainSettings.getConsoleLogging() ? 0 : 1);
        this.fileLogging.setSelectedIndex(mainSettings.getFileLogging() ? 0 : 1);
        this.logVerbose.setSelectedIndex(mainSettings.getLogVerbose() ? 0 : 1);
        this.logInfo.setSelectedIndex(mainSettings.getLogInfo() ? 0 : 1);
        this.logWarning.setSelectedIndex(mainSettings.getLogWarning() ? 0 : 1);
        this.logSevere.setSelectedIndex(mainSettings.getLogSevere() ? 0 : 1);
        this.logExceptions.setSelectedIndex(mainSettings.getLogException() ? 0 : 1);
        this.logStacktrace.setSelectedIndex(mainSettings.getLogStacktrace() ? 0 : 1);
    }
    
    static {
        LoggingPanel.LABEL_WIDTH = 275;
        LoggingPanel.ROW_HEIGHT = 25;
        LoggingPanel.NUMBER_OF_ROWS_PANEL_1 = 3;
        LoggingPanel.NUMBER_OF_ROWS_PANEL_2 = 6;
    }
}
