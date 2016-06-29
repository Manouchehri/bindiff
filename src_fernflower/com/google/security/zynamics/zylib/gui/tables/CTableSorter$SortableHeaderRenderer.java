package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class CTableSorter$SortableHeaderRenderer implements TableCellRenderer {
   protected TableCellRenderer tableCellRenderer;
   // $FF: synthetic field
   final CTableSorter this$0;

   public CTableSorter$SortableHeaderRenderer(CTableSorter var1, TableCellRenderer var2) {
      this.this$0 = var1;
      this.tableCellRenderer = var2;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      Component var7 = this.tableCellRenderer.getTableCellRendererComponent(var1, var2, var3, var4, var5, var6);
      if(var7 instanceof JLabel) {
         JLabel var8 = (JLabel)var7;
         var8.setHorizontalTextPosition(2);
         int var9 = var1.convertColumnIndexToModel(var6);
         var8.setIcon(this.this$0.getHeaderRendererIcon(var9, var8.getFont().getSize()));
      }

      return var7;
   }
}
