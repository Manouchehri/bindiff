package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.ui.about.LibraryTableModel;
import org.jfree.ui.about.ProjectInfo;

public class LibraryPanel extends JPanel {
   private JTable table;
   private LibraryTableModel model;

   public LibraryPanel(List var1) {
      this.setLayout(new BorderLayout());
      this.model = new LibraryTableModel(var1);
      this.table = new JTable(this.model);
      this.add(new JScrollPane(this.table));
   }

   public LibraryPanel(ProjectInfo var1) {
      this(getLibraries(var1));
   }

   private static List getLibraries(ProjectInfo var0) {
      if(var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var1 = new ArrayList();
         collectLibraries(var0, var1);
         return var1;
      }
   }

   private static void collectLibraries(ProjectInfo var0, List var1) {
      org.jfree.base.Library[] var2 = var0.getLibraries();

      int var3;
      org.jfree.base.Library var4;
      for(var3 = 0; var3 < var2.length; ++var3) {
         var4 = var2[var3];
         if(!var1.contains(var4)) {
            var1.add(var4);
            if(var4 instanceof ProjectInfo) {
               collectLibraries((ProjectInfo)var4, var1);
            }
         }
      }

      var2 = var0.getOptionalLibraries();

      for(var3 = 0; var3 < var2.length; ++var3) {
         var4 = var2[var3];
         if(!var1.contains(var4)) {
            var1.add(var4);
            if(var4 instanceof ProjectInfo) {
               collectLibraries((ProjectInfo)var4, var1);
            }
         }
      }

   }

   public LibraryTableModel getModel() {
      return this.model;
   }

   protected JTable getTable() {
      return this.table;
   }
}
