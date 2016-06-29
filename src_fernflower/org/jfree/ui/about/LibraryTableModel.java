package org.jfree.ui.about;

import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

public class LibraryTableModel extends AbstractTableModel {
   private org.jfree.base.Library[] libraries;
   private String nameColumnLabel;
   private String versionColumnLabel;
   private String licenceColumnLabel;
   private String infoColumnLabel;

   public LibraryTableModel(List var1) {
      this.libraries = (org.jfree.base.Library[])((org.jfree.base.Library[])var1.toArray(new org.jfree.base.Library[var1.size()]));
      String var2 = "org.jfree.ui.about.resources.AboutResources";
      ResourceBundle var3 = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
      this.nameColumnLabel = var3.getString("libraries-table.column.name");
      this.versionColumnLabel = var3.getString("libraries-table.column.version");
      this.licenceColumnLabel = var3.getString("libraries-table.column.licence");
      this.infoColumnLabel = var3.getString("libraries-table.column.info");
   }

   public int getRowCount() {
      return this.libraries.length;
   }

   public int getColumnCount() {
      return 4;
   }

   public String getColumnName(int var1) {
      String var2 = null;
      switch(var1) {
      case 0:
         var2 = this.nameColumnLabel;
         break;
      case 1:
         var2 = this.versionColumnLabel;
         break;
      case 2:
         var2 = this.licenceColumnLabel;
         break;
      case 3:
         var2 = this.infoColumnLabel;
      }

      return var2;
   }

   public Object getValueAt(int var1, int var2) {
      String var3 = null;
      org.jfree.base.Library var4 = this.libraries[var1];
      if(var2 == 0) {
         var3 = var4.getName();
      } else if(var2 == 1) {
         var3 = var4.getVersion();
      } else if(var2 == 2) {
         var3 = var4.getLicenceName();
      } else if(var2 == 3) {
         var3 = var4.getInfo();
      }

      return var3;
   }

   public org.jfree.base.Library[] getLibraries() {
      return (org.jfree.base.Library[])((org.jfree.base.Library[])this.libraries.clone());
   }
}
