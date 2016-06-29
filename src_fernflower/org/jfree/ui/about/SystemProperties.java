package org.jfree.ui.about;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.ui.SortableTable;
import org.jfree.ui.about.SystemPropertiesTableModel;

public class SystemProperties {
   public static SortableTable createSystemPropertiesTable() {
      SystemPropertiesTableModel var0 = new SystemPropertiesTableModel();
      SortableTable var1 = new SortableTable(var0);
      TableColumnModel var2 = var1.getColumnModel();
      TableColumn var3 = var2.getColumn(0);
      var3.setPreferredWidth(200);
      var3 = var2.getColumn(1);
      var3.setPreferredWidth(350);
      var1.setAutoResizeMode(2);
      return var1;
   }
}
