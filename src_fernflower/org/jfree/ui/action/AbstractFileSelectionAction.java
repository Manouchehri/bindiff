package org.jfree.ui.action;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import org.jfree.ui.ExtensionFileFilter;
import org.jfree.ui.action.AbstractActionDowngrade;
import org.jfree.util.StringUtils;

public abstract class AbstractFileSelectionAction extends AbstractActionDowngrade {
   private JFileChooser fileChooser;
   private Component parent;

   public AbstractFileSelectionAction(Component var1) {
      this.parent = var1;
   }

   protected abstract String getFileExtension();

   protected abstract String getFileDescription();

   protected File getCurrentDirectory() {
      return new File(".");
   }

   protected File performSelectFile(File var1, int var2, boolean var3) {
      if(this.fileChooser == null) {
         this.fileChooser = this.createFileChooser();
      }

      this.fileChooser.setSelectedFile(var1);
      this.fileChooser.setDialogType(var2);
      int var4 = this.fileChooser.showDialog(this.parent, (String)null);
      if(var4 == 0) {
         File var5 = this.fileChooser.getSelectedFile();
         String var6 = var5.getAbsolutePath();
         if(!StringUtils.endsWithIgnoreCase(var6, this.getFileExtension())) {
            var6 = var6 + this.getFileExtension();
         }

         return new File(var6);
      } else {
         return null;
      }
   }

   protected JFileChooser createFileChooser() {
      JFileChooser var1 = new JFileChooser();
      var1.addChoosableFileFilter(new ExtensionFileFilter(this.getFileDescription(), this.getFileExtension()));
      var1.setMultiSelectionEnabled(false);
      var1.setCurrentDirectory(this.getCurrentDirectory());
      return var1;
   }
}
