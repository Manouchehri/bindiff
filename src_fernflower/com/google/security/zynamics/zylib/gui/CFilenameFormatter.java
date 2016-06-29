package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$1;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$FilenameFilter;
import java.io.File;
import java.io.IOException;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DocumentFilter;

public class CFilenameFormatter extends AbstractFormatter {
   private static final int MAX_CHAR = 255;
   private final CFilenameFormatter$FilenameFilter filter = new CFilenameFormatter$FilenameFilter(this, (CFilenameFormatter$1)null);
   private final File m_directory;

   public CFilenameFormatter(File var1) {
      Preconditions.checkArgument(var1.exists(), "Error: Direcctory must exist.");
      this.m_directory = var1;
   }

   private boolean isValid(String var1, int var2) {
      if(this.getFormattedTextField().getText().length() - var2 + var1.length() <= 255 && var1.indexOf("\\") <= -1 && var1.indexOf("/") <= -1) {
         String var4 = String.valueOf(this.m_directory.getPath());
         String var5 = String.valueOf(File.separator);
         File var3 = new File((new StringBuilder(0 + String.valueOf(var4).length() + String.valueOf(var5).length() + String.valueOf(var1).length())).append(var4).append(var5).append(var1).toString());
         if(!var3.exists()) {
            try {
               if(!var3.createNewFile()) {
                  this.invalidEdit();
                  return false;
               }

               var3.delete();
            } catch (IOException var6) {
               this.invalidEdit();
               return false;
            }
         }

         return true;
      } else {
         this.invalidEdit();
         return false;
      }
   }

   protected DocumentFilter getDocumentFilter() {
      return this.filter;
   }

   public Object stringToValue(String var1) {
      return var1;
   }

   public String valueToString(Object var1) {
      return var1 == null?null:var1.toString();
   }

   // $FF: synthetic method
   static boolean access$100(CFilenameFormatter var0, String var1, int var2) {
      return var0.isValid(var1, var2);
   }
}
