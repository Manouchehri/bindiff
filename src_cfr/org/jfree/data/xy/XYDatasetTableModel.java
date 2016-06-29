/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.TableXYDataset;

public class XYDatasetTableModel
extends AbstractTableModel
implements TableModel,
DatasetChangeListener {
    TableXYDataset model = null;

    public XYDatasetTableModel() {
    }

    public XYDatasetTableModel(TableXYDataset tableXYDataset) {
        this();
        this.model = tableXYDataset;
        this.model.addChangeListener(this);
    }

    public void setModel(TableXYDataset tableXYDataset) {
        this.model = tableXYDataset;
        this.model.addChangeListener(this);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (this.model != null) return this.model.getItemCount();
        return 0;
    }

    @Override
    public int getColumnCount() {
        if (this.model != null) return this.model.getSeriesCount() + 1;
        return 0;
    }

    @Override
    public String getColumnName(int n2) {
        if (this.model == null) {
            return super.getColumnName(n2);
        }
        if (n2 >= 1) return this.model.getSeriesKey(n2 - 1).toString();
        return "X Value";
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (this.model == null) {
            return null;
        }
        if (n3 >= 1) return this.model.getY(n3 - 1, n2);
        return this.model.getX(0, n2);
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        this.fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int n2, int n3) {
        return false;
    }

    @Override
    public void setValueAt(Object object, int n2, int n3) {
        if (!this.isCellEditable(n2, n3)) return;
    }
}

