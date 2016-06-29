package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;

public class CopySelectionAction extends AbstractAction {
   private final JTable table;

   public CopySelectionAction(JTable var1) {
      super("Copy Selection");
      this.table = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int[] var2 = this.table.getSelectedRows();
      int var3 = this.table.getColumnCount();
      int[] var4 = new int[var3];
      int[] var5 = var2;
      int var6 = var2.length;

      int var7;
      int var8;
      int var9;
      int var10;
      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var5[var7];

         for(var9 = 0; var9 < var3; ++var9) {
            if(this.table.getValueAt(var8, var9) != null) {
               var10 = this.table.getValueAt(var8, var9).toString().length();
               if(var10 > var4[var9]) {
                  var4[var9] = var10;
               }
            }
         }
      }

      StringBuffer var13 = new StringBuffer();
      int[] var14 = var2;
      var7 = var2.length;

      for(var8 = 0; var8 < var7; ++var8) {
         var9 = var14[var8];

         for(var10 = 0; var10 < var3; ++var10) {
            if(this.table.getValueAt(var9, var10) != null) {
               String var11 = this.table.getValueAt(var9, var10).toString();
               int var12 = var4[var10] - var11.length();
               var13.append(var11);
               var13.append(Strings.repeat(" ", var12));
               if(var10 != var3 - 1) {
                  var13.append("  ");
               }
            }
         }

         var13.append("\n");
      }

      ClipboardHelpers.copyToClipboard(var13.toString());
   }
}
