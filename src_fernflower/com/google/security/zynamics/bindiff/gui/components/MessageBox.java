package com.google.security.zynamics.bindiff.gui.components;

import java.awt.Component;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class MessageBox {
   private static Component validateParent(Component var0) {
      return isIconified(var0)?null:var0;
   }

   public static boolean isIconified(Component var0) {
      return var0 != null && var0 instanceof Frame?((Frame)var0).getExtendedState() == 1 || ((Frame)var0).getExtendedState() == 7:false;
   }

   public static void showError(Component var0, String var1) {
      JOptionPane.showMessageDialog(validateParent(var0), var1, "BinDiff", 0);
   }

   public static void showInformation(Component var0, String var1) {
      JOptionPane.showMessageDialog(validateParent(var0), var1, "BinDiff", 1);
   }

   public static void showWarning(Component var0, String var1) {
      JOptionPane.showMessageDialog(validateParent(var0), var1, "BinDiff", 2);
   }

   public static int showYesNoCancelQuestion(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(validateParent(var0), var1, "BinDiff", 1, 3);
   }

   public static int showYesNoError(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(validateParent(var0), var1, "BinDiff", 0, 0);
   }

   public static int showYesNoQuestion(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(validateParent(var0), var1, "BinDiff", 0, 3);
   }

   public static int showYesNoWarning(Component var0, String var1) {
      return JOptionPane.showConfirmDialog(validateParent(var0), var1, "BinDiff", 0, 2);
   }
}
