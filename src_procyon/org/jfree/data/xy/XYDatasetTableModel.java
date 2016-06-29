package org.jfree.data.xy;

import javax.swing.table.*;
import org.jfree.data.general.*;

public class XYDatasetTableModel extends AbstractTableModel implements TableModel, DatasetChangeListener
{
    TableXYDataset model;
    
    public XYDatasetTableModel() {
        this.model = null;
    }
    
    public XYDatasetTableModel(final TableXYDataset model) {
        this();
        (this.model = model).addChangeListener(this);
    }
    
    public void setModel(final TableXYDataset model) {
        (this.model = model).addChangeListener(this);
        this.fireTableDataChanged();
    }
    
    public int getRowCount() {
        if (this.model == null) {
            return 0;
        }
        return this.model.getItemCount();
    }
    
    public int getColumnCount() {
        if (this.model == null) {
            return 0;
        }
        return this.model.getSeriesCount() + 1;
    }
    
    public String getColumnName(final int n) {
        if (this.model == null) {
            return super.getColumnName(n);
        }
        if (n < 1) {
            return "X Value";
        }
        return this.model.getSeriesKey(n - 1).toString();
    }
    
    public Object getValueAt(final int n, final int n2) {
        if (this.model == null) {
            return null;
        }
        if (n2 < 1) {
            return this.model.getX(0, n);
        }
        return this.model.getY(n2 - 1, n);
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        this.fireTableDataChanged();
    }
    
    public boolean isCellEditable(final int n, final int n2) {
        return false;
    }
    
    public void setValueAt(final Object o, final int n, final int n2) {
        if (this.isCellEditable(n, n2)) {}
    }
}
