package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;

public class JTextFieldLimit extends DefaultStyledDocument {
   private static final long serialVersionUID = -8124048672190684534L;
   private final int limit;

   public JTextFieldLimit() {
      this(30000);
   }

   public JTextFieldLimit(int var1) {
      this.limit = var1;
   }

   public void insertString(int var1, String var2, AttributeSet var3) {
      if(var2 != null) {
         if(this.getLength() + var2.length() <= this.limit) {
            super.insertString(var1, var2, var3);
         }

      }
   }
}
