package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.JCheckBoxComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class IdbPairTableModel extends AbstractTableModel {
   public static final int SELECTION = 0;
   public static final int IDB_NAME = 1;
   public static final int IDB_LOCATION = 2;
   public static final int DIFF_DESTINATION_DIR = 3;
   private final String[] COLUMNS = new String[]{"", "IDB Name", "IDB Location", "Diff Destination (Editable)"};
   private final List sorters = new ArrayList();
   private List tableData = new ArrayList();

   public IdbPairTableModel() {
      this.initSorters();
   }

   private void initSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new JCheckBoxComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new LexicalComparator()));
   }

   public int getColumnCount() {
      return this.COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return this.COLUMNS[var1];
   }

   public int getRowCount() {
      return this.tableData.size();
   }

   public List getSorters() {
      return this.sorters;
   }

   public List getTableData() {
      return this.tableData;
   }

   public Object getValueAt(int var1, int var2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isCellEditable(int var1, int var2) {
      return var2 == 0 || var2 == 3;
   }

   public void setTableData(List var1) {
      this.tableData = var1;
      this.fireTableDataChanged();
   }

   public void setValueAt(Object var1, int var2, int var3) {
      if(var3 == 0) {
         boolean var4 = ((JCheckBox)var1).isSelected();
         ((DiffPairTableData)this.tableData.get(var2)).getSelectionCheckBox().setSelected(var4);
      } else if(var3 == 3) {
         ((DiffPairTableData)this.tableData.get(var2)).setDestinationDirectory((String)var1);
      }

   }
}
