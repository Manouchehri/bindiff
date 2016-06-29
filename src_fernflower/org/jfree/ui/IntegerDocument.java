package org.jfree.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class IntegerDocument extends PlainDocument {
   public void insertString(int var1, String var2, AttributeSet var3) {
      super.insertString(var1, var2, var3);
      if(var2 != null && (!var2.equals("-") || var1 != 0 || var2.length() >= 2)) {
         try {
            Integer.parseInt(this.getText(0, this.getLength()));
         } catch (NumberFormatException var5) {
            this.remove(var1, var2.length());
         }
      }

   }
}
