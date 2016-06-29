package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.GeneralPanel$InternalDirectoryListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.bindiff.utils.SystemUtils;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GeneralPanel extends JPanel {
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
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      this.idaDirectoryPanel = new FileChooserPanel(var2.getIdaDirectory(), new GeneralPanel$InternalDirectoryListener(this, this.idaDirectoryPanel, "Choose IDA Installation Directory"), "...", 0, ROW_HEIGHT, 0);
      String var3 = var2.getWorkspaceDirectory();
      if("".equals(var3)) {
         var3 = SystemUtils.getCurrentUserPersonalFolder();
      }

      this.workspaceDirectoryPanel = new FileChooserPanel(var3, new GeneralPanel$InternalDirectoryListener(this, this.workspaceDirectoryPanel, "Choose Workspace Directory"), "...", 0, ROW_HEIGHT, 0);
      JPanel var4 = new JPanel(new GridLayout(NUMBER_OF_ROWS, 1, 5, 5));
      var4.setBorder(new TitledBorder("General settings"));
      var4.add(GuiUtils.createHorizontalNamedComponentPanel("IDA directory:", LABEL_WIDTH, this.idaDirectoryPanel, ROW_HEIGHT));
      var4.add(GuiUtils.createHorizontalNamedComponentPanel("Workspaces directory:", LABEL_WIDTH, this.workspaceDirectoryPanel, ROW_HEIGHT));
      this.add(var4, "North");
   }

   public String getIDADirectory() {
      return this.idaDirectoryPanel.getText();
   }

   public String getWorkspaceDirectory() {
      return this.workspaceDirectoryPanel.getText();
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      this.idaDirectoryPanel.setText(var2.getIdaDirectory());
      String var3 = var2.getWorkspaceDirectory();
      if("".equals(var3)) {
         var3 = SystemUtils.getCurrentUserPersonalFolder();
      }

      this.workspaceDirectoryPanel.setText(var3);
   }
}
