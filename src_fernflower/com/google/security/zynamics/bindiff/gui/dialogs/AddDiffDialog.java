package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$InternalDiffChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CFileChooser$FileExtension;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddDiffDialog extends BaseDialog {
   private static int TEXTFIELD_WIDTH = 500;
   private static int LABEL_WIDTH = 180;
   private static int ROW_HEIGHT = 25;
   private final Workspace workspace;
   private final AddDiffDialog$InternalDiffChooserListener diffChooserListener = new AddDiffDialog$InternalDiffChooserListener(this, (AddDiffDialog$1)null);
   private final AddDiffDialog$InternalButtonListener buttonListener = new AddDiffDialog$InternalButtonListener(this, (AddDiffDialog$1)null);
   private final JButton addButton;
   private final JButton cancelButton;
   private final FileChooserPanel diffChooser;
   private final JTextField primaryExportBinary;
   private final JTextField secondaryExportBinary;
   private final JTextField destinationDirName;
   private boolean diffPressed;

   public AddDiffDialog(Window var1, Workspace var2) {
      super(var1, "Add Existing Diff");
      this.addButton = new JButton(this.buttonListener);
      this.cancelButton = new JButton(this.buttonListener);
      this.diffChooser = new FileChooserPanel("", this.diffChooserListener, "...", TEXTFIELD_WIDTH, ROW_HEIGHT, 0);
      this.primaryExportBinary = new JTextField();
      this.secondaryExportBinary = new JTextField();
      this.destinationDirName = new JTextField();
      this.diffPressed = false;
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
      this.setVisible(true);
   }

   private static File chooseFile(Component var0, String var1, File var2) {
      CFileChooser var3 = new CFileChooser(new CFileChooser$FileExtension[]{new CFileChooser$FileExtension(String.format("BinDiff Matches Database (*.%s)", new Object[]{"BinDiff"}), new String[]{"BinDiff"})});
      var3.setCurrentDirectory(var2);
      var3.setApproveButtonText("Ok");
      var3.setDialogTitle(var1);
      return var3.showOpenDialog(var0) == 0?var3.getSelectedFile():null;
   }

   private JPanel createButtonPanel() {
      this.addButton.setText("Add");
      this.cancelButton.setText("Cancel");
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(10, 0, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(1, 2, 5, 5));
      var2.add(this.addButton);
      var2.add(this.cancelButton);
      var1.add(var2, "East");
      return var1;
   }

   private JPanel createDestinationFolderPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 0, 0, 0));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new TitledBorder("Diff Destination"));
      this.destinationDirName.setPreferredSize(new Dimension(this.destinationDirName.getPreferredSize().width, ROW_HEIGHT));
      var2.add(this.destinationDirName, "North");
      var1.add(var2, "North");
      return var1;
   }

   private JPanel createExportSourcesPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder("Export Binaries"));
      JPanel var2 = new JPanel(new GridLayout(2, 1, 5, 5));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary Callgraph:", LABEL_WIDTH, this.primaryExportBinary, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary Callgraph:", LABEL_WIDTH, this.secondaryExportBinary, ROW_HEIGHT));
      var1.add(var2, "North");
      return var1;
   }

   private JPanel createFileChooserPane() {
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new TitledBorder("Diff Matches Database:"));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Choose Diff:", LABEL_WIDTH, this.diffChooser, ROW_HEIGHT), "North");
      var1.add(var2, "North");
      var1.add(this.createExportSourcesPanel(), "Center");
      return var1;
   }

   private Pair getIDBName(File var1) {
      MatchesDatabase var2 = new MatchesDatabase(var1);
      Throwable var3 = null;

      Pair var5;
      try {
         String[] var4 = var2.getIDBNames();
         var5 = new Pair(var4[0], var4[1]);
      } catch (Throwable var14) {
         var3 = var14;
         throw var14;
      } finally {
         if(var2 != null) {
            if(var3 != null) {
               try {
                  var2.close();
               } catch (Throwable var13) {
                  var3.addSuppressed(var13);
               }
            } else {
               var2.close();
            }
         }

      }

      return var5;
   }

   private void updatedExportedSources() {
      // $FF: Couldn't be decompiled
   }

   private boolean validateDiffSources() {
      File var1 = this.getMatchesBinary();
      File var2 = this.getBinExportBinary(ESide.PRIMARY);
      File var3 = this.getBinExportBinary(ESide.SECONDARY);
      File var4 = this.getDestinationDirectory();
      String var5 = "";
      if(var1 == null) {
         var5 = "Can\'t add diff to workspace. Can\'t find matches binary.";
      } else if(var2 == null) {
         var5 = "Can\'t add diff to workspace. Can\'t find primary BinExport binary.";
      } else if(var3 == null) {
         var5 = "Can\'t add diff to workspace. Can\'t find secondary BinExport binary.";
      } else if(var4 == null) {
         var5 = "Can\'t add diff to workspace. Destination folder is not defined.";
      } else if(this.workspace.containsDiff(var1.getPath())) {
         var5 = "Diff is already added to the workspace.";
      } else if(var4.exists() && var4.list().length != 0) {
         if(!var1.getParent().equals(var4.getPath())) {
            var5 = "Can\'t add diff to workspace. Destination folder already exists in workspace.";
         } else if(this.workspace.containsDiff(var1.getPath())) {
            var5 = "Can\'t add diff to workspace. Diff is already part of the current workspace.";
         }
      } else {
         try {
            if(!var4.mkdir()) {
               var5 = "Can\'t add diff to workspace. Destination folder cannot be created.";
            }
         } catch (Exception var10) {
            var5 = "Can\'t add diff to workspace. Destination folder cannot be created.";
         } finally {
            var4.delete();
         }
      }

      if(!var5.equals("")) {
         CMessageBox.showInformation(this, var5);
      }

      return var5.equals("");
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      var1.add(this.createFileChooserPane(), "North");
      var1.add(this.createDestinationFolderPanel(), "Center");
      var1.add(this.createButtonPanel(), "South");
      this.primaryExportBinary.setEditable(false);
      this.secondaryExportBinary.setEditable(false);
      this.primaryExportBinary.setBorder(new LineBorder(Color.GRAY));
      this.secondaryExportBinary.setBorder(new LineBorder(Color.GRAY));
      this.add(var1, "Center");
   }

   public boolean getAddButtonPressed() {
      return this.diffPressed;
   }

   public File getBinExportBinary(ESide var1) {
      String var2 = var1 == ESide.PRIMARY?this.primaryExportBinary.getText():this.secondaryExportBinary.getText();
      if(var2.endsWith(".BinExport")) {
         File var3 = new File(var2);
         if(var3.exists()) {
            return var3;
         }
      }

      return null;
   }

   public File getDestinationDirectory() {
      return this.destinationDirName.getText().equals("")?null:new File(String.format("%s%s%s", new Object[]{this.workspace.getWorkspaceDirPath(), File.separator, this.destinationDirName.getText()}));
   }

   public File getMatchesBinary() {
      File var1 = new File(this.diffChooser.getText());
      return var1.exists()?var1:null;
   }

   // $FF: synthetic method
   static JButton access$200(AddDiffDialog var0) {
      return var0.addButton;
   }

   // $FF: synthetic method
   static boolean access$300(AddDiffDialog var0) {
      return var0.validateDiffSources();
   }

   // $FF: synthetic method
   static boolean access$402(AddDiffDialog var0, boolean var1) {
      return var0.diffPressed = var1;
   }

   // $FF: synthetic method
   static File access$500(Component var0, String var1, File var2) {
      return chooseFile(var0, var1, var2);
   }

   // $FF: synthetic method
   static FileChooserPanel access$600(AddDiffDialog var0) {
      return var0.diffChooser;
   }

   // $FF: synthetic method
   static void access$700(AddDiffDialog var0) {
      var0.updatedExportedSources();
   }
}
