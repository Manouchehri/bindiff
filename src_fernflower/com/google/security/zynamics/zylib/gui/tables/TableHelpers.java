package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class TableHelpers {
   @Deprecated
   public static int[] normalizeRows(CTableSorter var0, int[] var1) {
      int[] var2 = new int[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = var0.modelIndex(var1[var3]);
      }

      return var2;
   }

   public static void selectClickedRow(JTable var0, MouseEvent var1) {
      int var2 = var0.rowAtPoint(var1.getPoint());
      if(var2 != -1) {
         var0.setRowSelectionInterval(var2, var2);
      }
   }
}
