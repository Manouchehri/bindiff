package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalPrimaryFileChooserListener;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$InternalSecondaryFileChooserListener;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CFileChooser$FileExtension;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class NewDiffDialog extends BaseDialog {
   private static int IDB_FILEFILTER_INDEX = 0;
   private static int TEXTFIELD_WITH = 500;
   private static int LABEL_WITH = 180;
   private static int ROW_HEIGHT = 25;
   private final File workspaceDir;
   private final NewDiffDialog$InternalPrimaryFileChooserListener primaryFileListener = new NewDiffDialog$InternalPrimaryFileChooserListener(this, (NewDiffDialog$1)null);
   private final NewDiffDialog$InternalSecondaryFileChooserListener secondaryFileListener = new NewDiffDialog$InternalSecondaryFileChooserListener(this, (NewDiffDialog$1)null);
   private final NewDiffDialog$InternalButtonListener buttonListener = new NewDiffDialog$InternalButtonListener(this, (NewDiffDialog$1)null);
   private final JButton diffButton;
   private final JButton cancelButton;
   private final FileChooserPanel primaryChooser;
   private final FileChooserPanel secondaryChooser;
   private final JTextField destinationDirName;
   private boolean diffPressed;
   private File lastSelectedFile;

   public NewDiffDialog(Window var1, File var2) {
      super(var1, "New Diff");
      this.diffButton = new JButton(this.buttonListener);
      this.cancelButton = new JButton(this.buttonListener);
      this.primaryChooser = new FileChooserPanel("", this.primaryFileListener, "...", TEXTFIELD_WITH, ROW_HEIGHT, 0);
      this.secondaryChooser = new FileChooserPanel("", this.secondaryFileListener, "...", TEXTFIELD_WITH, ROW_HEIGHT, 0);
      this.destinationDirName = new JTextField();
      this.diffPressed = false;
      this.lastSelectedFile = null;
      this.workspaceDir = (File)Preconditions.checkNotNull(var2);
      Preconditions.checkArgument(var2.exists(), "Workspace directory doesn\'t exist.");
      this.init();
      this.pack();
      GuiHelper.centerChildToParent(var1, this, true);
      this.setVisible(true);
   }

   private static File chooseFile(Component var0, String var1, File var2, int var3) {
      CFileChooser var4 = new CFileChooser(new CFileChooser$FileExtension[]{new CFileChooser$FileExtension(String.format("IDA Pro Database/BinExport Binary (*.%s;*.%s;*.%s)", new Object[]{"idb", "i64", "BinExport"}), new String[]{"idb", "i64", "BinExport"})});
      var4.setCurrentDirectory(var2);
      var4.setFileFilter(var3);
      var4.setApproveButtonText("Ok");
      var4.setDialogTitle(var1);
      return var4.showOpenDialog(var0) == 0?var4.getSelectedFile():null;
   }

   private Component createButtonPanel() {
      this.diffButton.setText("Diff");
      this.cancelButton.setText("Cancel");
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(10, 0, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(1, 2, 5, 5));
      var2.add(this.diffButton);
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
      var1.add(var2, "Center");
      return var1;
   }

   private JPanel createFilesChooserPane() {
      JPanel var1 = new JPanel(new GridLayout(2, 1, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(1, 1, 5, 5));
      JPanel var3 = new JPanel(new GridLayout(1, 1, 5, 5));
      var2.setBorder(new TitledBorder("Primary Source"));
      var3.setBorder(new TitledBorder("Secondary Source"));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary file:", LABEL_WITH, this.primaryChooser, ROW_HEIGHT));
      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary file:", LABEL_WITH, this.secondaryChooser, ROW_HEIGHT));
      var1.add(var2);
      var1.add(var3);
      return var1;
   }

   private boolean isDiffExisting(File var1) {
      String[] var2 = var1.list();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if(var5.toLowerCase().endsWith("BinDiff".toLowerCase())) {
            return true;
         }
      }

      return false;
   }

   private void updateDestinationFolder() {
      String var1 = DiffDirectories.getDiffDestinationDirectoryName(this.primaryChooser.getText(), this.secondaryChooser.getText());
      this.destinationDirName.setText(var1);
   }

   private boolean validateDiffSources() {
      File var1 = this.getIdb(ESide.PRIMARY);
      File var2 = this.getBinExportBinary(ESide.PRIMARY);
      if(var1 == null && var2 == null) {
         CMessageBox.showInformation(this, "Primary source files not set or do not exist.");
         return false;
      } else {
         File var3 = this.getIdb(ESide.SECONDARY);
         File var4 = this.getBinExportBinary(ESide.SECONDARY);
         if(var3 == null && var4 == null) {
            CMessageBox.showInformation(this, "Secondary source files not set or do not exist.");
            return false;
         } else {
            File var5 = this.getDestinationDirectory();
            if(var5 == null) {
               CMessageBox.showInformation(this, "Destination folder is not set.");
               return false;
            } else if(var5.exists() && this.isDiffExisting(var5)) {
               CMessageBox.showInformation(this, "Diff file already exists in the workspace.");
               return false;
            } else {
               try {
                  if(!var5.exists() && !var5.mkdirs()) {
                     CMessageBox.showInformation(this, "Could not create destination folder.");
                     return false;
                  } else {
                     return true;
                  }
               } catch (SecurityException var7) {
                  CMessageBox.showInformation(this, "Could not create destination folder.");
                  return false;
               }
            }
         }
      }
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      var1.add(this.createFilesChooserPane(), "North");
      var1.add(this.createDestinationFolderPanel(), "Center");
      var1.add(this.createButtonPanel(), "South");
      this.add(var1, "Center");
   }

   public File getBinExportBinary(ESide var1) {
      File var2 = new File(var1 == ESide.PRIMARY?this.primaryChooser.getText():this.secondaryChooser.getText());
      return var2.exists()?var2:null;
   }

   public File getDestinationDirectory() {
      return this.destinationDirName.getText().equals("")?null:new File(String.format("%s%s%s", new Object[]{this.workspaceDir.getPath(), File.separator, this.destinationDirName.getText()}));
   }

   public boolean getDiffButtonPressed() {
      return this.diffPressed;
   }

   public File getIdb(ESide var1) {
      String var2 = var1 == ESide.PRIMARY?this.primaryChooser.getText():this.secondaryChooser.getText();
      if(var2.endsWith(".idb") || var2.endsWith(".i64")) {
         File var3 = new File(var2);
         if(var3.exists()) {
            return var3;
         }
      }

      return null;
   }

   // $FF: synthetic method
   static JButton access$300(NewDiffDialog var0) {
      return var0.diffButton;
   }

   // $FF: synthetic method
   static boolean access$400(NewDiffDialog var0) {
      return var0.validateDiffSources();
   }

   // $FF: synthetic method
   static boolean access$502(NewDiffDialog var0, boolean var1) {
      return var0.diffPressed = var1;
   }

   // $FF: synthetic method
   static File access$600(NewDiffDialog var0) {
      return var0.lastSelectedFile;
   }

   // $FF: synthetic method
   static int access$700() {
      return IDB_FILEFILTER_INDEX;
   }

   // $FF: synthetic method
   static File access$800(Component var0, String var1, File var2, int var3) {
      return chooseFile(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static FileChooserPanel access$900(NewDiffDialog var0) {
      return var0.primaryChooser;
   }

   // $FF: synthetic method
   static File access$602(NewDiffDialog var0, File var1) {
      return var0.lastSelectedFile = var1;
   }

   // $FF: synthetic method
   static void access$1000(NewDiffDialog var0) {
      var0.updateDestinationFolder();
   }

   // $FF: synthetic method
   static FileChooserPanel access$1100(NewDiffDialog var0) {
      return var0.secondaryChooser;
   }
}
