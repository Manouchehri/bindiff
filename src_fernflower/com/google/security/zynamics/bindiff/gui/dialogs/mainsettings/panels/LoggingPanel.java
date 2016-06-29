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
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class LoggingPanel extends JPanel {
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

   private static String selectLogFileDirectory(Container var0) {
      DirectoryChooser var1 = new DirectoryChooser("Select Log Directory");
      return var1.showOpenDialog(var0) == 0?var1.getSelectedFile().getAbsolutePath():null;
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
      JPanel var1 = new JPanel(new GridLayout(NUMBER_OF_ROWS_PANEL_2, 1, 5, 5));
      var1.setBorder(new TitledBorder("Detail"));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Verbose logging:", LABEL_WIDTH, this.logVerbose, ROW_HEIGHT));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Log infos:", LABEL_WIDTH, this.logInfo, ROW_HEIGHT));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Log warnings:", LABEL_WIDTH, this.logWarning, ROW_HEIGHT));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Log severe warnings:", LABEL_WIDTH, this.logSevere, ROW_HEIGHT));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Log exceptions:", LABEL_WIDTH, this.logExceptions, ROW_HEIGHT));
      var1.add(GuiUtils.createHorizontalNamedComponentPanel("Log stacktraces:", LABEL_WIDTH, this.logStacktrace, ROW_HEIGHT));
      return var1;
   }

   private JPanel createLoggingPanel() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      this.consoleLogging.addItem("On");
      this.consoleLogging.addItem("Off");
      this.fileLogging.addItem("On");
      this.fileLogging.addItem("Off");
      String var3 = var2.getLogFileLocation();
      if("".equals(var3)) {
         var3 = Logger.getDefaultLoggingDirectoryPath();
      }

      this.logFileLocationPanel = new FileChooserPanel(var3, new LoggingPanel$InternalLogFileDirectoryListener(this, (LoggingPanel$1)null), "...", 0, ROW_HEIGHT, 0);
      JPanel var4 = new JPanel(new GridLayout(NUMBER_OF_ROWS_PANEL_1, 1, 5, 5));
      var4.setBorder(new TitledBorder("Activation"));
      var4.add(GuiUtils.createHorizontalNamedComponentPanel("Console logging:", LABEL_WIDTH, this.consoleLogging, ROW_HEIGHT));
      var4.add(GuiUtils.createHorizontalNamedComponentPanel("File logging:", LABEL_WIDTH, this.fileLogging, ROW_HEIGHT));
      var4.add(GuiUtils.createHorizontalNamedComponentPanel("Log directory:", LABEL_WIDTH, this.logFileLocationPanel, ROW_HEIGHT));
      return var4;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel(new GridBagLayout());
      GridBagConstraints var3 = new GridBagConstraints();
      var3.gridx = 0;
      var3.gridy = 0;
      var3.anchor = 23;
      var3.weightx = 1.0D;
      var3.fill = 2;
      var2.add(this.createLoggingPanel(), var3);
      var3.gridy = 1;
      var2.add(this.createLoggingDetailPanel(), var3);
      var1.add(var2, "North");
      this.add(new JScrollPane(var1));
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
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      this.consoleLogging.setSelectedIndex(var2.getConsoleLogging()?0:1);
      this.fileLogging.setSelectedIndex(var2.getFileLogging()?0:1);
      this.logVerbose.setSelectedIndex(var2.getLogVerbose()?0:1);
      this.logInfo.setSelectedIndex(var2.getLogInfo()?0:1);
      this.logWarning.setSelectedIndex(var2.getLogWarning()?0:1);
      this.logSevere.setSelectedIndex(var2.getLogSevere()?0:1);
      this.logExceptions.setSelectedIndex(var2.getLogException()?0:1);
      this.logStacktrace.setSelectedIndex(var2.getLogStacktrace()?0:1);
   }

   // $FF: synthetic method
   static String access$100(Container var0) {
      return selectLogFileDirectory(var0);
   }

   // $FF: synthetic method
   static FileChooserPanel access$200(LoggingPanel var0) {
      return var0.logFileLocationPanel;
   }
}
