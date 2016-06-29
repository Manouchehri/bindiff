package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.Preconditions;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CTableSearcher {
   private final JTable m_Table;
   private final Window m_Frame;
   private int m_StartRow = 0;
   private final String m_title;

   public CTableSearcher(Window var1, String var2, JTable var3, int var4) {
      Preconditions.checkNotNull(var1, "Internal Error: Parent window can\'t be null");
      Preconditions.checkNotNull(var2, "Internal Error: Window title can\'t be null");
      Preconditions.checkNotNull(var3, "Internal Error: Table can\'t be null");
      this.m_Table = var3;
      this.m_Frame = var1;
      this.m_title = var2;
      this.m_StartRow = var4;
   }

   public void search() {
      String var1 = "";

      do {
         this.m_Frame.repaint();
         var1 = (String)JOptionPane.showInputDialog(this.m_Frame, "Search", this.m_title, 3, (Icon)null, (Object[])null, var1);
         if(var1 != null && var1.length() > 0 && !this.search(var1)) {
            JOptionPane.showMessageDialog(this.m_Frame, "Search string not found", this.m_title, 0);
         }
      } while(var1 != null && var1.length() > 0);

   }

   public boolean search(String var1) {
      int var2 = this.m_Table.getModel().getColumnCount();
      int var3 = this.m_Table.getRowCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         for(int var5 = 0; var5 < var2; ++var5) {
            Object var6 = this.m_Table.getModel().getValueAt((var4 + this.m_StartRow) % var3, var5);
            String var7 = var6 != null?var6.toString():"";
            if(var7.toLowerCase().contains(var1.toLowerCase())) {
               this.m_StartRow = (var4 + this.m_StartRow) % var3;
               this.m_Table.setRowSelectionInterval(this.m_StartRow, this.m_StartRow);
               this.m_Table.scrollRectToVisible(this.m_Table.getCellRect(this.m_StartRow, 0, true));
               ++this.m_StartRow;
               return true;
            }
         }
      }

      return false;
   }
}
