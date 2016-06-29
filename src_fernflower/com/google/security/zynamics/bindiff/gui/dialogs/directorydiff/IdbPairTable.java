package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.CheckboxCellEditor;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.CheckboxCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DefaultCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DestinationCellRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.IdbPairTableModel;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class IdbPairTable extends JTable {
   private final CTableSorter tableSorter;
   private final IdbPairTableModel model;

   public IdbPairTable(File var1, IdbPairTableModel var2) {
      Preconditions.checkNotNull(var1);
      this.model = (IdbPairTableModel)Preconditions.checkNotNull(var2);
      this.tableSorter = new CTableSorter(var2);
      this.setModel(this.tableSorter);
      this.tableSorter.setTableHeader(this.getTableHeader());
      Iterator var3 = var2.getSorters().iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         this.tableSorter.setColumnComparator(((Integer)var4.first()).intValue(), (Comparator)var4.second());
      }

      this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
      this.tableSorter.setTableHeader(this.getTableHeader());
      this.setRowSelectionAllowed(false);
      this.setColumnSelectionAllowed(false);
      this.setCellSelectionEnabled(false);
      TableColumn var10 = this.getColumnModel().getColumn(0);
      TableColumn var11 = this.getColumnModel().getColumn(1);
      TableColumn var5 = this.getColumnModel().getColumn(2);
      TableColumn var6 = this.getColumnModel().getColumn(3);
      var10.setMaxWidth(30);
      var10.setWidth(30);
      var10.setMinWidth(30);
      var11.setMinWidth(150);
      var11.setWidth(150);
      var6.setMinWidth(375);
      var6.setWidth(375);
      CheckboxCellRenderer var7 = new CheckboxCellRenderer();
      var10.setCellRenderer(var7);
      var10.setCellEditor(new CheckboxCellEditor());
      DefaultCellRenderer var8 = new DefaultCellRenderer();
      var11.setCellRenderer(var8);
      var5.setCellRenderer(var8);
      DestinationCellRenderer var9 = new DestinationCellRenderer(var1.getPath());
      var6.setCellRenderer(var9);
   }

   public CTableSorter getModel() {
      return this.tableSorter;
   }

   public IdbPairTableModel getTableModel() {
      return this.model;
   }

   public void setTableData(List var1) {
      this.model.setTableData(var1);
   }
}
