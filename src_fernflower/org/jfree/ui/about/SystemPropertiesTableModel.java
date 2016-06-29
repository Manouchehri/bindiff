package org.jfree.ui.about;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import org.jfree.ui.SortableTableModel;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemProperty;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemPropertyComparator;

public class SystemPropertiesTableModel extends SortableTableModel {
   private List properties = new ArrayList();
   private String nameColumnLabel;
   private String valueColumnLabel;

   public SystemPropertiesTableModel() {
      try {
         Properties var1 = System.getProperties();
         Iterator var2 = var1.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            String var4 = System.getProperty(var3);
            SystemPropertiesTableModel$SystemProperty var5 = new SystemPropertiesTableModel$SystemProperty(var3, var4);
            this.properties.add(var5);
         }
      } catch (SecurityException var6) {
         ;
      }

      Collections.sort(this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(true));
      String var7 = "org.jfree.ui.about.resources.AboutResources";
      ResourceBundle var8 = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      this.nameColumnLabel = var8.getString("system-properties-table.column.name");
      this.valueColumnLabel = var8.getString("system-properties-table.column.value");
   }

   public boolean isSortable(int var1) {
      return var1 == 0;
   }

   public int getRowCount() {
      return this.properties.size();
   }

   public int getColumnCount() {
      return 2;
   }

   public String getColumnName(int var1) {
      return var1 == 0?this.nameColumnLabel:this.valueColumnLabel;
   }

   public Object getValueAt(int var1, int var2) {
      SystemPropertiesTableModel$SystemProperty var3 = (SystemPropertiesTableModel$SystemProperty)this.properties.get(var1);
      return var2 == 0?var3.getName():(var2 == 1?var3.getValue():null);
   }

   public void sortByColumn(int var1, boolean var2) {
      if(this.isSortable(var1)) {
         super.sortByColumn(var1, var2);
         Collections.sort(this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(var2));
      }

   }
}
