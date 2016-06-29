package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class TextHelpers {
   public static int getLineAtCaret(JTextComponent var0) {
      int var1 = var0.getCaretPosition();
      Element var2 = var0.getDocument().getDefaultRootElement();
      return var2.getElementIndex(var1) + 1;
   }

   public static int getNumberOfLines(JTextComponent var0) {
      Element var1 = var0.getDocument().getDefaultRootElement();
      return var1.getElementCount();
   }

   public static void insert(JTextComponent var0, int var1, String var2) {
      String var3 = var0.getText();
      String var4 = String.valueOf(var3.substring(0, var1));
      String var5 = String.valueOf(var3.substring(var1));
      var0.setText((new StringBuilder(0 + String.valueOf(var4).length() + String.valueOf(var2).length() + String.valueOf(var5).length())).append(var4).append(var2).append(var5).toString());
   }

   public static void insert(JTextComponent var0, String var1) {
      int var2 = var0.getSelectionStart();
      insert(var0, var2, var1);
      var0.setSelectionStart(var2 + var1.length());
      var0.setSelectionEnd(var2 + var1.length());
   }
}
