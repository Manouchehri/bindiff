package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$InternalDirectoryChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTable;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTableModel;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DirectoryDiffDialog extends BaseDialog {
   private static int DLG_WIDTH = 800;
   private static int DLG_HEIGHT = 400;
   private static int MAX_LISTED_FILES = 16;
   private final DirectoryDiffDialog$InternalDirectoryChooserListener dirChooserListener = new DirectoryDiffDialog$InternalDirectoryChooserListener(this, (DirectoryDiffDialog$1)null);
   private final DirectoryDiffDialog$InternalButtonListener buttonListener = new DirectoryDiffDialog$InternalButtonListener(this, (DirectoryDiffDialog$1)null);
   private final FileChooserPanel primaryDirChooser;
   private final FileChooserPanel secondaryDirChooser;
   private final JButton selectAllButton;
   private final JButton deselectAllButton;
   private final JButton diffButton;
   private final JButton cancelButton;
   private final IdbPairTable diffsTable;
   private final String workspacePath;
   private boolean diffButtonPressed;

   public DirectoryDiffDialog(Window var1, File var2) {
      super(var1, "Directory Diff");
      this.primaryDirChooser = new FileChooserPanel("", this.dirChooserListener);
      this.secondaryDirChooser = new FileChooserPanel("", this.dirChooserListener);
      this.selectAllButton = new JButton(this.buttonListener);
      this.deselectAllButton = new JButton(this.buttonListener);
      this.diffButton = new JButton(this.buttonListener);
      this.cancelButton = new JButton(this.buttonListener);
      this.diffButtonPressed = true;
      Preconditions.checkNotNull(var2);
      Preconditions.checkArgument(var2.exists(), "Workspace directory doesn\'t exist");
      this.workspacePath = var2.getPath();
      this.diffsTable = new IdbPairTable(var2, new IdbPairTableModel());
      this.init();
      this.pack();
      this.setPreferredSize(new Dimension(DLG_WIDTH, DLG_HEIGHT));
      this.setSize(new Dimension(DLG_WIDTH, DLG_HEIGHT));
      GuiHelper.centerChildToParent(var1, this, true);
      this.setVisible(true);
   }

   private File chooseFile(Component var1, ESide var2) {
      CFileChooser var3 = new CFileChooser();
      String var4;
      File var5;
      if(var2 == ESide.PRIMARY) {
         var4 = "Choose Primary Directory";
         var5 = (new File(this.secondaryDirChooser.getText())).getParentFile();
         if(var5 != null) {
            BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastPrimaryDir(var5.getPath());
         }
      } else {
         if(var2 != ESide.SECONDARY) {
            assert false;

            throw new RuntimeException();
         }

         var4 = "Choose Secondary Directory";
         var5 = (new File(this.primaryDirChooser.getText())).getParentFile();
         if(var5 != null) {
            BinDiffConfigFile.getInstance().getMainSettings().setDirectoryDiffLastSecondaryDir(var5.getPath());
         }
      }

      var3.setCurrentDirectory(var5);
      var3.setFileSelectionMode(1);
      var3.setApproveButtonText("Ok");
      var3.setDialogTitle(var4);
      boolean var6 = false;

      while(!var6) {
         if(0 == var3.showOpenDialog(var1)) {
            File var7 = var3.getSelectedFile();
            if(!var7.exists()) {
               CMessageBox.showInformation(var1, "The selected file does not exist.");
            } else if(!var7.isDirectory()) {
               CMessageBox.showInformation(var1, "The selected file must be a directory.");
            } else {
               if(!var7.getPath().equals(ESide.PRIMARY == var2?this.secondaryDirChooser.getText():this.primaryDirChooser.getText())) {
                  return var7;
               }

               CMessageBox.showInformation(var1, "Primary and secondary directory cannot be identical.");
            }
         } else {
            var6 = true;
         }
      }

      return null;
   }

   private Component createButtonsPanel() {
      this.selectAllButton.setText("Select All");
      this.deselectAllButton.setText("Deselect All");
      this.diffButton.setText("Diff");
      this.cancelButton.setText("Cancel");
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(1, 2, 5, 5));
      var2.add(this.selectAllButton);
      var2.add(this.deselectAllButton);
      JPanel var3 = new JPanel(new GridLayout(1, 2, 5, 5));
      var3.add(this.diffButton);
      var3.add(this.cancelButton);
      var1.add(var2, "West");
      var1.add(var3, "East");
      return var1;
   }

   private Component createFileChooserPanel() {
      JPanel var1 = new JPanel(new GridLayout(1, 2, 5, 5));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new TitledBorder("Primary Directory"));
      var2.add(this.primaryDirChooser, "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new TitledBorder("Secondary Directory"));
      var3.add(this.secondaryDirChooser, "Center");
      var1.add(var2);
      var1.add(var3);
      return var1;
   }

   private Component createTablePanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Found IDB Pairs"));
      JScrollPane var2 = new JScrollPane(this.diffsTable);
      var1.add(var2, "Center");
      return var1;
   }

   private String cutErrorMessage(String var1) {
      String var2 = "";
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      while(var3 != -1) {
         var3 = var1.indexOf("\n", var4);
         if(var4 != -1) {
            ++var5;
            var4 = var3 + 1;
            if(var5 >= MAX_LISTED_FILES) {
               var2 = var1.substring(0, var4);
               var2 = String.valueOf(var2).concat("...");
               return var2;
            }
         }
      }

      return var1;
   }

   private void selectAll(boolean var1) {
      IdbPairTableModel var2 = this.diffsTable.getTableModel();
      List var3 = var2.getTableData();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         DiffPairTableData var5 = (DiffPairTableData)var4.next();
         var5.getSelectionCheckBox().setSelected(var1);
      }

      var2.fireTableDataChanged();
   }

   private boolean validateSelectedDiffs() {
      // $FF: Couldn't be decompiled
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      var1.add(this.createFileChooserPanel(), "North");
      var1.add(this.createTablePanel(), "Center");
      var1.add(this.createButtonsPanel(), "South");
      this.add(var1, "Center");
   }

   public boolean getDiffButtonPressed() {
      return this.diffButtonPressed;
   }

   public List getSelectedIdbPairs() {
      ArrayList var1 = new ArrayList();
      IdbPairTableModel var2 = this.diffsTable.getTableModel();
      Iterator var3 = var2.getTableData().iterator();

      while(var3.hasNext()) {
         DiffPairTableData var4 = (DiffPairTableData)var3.next();
         if(var4.getSelectionCheckBox().isSelected()) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public String getSourceBasePath(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryDirChooser.getText():this.secondaryDirChooser.getText();
   }

   // $FF: synthetic method
   static JButton access$200(DirectoryDiffDialog var0) {
      return var0.selectAllButton;
   }

   // $FF: synthetic method
   static void access$300(DirectoryDiffDialog var0, boolean var1) {
      var0.selectAll(var1);
   }

   // $FF: synthetic method
   static JButton access$400(DirectoryDiffDialog var0) {
      return var0.deselectAllButton;
   }

   // $FF: synthetic method
   static JButton access$500(DirectoryDiffDialog var0) {
      return var0.diffButton;
   }

   // $FF: synthetic method
   static IdbPairTable access$600(DirectoryDiffDialog var0) {
      return var0.diffsTable;
   }

   // $FF: synthetic method
   static boolean access$700(DirectoryDiffDialog var0) {
      return var0.validateSelectedDiffs();
   }

   // $FF: synthetic method
   static boolean access$802(DirectoryDiffDialog var0, boolean var1) {
      return var0.diffButtonPressed = var1;
   }

   // $FF: synthetic method
   static FileChooserPanel access$900(DirectoryDiffDialog var0) {
      return var0.primaryDirChooser;
   }

   // $FF: synthetic method
   static FileChooserPanel access$1000(DirectoryDiffDialog var0) {
      return var0.secondaryDirChooser;
   }

   // $FF: synthetic method
   static File access$1100(DirectoryDiffDialog var0, Component var1, ESide var2) {
      return var0.chooseFile(var1, var2);
   }
}
