package org.jfree.ui.about;

import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import org.jfree.ui.about.Contributor;

public class ContributorsTableModel extends AbstractTableModel {
   private List contributors;
   private String nameColumnLabel;
   private String contactColumnLabel;

   public ContributorsTableModel(List var1) {
      this.contributors = var1;
      String var2 = "org.jfree.ui.about.resources.AboutResources";
      ResourceBundle var3 = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      this.nameColumnLabel = var3.getString("contributors-table.column.name");
      this.contactColumnLabel = var3.getString("contributors-table.column.contact");
   }

   public int getRowCount() {
      return this.contributors.size();
   }

   public int getColumnCount() {
      return 2;
   }

   public String getColumnName(int var1) {
      String var2 = null;
      switch(var1) {
      case 0:
         var2 = this.nameColumnLabel;
         break;
      case 1:
         var2 = this.contactColumnLabel;
      }

      return var2;
   }

   public Object getValueAt(int var1, int var2) {
      String var3 = null;
      Contributor var4 = (Contributor)this.contributors.get(var1);
      if(var2 == 0) {
         var3 = var4.getName();
      } else if(var2 == 1) {
         var3 = var4.getEmail();
      }

      return var3;
   }
}
