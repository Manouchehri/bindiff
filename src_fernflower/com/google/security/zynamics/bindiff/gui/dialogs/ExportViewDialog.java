package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$InternalDestinationDirectoryListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ExportViewDialog extends BaseDialog {
   private static int DIALOG_WIDTH = 600;
   private static int DIALOG_HEIGHT = 263;
   private static int LABEL_WIDTH = 200;
   private static int ROW_HEIGHT = 25;
   private final Window window;
   private final String description;
   private final FileChooserPanel destinationChooserPanel;
   private final JTextField primaryImageName;
   private final JTextField secondaryImageName;
   private final JTextField combinedImageName;
   private final JComboBox imageFormat;
   private final JComboBox captureRegion;
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final ActionListener directoryChooserListener = new ExportViewDialog$InternalDestinationDirectoryListener(this, (ExportViewDialog$1)null);
   private final ActionListener buttonListener = new ExportViewDialog$InternalButtonListener(this, (ExportViewDialog$1)null);
   private boolean okPressed = false;

   public ExportViewDialog(Window var1, String var2, String var3, File var4, String var5) {
      // $FF: Couldn't be decompiled
   }

   private boolean confirmOverwrites() {
      String var1 = "";
      File var2 = this.getPrimaryImageFile();
      String var4;
      if(var2.exists()) {
         String var3 = String.valueOf(var1);
         var4 = String.valueOf(var2.getPath());
         var1 = (new StringBuilder(1 + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var3).append(var4).append("\n").toString();
      }

      File var7 = this.getSecondaryImageFile();
      String var5;
      if(var7.exists()) {
         var4 = String.valueOf(var1);
         var5 = String.valueOf(var7.getPath());
         var1 = (new StringBuilder(1 + String.valueOf(var4).length() + String.valueOf(var5).length())).append(var4).append(var5).append("\n").toString();
      }

      File var8 = this.getCombinedImageFile();
      if(var8.exists()) {
         var5 = String.valueOf(var1);
         String var6 = String.valueOf(var8.getPath());
         var1 = (new StringBuilder(1 + String.valueOf(var5).length() + String.valueOf(var6).length())).append(var5).append(var6).append("\n").toString();
      }

      return !var1.equals("")?CMessageBox.showYesNoQuestion(this, String.format("%s\n These files already exist. Overwrite?", new Object[]{var1})) == 0:true;
   }

   private File getImageFile(String var1) {
      // $FF: Couldn't be decompiled
   }

   private String selectDirectory(Window var1) {
      DirectoryChooser var2 = new DirectoryChooser("Choose Destination Directory");
      var2.setCurrentDirectory(new File(this.destinationChooserPanel.getText()));
      return var2.showOpenDialog(var1) == 0?var2.getSelectedFile().getAbsolutePath():null;
   }

   private boolean validatePaths() {
      try {
         File var1 = this.getPrimaryImageFile();
         if(var1.createNewFile()) {
            var1.delete();
         }

         File var2 = this.getSecondaryImageFile();
         if(var2.createNewFile()) {
            var2.delete();
         }

         File var3 = this.getCombinedImageFile();
         if(var3.createNewFile()) {
            var3.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(6, 1, 3, 3));
      var2.setBorder(new TitledBorder(this.description));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Destination directory:", LABEL_WIDTH, this.destinationChooserPanel, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Primary image name:", LABEL_WIDTH, this.primaryImageName, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Secondary image name:", LABEL_WIDTH, this.secondaryImageName, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Combined image name:", LABEL_WIDTH, this.combinedImageName, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Image file format:", LABEL_WIDTH, this.imageFormat, ROW_HEIGHT));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Clip Area:", LABEL_WIDTH, this.captureRegion, ROW_HEIGHT));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(8, 5, 5, 5));
      JPanel var4 = new JPanel(new GridLayout(1, 2, 5, 5));
      var4.add(this.okButton);
      var4.add(this.cancelButton);
      var3.add(var4, "East");
      var1.add(var2, "North");
      var1.add(var3, "South");
      this.add(var1, "Center");
      this.pack();
   }

   public void dispose() {
      this.okButton.removeActionListener(this.buttonListener);
      this.cancelButton.removeActionListener(this.buttonListener);
      super.dispose();
   }

   public File getCombinedImageFile() {
      return this.getImageFile(this.combinedImageName.getText());
   }

   public File getPrimaryImageFile() {
      return this.getImageFile(this.primaryImageName.getText());
   }

   public File getSecondaryImageFile() {
      return this.getImageFile(this.secondaryImageName.getText());
   }

   public boolean isCaptureAll() {
      return this.captureRegion.getSelectedIndex() == 0;
   }

   public boolean isCapturePart() {
      return this.captureRegion.getSelectedIndex() == 1;
   }

   public boolean isGIF() {
      return this.imageFormat.getSelectedIndex() == 2;
   }

   public boolean isJPEG() {
      return this.imageFormat.getSelectedIndex() == 1;
   }

   public boolean isOkPressed() {
      return this.okPressed;
   }

   public boolean isPNG() {
      return this.imageFormat.getSelectedIndex() == 0;
   }

   public boolean isSVG() {
      return this.imageFormat.getSelectedIndex() == 3;
   }

   // $FF: synthetic method
   static JButton access$200(ExportViewDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static boolean access$300(ExportViewDialog var0) {
      return var0.validatePaths();
   }

   // $FF: synthetic method
   static Window access$400(ExportViewDialog var0) {
      return var0.window;
   }

   // $FF: synthetic method
   static boolean access$500(ExportViewDialog var0) {
      return var0.confirmOverwrites();
   }

   // $FF: synthetic method
   static boolean access$602(ExportViewDialog var0, boolean var1) {
      return var0.okPressed = var1;
   }

   // $FF: synthetic method
   static String access$700(ExportViewDialog var0, Window var1) {
      return var0.selectDirectory(var1);
   }

   // $FF: synthetic method
   static FileChooserPanel access$800(ExportViewDialog var0) {
      return var0.destinationChooserPanel;
   }
}
