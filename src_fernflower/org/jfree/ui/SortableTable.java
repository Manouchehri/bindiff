package org.jfree.ui;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import org.jfree.ui.SortButtonRenderer;
import org.jfree.ui.SortableTableHeaderListener;
import org.jfree.ui.SortableTableModel;

public class SortableTable extends JTable {
   private SortableTableHeaderListener headerListener;

   public SortableTable(SortableTableModel var1) {
      super(var1);
      SortButtonRenderer var2 = new SortButtonRenderer();
      TableColumnModel var3 = this.getColumnModel();

      for(int var4 = 0; var4 < var3.getColumnCount(); ++var4) {
         var3.getColumn(var4).setHeaderRenderer(var2);
      }

      JTableHeader var5 = this.getTableHeader();
      this.headerListener = new SortableTableHeaderListener(var1, var2);
      var5.addMouseListener(this.headerListener);
      var5.addMouseMotionListener(this.headerListener);
      var1.sortByColumn(0, true);
   }

   public void setSortableModel(SortableTableModel var1) {
      super.setModel(var1);
      this.headerListener.setTableModel(var1);
      SortButtonRenderer var2 = new SortButtonRenderer();
      TableColumnModel var3 = this.getColumnModel();

      for(int var4 = 0; var4 < var3.getColumnCount(); ++var4) {
         var3.getColumn(var4).setHeaderRenderer(var2);
      }

      var1.sortByColumn(0, true);
   }
}
