package org.jfree.data.xy;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.TableXYDataset;

public class XYDatasetTableModel extends AbstractTableModel implements TableModel, DatasetChangeListener {
   TableXYDataset model;

   public XYDatasetTableModel() {
      this.model = null;
   }

   public XYDatasetTableModel(TableXYDataset var1) {
      this();
      this.model = var1;
      this.model.addChangeListener(this);
   }

   public void setModel(TableXYDataset var1) {
      this.model = var1;
      this.model.addChangeListener(this);
      this.fireTableDataChanged();
   }

   public int getRowCount() {
      return this.model == null?0:this.model.getItemCount();
   }

   public int getColumnCount() {
      return this.model == null?0:this.model.getSeriesCount() + 1;
   }

   public String getColumnName(int var1) {
      return this.model == null?super.getColumnName(var1):(var1 < 1?"X Value":this.model.getSeriesKey(var1 - 1).toString());
   }

   public Object getValueAt(int var1, int var2) {
      return this.model == null?null:(var2 < 1?this.model.getX(0, var1):this.model.getY(var2 - 1, var1));
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      this.fireTableDataChanged();
   }

   public boolean isCellEditable(int var1, int var2) {
      return false;
   }

   public void setValueAt(Object var1, int var2, int var3) {
      if(this.isCellEditable(var2, var3)) {
         ;
      }

   }
}
