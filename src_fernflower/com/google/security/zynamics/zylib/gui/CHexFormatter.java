package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CHexFormatter$1;
import com.google.security.zynamics.zylib.gui.CHexFormatter$HexFilter;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DocumentFilter;

public class CHexFormatter extends AbstractFormatter {
   private static final long serialVersionUID = 6996845563062947862L;
   private final CHexFormatter$HexFilter filter = new CHexFormatter$HexFilter(this, (CHexFormatter$1)null);
   private int maxSize = Integer.MAX_VALUE;

   public CHexFormatter() {
   }

   public CHexFormatter(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Maximum input size must be positive");
      this.maxSize = var1;
   }

   private boolean isValid(String var1, int var2) {
      if(this.getFormattedTextField().getText().length() - var2 + var1.length() > this.maxSize) {
         this.invalidEdit();
         return false;
      } else {
         for(int var3 = 0; var3 < var1.length(); ++var3) {
            char var4 = var1.charAt(var3);
            if(Character.digit(var4, 16) == -1) {
               this.invalidEdit();
               return false;
            }
         }

         return true;
      }
   }

   protected DocumentFilter getDocumentFilter() {
      return this.filter;
   }

   public Object stringToValue(String var1) {
      return var1;
   }

   public String valueToString(Object var1) {
      return (String)var1;
   }

   // $FF: synthetic method
   static boolean access$100(CHexFormatter var0, String var1, int var2) {
      return var0.isValid(var1, var2);
   }
}
