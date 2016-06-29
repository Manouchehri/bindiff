package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import java.io.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.table.*;
import java.util.*;

public class IdbPairTable extends JTable
{
    private final CTableSorter tableSorter;
    private final IdbPairTableModel model;
    
    public IdbPairTable(final File file, final IdbPairTableModel idbPairTableModel) {
        Preconditions.checkNotNull(file);
        this.model = (IdbPairTableModel)Preconditions.checkNotNull(idbPairTableModel);
        this.setModel(this.tableSorter = new CTableSorter(idbPairTableModel));
        this.tableSorter.setTableHeader(this.getTableHeader());
        for (final Pair pair : idbPairTableModel.getSorters()) {
            this.tableSorter.setColumnComparator((int)pair.first(), (Comparator)pair.second());
        }
        this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
        this.tableSorter.setTableHeader(this.getTableHeader());
        this.setRowSelectionAllowed(false);
        this.setColumnSelectionAllowed(false);
        this.setCellSelectionEnabled(false);
        final TableColumn column = this.getColumnModel().getColumn(0);
        final TableColumn column2 = this.getColumnModel().getColumn(1);
        final TableColumn column3 = this.getColumnModel().getColumn(2);
        final TableColumn column4 = this.getColumnModel().getColumn(3);
        column.setMaxWidth(30);
        column.setWidth(30);
        column.setMinWidth(30);
        column2.setMinWidth(150);
        column2.setWidth(150);
        column4.setMinWidth(375);
        column4.setWidth(375);
        column.setCellRenderer(new CheckboxCellRenderer());
        column.setCellEditor(new CheckboxCellEditor());
        final DefaultCellRenderer defaultCellRenderer = new DefaultCellRenderer();
        column2.setCellRenderer(defaultCellRenderer);
        column3.setCellRenderer(defaultCellRenderer);
        column4.setCellRenderer(new DestinationCellRenderer(file.getPath()));
    }
    
    @Override
    public CTableSorter getModel() {
        return this.tableSorter;
    }
    
    public IdbPairTableModel getTableModel() {
        return this.model;
    }
    
    public void setTableData(final List tableData) {
        this.model.setTableData(tableData);
    }
}
