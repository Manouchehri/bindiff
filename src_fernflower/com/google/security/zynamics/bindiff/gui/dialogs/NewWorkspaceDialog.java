package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$InternalActionListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;

public class NewWorkspaceDialog extends BaseDialog {
   private static final int LABEL_WIDTH = 100;
   private static final int ROW_HEIGHT = 25;
   private static final int DIALOG_WIDTH = 445;
   private static final int DIALOG_HEIGHT = 190;
   private final JFormattedTextField workspaceName;
   private final FileChooserPanel workspaceDirectoryPanel;
   private final JCheckBox createDirectory = new JCheckBox("Create directory for workspace");
   private final JCheckBox defaultWorkspace = new JCheckBox("Use this as default workspace");
   private final JButton ok = new JButton("Ok");
   private final JButton cancel = new JButton("Cancel");
   private final NewWorkspaceDialog$InternalActionListener actionListener = new NewWorkspaceDialog$InternalActionListener(this, (NewWorkspaceDialog$1)null);
   private boolean okPressed;

   public NewWorkspaceDialog(Window var1, String var2) {
      super(var1, var2, 445, 190);
      CFilenameFormatter var3 = new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory()));
      this.workspaceName = new JFormattedTextField(new DefaultFormatterFactory(var3));
      this.workspaceName.setText("BinDiff Workspace");
      String var4 = BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory();
      if("".equals(var4) || var4 == null) {
         var4 = SystemHelpers.getUserDirectory();
      }

      this.workspaceDirectoryPanel = new FileChooserPanel(var4, this.actionListener, "...", 0, 25, 0);
      this.createDirectory.setSelected(true);
      this.ok.addActionListener(this.actionListener);
      this.cancel.addActionListener(this.actionListener);
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private boolean validateValues() {
      String var1 = this.getWorkspaceName();
      if(!"".equals(var1) && var1 != null) {
         File var2 = new File(this.getWorkspacePath());
         if(var2.exists()) {
            if(!var2.isDirectory()) {
               CMessageBox.showInformation(this, "The specified workspace is not a directory.");
               return false;
            } else if(var2.list().length != 0) {
               CMessageBox.showInformation(this, "The specified workspace directory is not empty.");
               return false;
            } else {
               return true;
            }
         } else {
            boolean var3 = false;

            boolean var5;
            try {
               var3 = var2.createNewFile();
               return var3;
            } catch (IOException var9) {
               CMessageBox.showError(this, String.format("Could create workspace directory. \'%s\'", new Object[]{var2.getAbsolutePath()}));
               var5 = false;
            } finally {
               if(var3) {
                  var2.delete();
               }

            }

            return var5;
         }
      } else {
         CMessageBox.showInformation(this, "A workspace need a name.");
         return false;
      }
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(3, 1, 5, 5));
      var2.setBorder(new TitledBorder(""));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Name:", 100, this.workspaceName, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Location:", 100, this.workspaceDirectoryPanel, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("", 96, this.createDirectory, 25));
      var1.add(var2, "North");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var4 = new JPanel(new GridLayout(1, 2, 5, 5));
      var4.add(this.ok);
      var4.add(this.cancel);
      var3.add(this.defaultWorkspace, "West");
      var3.add(var4, "East");
      var1.add(var3, "South");
      this.add(var1, "Center");
   }

   public String getWorkspaceName() {
      return this.workspaceName.getText();
   }

   public String getWorkspacePath() {
      // $FF: Couldn't be decompiled
   }

   public boolean isDefaultWorkspace() {
      return this.defaultWorkspace.isSelected();
   }

   public boolean isOkPressed() {
      return this.okPressed;
   }

   // $FF: synthetic method
   static FileChooserPanel access$100(NewWorkspaceDialog var0) {
      return var0.workspaceDirectoryPanel;
   }

   // $FF: synthetic method
   static JButton access$200(NewWorkspaceDialog var0) {
      return var0.ok;
   }

   // $FF: synthetic method
   static boolean access$300(NewWorkspaceDialog var0) {
      return var0.validateValues();
   }

   // $FF: synthetic method
   static boolean access$402(NewWorkspaceDialog var0, boolean var1) {
      return var0.okPressed = var1;
   }
}
