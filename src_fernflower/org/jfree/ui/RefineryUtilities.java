package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import org.jfree.ui.NumberCellRenderer;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public abstract class RefineryUtilities {
   protected static final LogContext logger;
   static Class class$org$jfree$ui$RefineryUtilities;
   static Class class$java$lang$Number;

   public static void centerFrameOnScreen(Window var0) {
      positionFrameOnScreen(var0, 0.5D, 0.5D);
   }

   public static void positionFrameOnScreen(Window var0, double var1, double var3) {
      Dimension var5 = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension var6 = var0.getSize();
      int var7 = Math.max(var5.width - var6.width, 0);
      int var8 = Math.max(var5.height - var6.height, 0);
      int var9 = (int)(var1 * (double)var7);
      int var10 = (int)(var3 * (double)var8);
      var0.setBounds(var9, var10, var6.width, var6.height);
   }

   public static void positionFrameRandomly(Window var0) {
      positionFrameOnScreen(var0, Math.random(), Math.random());
   }

   public static void centerDialogInParent(Dialog var0) {
      positionDialogRelativeToParent(var0, 0.5D, 0.5D);
   }

   public static void positionDialogRelativeToParent(Dialog var0, double var1, double var3) {
      Dimension var5 = var0.getSize();
      Container var6 = var0.getParent();
      Dimension var7 = var6.getSize();
      int var8 = var6.getX() - var5.width;
      int var9 = var6.getY() - var5.height;
      int var10 = var5.width + var7.width;
      int var11 = var5.height + var7.height;
      int var12 = var8 + (int)(var1 * (double)var10);
      int var13 = var9 + (int)(var3 * (double)var11);
      Dimension var14 = Toolkit.getDefaultToolkit().getScreenSize();
      var12 = Math.min(var12, var14.width - var5.width);
      var12 = Math.max(var12, 0);
      var13 = Math.min(var13, var14.height - var5.height);
      var13 = Math.max(var13, 0);
      var0.setBounds(var12, var13, var5.width, var5.height);
   }

   public static JPanel createTablePanel(TableModel var0) {
      JPanel var1 = new JPanel(new BorderLayout());
      JTable var2 = new JTable(var0);

      for(int var3 = 0; var3 < var0.getColumnCount(); ++var3) {
         TableColumn var4 = var2.getColumnModel().getColumn(var3);
         Class var5 = var0.getColumnClass(var3);
         if(var5.equals(class$java$lang$Number == null?(class$java$lang$Number = class$("java.lang.Number")):class$java$lang$Number)) {
            var4.setCellRenderer(new NumberCellRenderer());
         }
      }

      var1.add(new JScrollPane(var2));
      return var1;
   }

   public static JLabel createJLabel(String var0, Font var1) {
      JLabel var2 = new JLabel(var0);
      var2.setFont(var1);
      return var2;
   }

   public static JLabel createJLabel(String var0, Font var1, Color var2) {
      JLabel var3 = new JLabel(var0);
      var3.setFont(var1);
      var3.setForeground(var2);
      return var3;
   }

   public static JButton createJButton(String var0, Font var1) {
      JButton var2 = new JButton(var0);
      var2.setFont(var1);
      return var2;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      logger = Log.createContext(class$org$jfree$ui$RefineryUtilities == null?(class$org$jfree$ui$RefineryUtilities = class$("org.jfree.ui.RefineryUtilities")):class$org$jfree$ui$RefineryUtilities);
   }
}
