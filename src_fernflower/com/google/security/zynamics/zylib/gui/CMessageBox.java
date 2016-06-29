package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.general.Pair;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public final class CMessageBox {
   public static final String DEFAULT_WINDOW_TITLE_PROPERTY = String.valueOf(CMessageBox.class.getCanonicalName()).concat(".DEFAULT_WINDOW_TITLE");

   private static boolean isIconified(Component var0) {
      return var0 != null && var0 instanceof Frame?(((Frame)var0).getExtendedState() & 1) != 0:false;
   }

   public static int showCustomQuestionMessageBox(Component var0, String var1, String var2, JButton[] var3, JButton var4) {
      return JOptionPane.showOptionDialog(var0, var1, var2, -1, 3, (Icon)null, var3, var4);
   }

   public static void showError(Component var0, String var1) {
      JOptionPane.showMessageDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0);
   }

   public static void showInformation(Component var0, String var1) {
      JOptionPane.showMessageDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 1);
   }

   public static void showWarning(Component var0, String var1) {
      JOptionPane.showMessageDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 2);
   }

   public static int showYesNoCancelQuestion(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 1, 3);
   }

   public static int showYesNoError(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 0);
   }

   public static int showYesNoQuestion(Component var0, String var1) {
      return ((Integer)showYesNoQuestionWithCheckbox(var0, var1, (String)null).first()).intValue();
   }

   public static Pair showYesNoQuestionWithCheckbox(Component var0, String var1, String var2) {
      JCheckBox var3 = null;
      Object var4;
      if(var2 != null) {
         var3 = new JCheckBox(var2);
         var4 = new Object[]{var1, var3};
      } else {
         var4 = var1;
      }

      int var5 = JOptionPane.showConfirmDialog(isIconified(var0)?null:var0, var4, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 3);
      return Pair.make(Integer.valueOf(var5), Boolean.valueOf(var2 != null?var3.isSelected():false));
   }

   public static int showYesNoWarning(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(isIconified(var0)?null:var0, var1, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 2);
   }
}
